package com.taobao.taotest.qasystem.biz.service;

import com.taobao.taotest.qasystem.biz.domain.*;
import com.taobao.taotest.qasystem.biz.manager.AnswerManager;
import com.taobao.taotest.qasystem.biz.manager.CommentManager;
import com.taobao.taotest.qasystem.biz.manager.QuestionManager;
import com.taobao.taotest.qasystem.biz.manager.UserManager;
import com.taobao.taotest.qasystem.biz.model.AnswerModel;
import com.taobao.taotest.qasystem.biz.model.QuestionModel;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.result.ResultSupport;
import com.taobao.taotest.qasystem.biz.util.Answer2Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午11:14
 * To change this template use File | Settings | File Templates.
 */
public class AnswerServiceImpl implements AnswerService {

    @Resource
    private AnswerManager answerManager;

    @Resource
    private QuestionManager questionManager;

    @Resource
    private UserManager userManager;

    @Resource
    private CommentManager commentManager;

    private static final Logger logger = LoggerFactory.getLogger(AnswerServiceImpl.class);

    public ResultDO<List<AnswerModel>> findAnswers4Detail(Integer questionId) {
        ResultDO<List<AnswerModel>> result = new ResultSupport<List<AnswerModel>>(false);
        List<AnswerModel> answerModelList = new ArrayList<AnswerModel>();
        List<AnswerDO> answerDOList;
        AnswerModel answerModel;
        ResultDO<UserDO> userDOResultDO;
        UserDO userDO;
        ResultDO<List<AnswerDO>> resultDO = answerManager.queryAnswersByQuestionId(questionId);

        if (!resultDO.isSuccess()) {
            result.addMessage("查找问题答案出错！");
            return result;
        }
        if (resultDO.getModule().size() == 0) {
            result.addMessage("还没有人来回答此问题哟！");
            return result;
        }
        answerDOList = resultDO.getModule();

        for (AnswerDO answerDO : answerDOList) {
            userDOResultDO = userManager.queryUserInfoById(answerDO.getUserId());
            if (!userDOResultDO.isSuccess()) {
                result.addMessage("找不到答案的作者！");
                return result;
            }
            userDO = userDOResultDO.getModule();
            ResultDO<List<CommentDO>> commentsResult = new ResultSupport<List<CommentDO>>(false);
            commentsResult = commentManager.queryCommentsByTargetId(answerDO.getId());

            answerModel = new AnswerModel();
            answerModel.setAnswerUser(userDO);
            answerModel.setAnswerContent(answerDO.getContent());
            answerModel.setAnswerId(answerDO.getId());
            answerModel.setBadCount(answerDO.getBadCount());
            answerModel.setGoodCount(answerDO.getGoodCount());
            answerModel.setCommentCount(answerDO.getCommentCount());
            answerModel.setCreateTime(answerDO.getGmtCreate());
            answerModel.setQuestionId(answerDO.getQuestionId());

            answerModel.setComments(commentsResult.getModule());
            answerModelList.add(answerModel);
        }
        result.setModule(answerModelList);
        result.setSuccess(Boolean.TRUE);
        return result;
    }


    public ResultDO<List<QuestionModel>> findPersonalAnswers4Pagin(PageDO pageDO) {
        ResultDO<List<QuestionModel>> result = new ResultSupport<List<QuestionModel>>(false);
        List<QuestionModel> questionModelList = new ArrayList<QuestionModel>();
        ResultDO<List<Integer>> resultDO = answerManager.queryPersonalAnswersDistinctQuestion4Paging(pageDO);
        if (resultDO.getModule() ==null || resultDO.getModule().size() == 0) {
            return result;
        }

        for (Integer questionId : resultDO.getModule()) {
            QuestionModel questionModel =getQuestionModel(questionId,pageDO);
            questionModelList.add(questionModel);
        }
        result.setModule(questionModelList);
        result.setSuccess(Boolean.TRUE);
        return result;
    }


    protected  QuestionModel getQuestionModel(Integer questionId,PageDO pageDO){
        ResultDO<QuestionDO> questionDOResultDO =questionManager.queryQuestionInfoById(questionId);
        QuestionModel questionModel = new QuestionModel();
        questionModel.setQuestionId(questionId);
        questionModel.setQuestionContent(questionDOResultDO.getModule().getContent());
        questionModel.setCreateTime(questionDOResultDO.getModule().getGmtCreate());
        ResultDO<List<AnswerDO>> resultAnswerList = answerManager.queryPersonalAnswersByQuestionId(questionId,pageDO.getIntValue());
        questionModel.setAnswerModelList(Answer2Model.answerList2AnswerModelList(resultAnswerList.getModule()));
         return questionModel;
    }
}
