package com.taobao.taotest.qasystem.web.module.home.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.taobao.security.actionjs.json.JSONObject;
import com.taobao.taotest.qasystem.biz.domain.AnswerDO;
import com.taobao.taotest.qasystem.biz.domain.GoodBadDO;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-2
 * Time: 上午11:47
 * To change this template use File | Settings | File Templates.
 */
public class GoodComment extends BaseHomeScreen {
    public void execute(Context context, @Param(name = "answerId") Integer answerId, @Param(name = "userId") Integer userId) throws Exception {
        //业务逻辑处理
        JSONObject json = new JSONObject();
        GoodBadDO goodBadDO =goodBadManager.queryGoodBad(answerId, userId).getModule();
        if(goodBadDO ==null){
            goodBadDO = new GoodBadDO();
            goodBadDO.setAnswerId(answerId);
            goodBadDO.setUserId(userId);
            goodBadDO.setGood(Boolean.TRUE);
            goodBadManager.insertGoodBad(goodBadDO);
            Integer befortAddCount = answerManager.queryAnswerInfoById(answerId).getModule().getGoodCount();
            AnswerDO answerDO = new AnswerDO();
            answerDO.setId(answerId);
            answerDO.setGoodCount(befortAddCount + 1);
            answerManager.updateAnswerInfo(answerDO);
            json.put("success", Boolean.TRUE);
            json.put("goodCommentCount", befortAddCount + 1);
        }else{
            json.put("success", Boolean.FALSE);
            json.put("message", "您已经评价过这个答案了。");
        }
        response.setContentType("application/x-json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write(json.toString());
    }
}
