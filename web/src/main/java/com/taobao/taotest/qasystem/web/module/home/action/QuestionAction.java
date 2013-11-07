package com.taobao.taotest.qasystem.web.module.home.action;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.taobao.security.token.webx3.CsrfTokenForWeb3;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-18
 * Time: 下午6:53
 * To change this template use File | Settings | File Templates.
 */
public class QuestionAction extends BaseHomeAction {


    /**
     * 新建问题
     */
    public void doInsertQuestion(Context context, Navigator navigator, @Param("invitation") String invitation,
                                 @Param("categoryId") Integer categoryId, @Param("content") String content,@Param("userId") Integer userId) {
        if (!CsrfTokenForWeb3.check(request)) {
            return;
        }
        if(userId ==null){
            navigator.forwardTo("login.vm");
        }
        if(content==null || content =="" || content.trim()==""){
            context.put("info", "问题不能全为空。");
        }else{
        QuestionDO questionDO = new QuestionDO();
        questionDO.setAnswerCount(0);
        questionDO.setAttentionCount(0);
        questionDO.setCategoryId(categoryId);
        questionDO.setContent(content);
        questionDO.setUserId(userId);
        questionDO.setSameAskCount(0);
        ResultDO<QuestionDO> resultDO = questionManager.insertQuestionInfo(questionDO);
        context.put("insertQuestionResult",resultDO.isSuccess());
        }
    }

    /**
     * 修改问题
     */
    public void doEditQuestion(Context context, Navigator navigator, @Param("invitation") String invitation,
                                 @Param("categoryId") Integer categoryId, @Param("content") String content,@Param("questionId") Integer questionId) {
        if (!CsrfTokenForWeb3.check(request)) {
            return;
        }
        if(content==null || content =="" || content.trim()==""){
            context.put("info", "问题不能全为空。");
        }else{
        QuestionDO questionDO = new QuestionDO();
        questionDO.setId(questionId);
        questionDO.setCategoryId(categoryId);
        questionDO.setContent(content);
        ResultDO<QuestionDO> resultDO = questionManager.updateQuestionInfo(questionDO);
        context.put("updateQuestionResult",resultDO.isSuccess());
        }
    }
}
