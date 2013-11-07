package com.taobao.taotest.qasystem.web.module.home.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.taobao.security.actionjs.json.JSONObject;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
import com.taobao.taotest.qasystem.biz.domain.SameAskDO;
import com.taobao.taotest.qasystem.biz.domain.UserDO;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-1
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class SameAsk extends BaseHomeScreen {
    private UserDO userDO;

    public void execute(Context context, @Param(name = "questionId") Integer questionId, @Param(name = "userId") Integer userId) throws Exception {
        userDO = loginCheck(userId);
        //业务逻辑处理
        JSONObject json = new JSONObject();
        SameAskDO sameAskDO = sameAskManager.querySameAsk(questionId, userId).getModule();
        if (sameAskDO == null) {
            sameAskDO = new SameAskDO();
            sameAskDO.setQuestionId(questionId);
            sameAskDO.setUserId(userId);
            sameAskManager.insertSameAsk(sameAskDO);
            Integer befortAddCount = questionManager.queryQuestionInfoById(questionId).getModule().getSameAskCount();
            QuestionDO questionDO = new QuestionDO();
            questionDO.setId(questionId);
            questionDO.setSameAskCount(befortAddCount + 1);
            questionManager.updateQuestionInfo(questionDO);
            json.put("success", Boolean.TRUE);
            json.put("sameAskCount", befortAddCount + 1);
        } else {
            json.put("success", Boolean.FALSE);
            json.put("message", "您已经同问过这个问题了。");
        }

        response.setContentType("application/x-json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write(json.toString());

    }
}
