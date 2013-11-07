package com.taobao.taotest.qasystem.web.module.home.action;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.taobao.security.token.webx3.CsrfTokenForWeb3;
import com.taobao.taotest.qasystem.biz.domain.AnswerDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
import com.taobao.taotest.qasystem.biz.domain.UserDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;


/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-18
 * Time: 下午6:53
 * To change this template use File | Settings | File Templates.
 */
public class AnswerAction extends BaseHomeAction {
    private UserDO userDO;

    /**
     * 新建答案
     */
    public void doAddAnswer(Context context, Navigator navigator,
                            @Param("questionId") Integer questionId, @Param("userId") Integer userId, @Param("content") String content) {
        if (!CsrfTokenForWeb3.check(request)) {
            return;
        }
        userDO = loginCheck(userId);
        if (userDO != null && userDO.getId() != null) {
            AnswerDO answerDO = new AnswerDO();
            answerDO.setBadCount(0);
            answerDO.setCommentCount(0);
            answerDO.setContent(content);
            answerDO.setGoodCount(0);
            answerDO.setQuestionId(questionId);
            answerDO.setUserId(userId);
            QuestionDO questionDO = questionManager.queryQuestionInfoById(questionId).getModule();
            if (questionDO == null) {
                //error
            }
            if(content==null || content =="" || content.trim()==""){
                context.put("info", "答案不能全为空。");
            }else{
                ResultDO<AnswerDO> resultDO = answerManager.insertAnswerInfo(answerDO);
                Integer answerCount = questionDO.getAnswerCount();

                QuestionDO updateQuestionDO = new QuestionDO();
                updateQuestionDO.setId(questionId);
                updateQuestionDO.setAnswerCount(answerCount + 1);
                questionManager.updateQuestionInfo(updateQuestionDO);
                context.put("insertAnswerResult", resultDO.isSuccess());
            }

        } else {
            context.put("NoLogin", "请登录");
        }

    }


    /**
     * 修改答案
     */
    public void doEditAnswer(Context context, Navigator navigator,
                             @Param("answerId") Integer answerId, @Param("userId") Integer userId, @Param("content") String content) {
        if (!CsrfTokenForWeb3.check(request)) {
            return;
        }
        userDO = loginCheck(userId);
        if (userDO != null && userDO.getId() != null) {
            ResultDO<AnswerDO> resultDO = answerManager.queryAnswerInfoById(answerId);
            AnswerDO answerDO = resultDO.getModule();
            if (answerDO == null) {
                //error
            }
            if(content==null || content =="" || content.trim()==""){
                context.put("info", "答案不能全为空。");
            }else{
            answerDO.setContent(content);
            ResultDO<AnswerDO> answerDOResultDO = answerManager.updateAnswerInfo(answerDO);
            context.put("editAnswerResult", answerDOResultDO.isSuccess());
            }
        } else {
            context.put("NoLogin", "请登录");
        }
    }

    /**
     * 删除答案
     *
     * @param context
     * @param navigator
     * @param answerId
     */
    public void doDelAnswer(Context context, Navigator navigator, @Param("userId") Integer userId, @Param("questionId") Integer questionId, @Param("answerId") Integer answerId) {
        if (!CsrfTokenForWeb3.check(request)) {
            return;
        }
        userDO = loginCheck(userId);
        if (userDO != null && userDO.getId() != null) {
            QuestionDO questionDO = questionManager.queryQuestionInfoById(questionId).getModule();
            ResultDO<AnswerDO> answerDOResultDO = answerManager.deleteAnswerById(answerId);
            QuestionDO updateQuestionDO = new QuestionDO();
            updateQuestionDO.setId(questionId);
            updateQuestionDO.setAnswerCount(questionDO.getAnswerCount() - 1);
            questionManager.updateQuestionInfo(updateQuestionDO);

            context.put("delAnswerResult", answerDOResultDO.isSuccess());
        } else {
            context.put("NoLogin", "请登录");
        }
    }

}
