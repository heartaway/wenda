package com.taobao.taotest.qasystem.web.module.home.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.taobao.security.actionjs.json.JSONObject;
import com.taobao.taotest.qasystem.biz.domain.AttentionDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-1
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
public class AddAttention  extends  BaseHomeScreen{

    public void execute(Context context, @Param(name = "questionId") Integer questionId, @Param(name = "userId") Integer userId) throws Exception {
        //业务逻辑处理
        AttentionDO attentionDO = new AttentionDO();
        attentionDO.setQuestionId(questionId);
        attentionDO.setUserId(userId);
        attentionManager.addAttention(attentionDO);
        Integer befortAddCount = questionManager.queryQuestionInfoById(questionId).getModule().getAttentionCount();
        QuestionDO questionDO = new QuestionDO();
        questionDO.setId(questionId);
        questionDO.setAttentionCount(befortAddCount + 1);
        questionManager.updateQuestionInfo(questionDO);
        ResultDO<List<AttentionDO>>  resultDO = attentionManager.queryAttentionsByUserId(userId);
        Integer myAttentionCount = resultDO.getModule().size();
        JSONObject json = new JSONObject();
        json.put("success", Boolean.TRUE);
        json.put("attentionCount", befortAddCount + 1);
        json.put("myAttentionCount", myAttentionCount);
        response.setContentType("application/x-json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write(json.toString());
    }

}
