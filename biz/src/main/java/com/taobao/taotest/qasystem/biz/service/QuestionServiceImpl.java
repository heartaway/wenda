package com.taobao.taotest.qasystem.biz.service;

import com.taobao.taotest.qasystem.biz.domain.AttentionDO;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
import com.taobao.taotest.qasystem.biz.domain.UserDO;
import com.taobao.taotest.qasystem.biz.manager.AttentionManager;
import com.taobao.taotest.qasystem.biz.manager.QuestionManager;
import com.taobao.taotest.qasystem.biz.manager.UserManager;
import com.taobao.taotest.qasystem.biz.model.AnswerModel;
import com.taobao.taotest.qasystem.biz.model.QuestionModel;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.result.ResultSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午9:45
 * To change this template use File | Settings | File Templates.
 */
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionManager questionManager;

    @Resource
    private UserManager userManager;

    @Resource
    private AnswerService answerService;

    @Resource
    private AttentionManager attentionManager;

    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    public List<QuestionModel> findQuestions4Simple(Integer userId) {
        List<QuestionModel> questionModelList = new ArrayList<QuestionModel>();
        QuestionModel questionModel;
        ResultDO<UserDO> userDOResultDO = userManager.queryUserInfoById(userId);
        ResultDO<List<QuestionDO>> questionList = questionManager.queryQuestionsByUserId(userId);
        if (questionList.getMessage() == null || questionList.getModule().size() == 0) {
            return questionModelList;
        }
        for (QuestionDO questionDO : questionList.getModule()) {
            questionModel = new QuestionModel();
            questionModel.setAttentionCount(questionDO.getAttentionCount());
            questionModel.setAnswerCount(questionDO.getAnswerCount());
            questionModel.setCreateTime(questionDO.getGmtCreate());
            questionModel.setQuestionUser(userDOResultDO.getModule());
            questionModel.setQuestionId(questionDO.getId());
            questionModel.setQuestionContent(questionDO.getContent());
            questionModel.setSameAskCount(questionDO.getSameAskCount());
            questionModelList.add(questionModel);
        }
        return questionModelList;
    }


    public ResultDO<QuestionModel> findQuestions4Detail(Integer questionId,UserDO userDO) {
        ResultDO<QuestionModel> result = new ResultSupport<QuestionModel>(false);
        QuestionModel questionModel;
        QuestionDO questionDO;
        ResultDO<QuestionDO> questionDOResultDO = questionManager.queryQuestionInfoById(questionId);
        if (!questionDOResultDO.isSuccess()) {
            result.addMessage("找不到相关问题！");
            return result;
        }
        questionDO = questionDOResultDO.getModule();
//        if(questionDO == null){
//            result.addMessage("找不到相关问题！");
//            return result;
//        }
        ResultDO<UserDO> questionUserDOResultDO = userManager.queryUserInfoById(questionDO.getUserId());
        if (!questionUserDOResultDO.isSuccess()) {
            result.addMessage("找不到问题的提问者！");
            return result;
        }
        UserDO questionUserDO = questionUserDOResultDO.getModule();
        List<AnswerModel> answerModels = answerService.findAnswers4Detail(questionId).getModule();
        if (questionDO.getTopAnswerId() != null && questionDO.getTopAnswerId() != 0) {
            answerModels = sortAnswer(answerModels, questionDO.getTopAnswerId());
        }
        questionModel = new QuestionModel();
        questionModel.setAttentionCount(questionDO.getAttentionCount());
        questionModel.setAnswerCount(questionDO.getAnswerCount());
        questionModel.setCreateTime(questionDO.getGmtCreate());
        questionModel.setQuestionUser(questionUserDO);
        questionModel.setQuestionId(questionDO.getId());
        questionModel.setQuestionContent(questionDO.getContent());
        questionModel.setSameAskCount(questionDO.getSameAskCount());
        questionModel.setCategoryId(questionDO.getCategoryId());
        questionModel.setAnswerModelList(answerModels);

        if (userDO != null) {
            AttentionDO attentionDO = attentionManager.queryAttentionByQuestionIdAndUserId(questionDO.getId(), userDO.getId()).getModule();
            if (attentionDO == null) {
                questionModel.setIsAttention(Boolean.FALSE);
            } else {
                questionModel.setIsAttention(Boolean.TRUE);
            }
        }
        result.setModule(questionModel);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    /**
     * 分页查询问题列表信息
     *
     * @param pageDO
     * @param userDO
     * @return
     */
    public ResultDO<List<QuestionModel>> queryAllQuestions4Paging(PageDO pageDO, UserDO userDO) {
        ResultDO<List<QuestionModel>> result = new ResultSupport<List<QuestionModel>>(false);
        List<QuestionModel> questionModelList = new ArrayList<QuestionModel>();
        ResultDO<List<QuestionDO>> resultQuestionDO = questionManager.queryAllQuestions4Paging(pageDO);
        if(resultQuestionDO==null || resultQuestionDO.getModule()==null){
            result.setModule(null);
            result.setSuccess(Boolean.FALSE);
            return result;
        }
        for (QuestionDO questionDO : resultQuestionDO.getModule()) {
            QuestionModel questionModel = new QuestionModel();
            questionModel.setCategoryId(questionDO.getCategoryId());
            questionModel.setCreateTime(questionDO.getGmtCreate());
            questionModel.setQuestionContent(questionDO.getContent());
            questionModel.setAttentionCount(questionDO.getAttentionCount());
            questionModel.setSameAskCount(questionDO.getSameAskCount());
            questionModel.setQuestionId(questionDO.getId());
            questionModel.setAnswerCount(questionDO.getAnswerCount());
            questionModel.setQuestionUser(userManager.queryUserInfoById(questionDO.getUserId()).getModule());
            if (userDO != null) {
                AttentionDO attentionDO = attentionManager.queryAttentionByQuestionIdAndUserId(questionDO.getId(), userDO.getId()).getModule();
                if (attentionDO == null) {
                    questionModel.setIsAttention(Boolean.FALSE);
                } else {
                    questionModel.setIsAttention(Boolean.TRUE);
                }
            }
            questionModelList.add(questionModel);
            result.setModule(questionModelList);
            result.setSuccess(Boolean.TRUE);
        }
        return result;
    }


    /**
     * 对答案进行排序，将最佳答案 置顶
     * 有问题，需要修改
     *
     * @param answerModels
     * @param topAnswerId
     * @return
     */
    private List<AnswerModel> sortAnswer(List<AnswerModel> answerModels, Integer topAnswerId) {
        if (answerModels.size() <= 1) {
            return answerModels;
        }
        AnswerModel tempAnswerModel = new AnswerModel();
        tempAnswerModel = answerModels.get(0);

        for (int i = 0; i < answerModels.size(); i++) {
            if (topAnswerId.equals(answerModels.get(i).getAnswerId())) {
                answerModels.get(i).setBestAnswer(true);
                answerModels.add(0, answerModels.get(i));
                answerModels.add(i, tempAnswerModel);
            }
        }
        return answerModels;
    }
}
