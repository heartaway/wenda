package com.taobao.taotest.qasystem.web.module.home.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.taobao.taotest.qasystem.biz.domain.UserDO;
import com.taobao.taotest.qasystem.biz.model.QuestionModel;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午8:54
 * To change this template use File | Settings | File Templates.
 */
public class QuestionDetail extends BaseHomeScreen {
    private UserDO userDO;

    public void execute(Navigator navigator,@Param(name = "questionId") Integer questionId,@Param(name = "userId") Integer userId, Context context) throws Exception {
        userDO = loginCheck(userId);
        if (questionId != null &&  questionManager.queryQuestionInfoById(questionId).getModule() !=null) {
        showSideBarWidget(context, userDO);
        ResultDO<QuestionModel> resultQuestionModelDO = questionService.findQuestions4Detail(questionId,userDO);
        context.put("user", userDO);
        context.put("message", resultQuestionModelDO.getMessage());
        context.put("questionModel", resultQuestionModelDO.getModule());
        context.put("simpleDateFormat", new SimpleDateFormat("yyyy-MM-dd HH:mm"));
        } else {
            navigator.forwardTo("/index.vm");
        }
    }

}
