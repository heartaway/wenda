package com.taobao.taotest.qasystem.web.module.home.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.taobao.taotest.qasystem.biz.domain.*;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.web.util.TaoConstant;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午8:45
 * To change this template use File | Settings | File Templates.
 */
public class PersonalAnswers extends BaseHomeScreen {
    private UserDO userDO;

    public void execute(Navigator navigator, Context context, @Param(name = "userId") Integer userId, @Param(name = "pageIndex", defaultValue = "1") Integer pageIndex) throws Exception {
        userDO = loginCheck(userId);
        if (userDO != null && userDO.getId() != null) {
            showSideBarWidget(context, userDO);
            showPersonalAnswerList(context, pageIndex);
            context.put("user", userDO);
            context.put("pageIndex", pageIndex);
            context.put("simpleDateFormat", new SimpleDateFormat("yyyy-MM-dd HH:mm"));
        } else {
            navigator.forwardTo("/index.vm");
        }
    }

    /**
     * 展现个人 问题列表
     *
     * @param context
     * @param pageIndex
     */
    private void showPersonalAnswerList(Context context, Integer pageIndex) {
        ResultDO<List<AnswerDO>> resultAnswerDO = answerManager.queryAnswersByUserId(userDO.getId());
        if (resultAnswerDO.getModule() != null && resultAnswerDO.getModule().size() > TaoConstant.START_RECORD) {
            PageDO pageDO = new PageDO();
            pageDO.setIntValue(userDO.getId());
            pageDO.setStartRecord(TaoConstant.START_RECORD * (pageIndex - 1));
            pageDO.setPageSize(TaoConstant.START_RECORD);
            context.put("personalQuestionList", answerService.findPersonalAnswers4Pagin(pageDO).getModule());
            context.put("paging", Boolean.TRUE);
            if (resultAnswerDO.getModule().size() % TaoConstant.START_RECORD != 0) {
                context.put("totalPage", resultAnswerDO.getModule().size() / TaoConstant.START_RECORD + 1);
            } else {
                context.put("totalPage", resultAnswerDO.getModule().size() / TaoConstant.START_RECORD);
            }
        } else {
            PageDO pageDO = new PageDO();
            pageDO.setIntValue(userDO.getId());
            pageDO.setStartRecord(TaoConstant.START_RECORD * (pageIndex - 1));
            pageDO.setPageSize(TaoConstant.START_RECORD);
            context.put("personalQuestionList", answerService.findPersonalAnswers4Pagin(pageDO).getModule());
            context.put("paging", Boolean.FALSE);
        }
    }


}
