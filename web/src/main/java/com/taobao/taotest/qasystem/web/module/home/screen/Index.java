package com.taobao.taotest.qasystem.web.module.home.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.taobao.taotest.qasystem.biz.domain.*;
import com.taobao.taotest.qasystem.biz.model.QuestionModel;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.web.util.TaoConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午6:47
 * To change this template use File | Settings | File Templates.
 */
public class Index extends BaseHomeScreen {
    private final Logger logger = LoggerFactory.getLogger(Index.class);
    private UserDO userDO;

    public void execute(Context context, @Param(name = "userId") Integer userId, @Param(name = "pageIndex", defaultValue = "1") Integer pageIndex) throws Exception {
        userDO = loginCheck(userId);
        showAllQuestionList(context, pageIndex);
        showSideBarWidget(context, userDO);
        context.put("user", userDO);
        context.put("pageIndex", pageIndex);
        context.put("simpleDateFormat", new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    }

    /**
     * 展现所有问题列表
     *
     * @param context
     * @param pageIndex
     */
    private void showAllQuestionList(Context context, Integer pageIndex) {
        PageDO pageDO = new PageDO();
        pageDO.setStartRecord(TaoConstant.START_RECORD * (pageIndex - 1));
        pageDO.setPageSize(TaoConstant.START_RECORD);
        ResultDO<Integer> questionsCount = questionManager.queryAllQuestionsCount();
        ResultDO<List<QuestionModel>> resultQuestionModel = questionService.queryAllQuestions4Paging(pageDO, userDO);
        if (resultQuestionModel.getModule() != null && questionsCount.getModule() > TaoConstant.START_RECORD) {
            context.put("allQuestionModelsList", resultQuestionModel.getModule());
            context.put("paging", Boolean.TRUE);
            if (questionsCount.getModule() % TaoConstant.START_RECORD != 0) {
                context.put("totalPage", questionsCount.getModule() / TaoConstant.START_RECORD + 1);
            } else {
                context.put("totalPage", questionsCount.getModule() / TaoConstant.START_RECORD);
            }
        } else {
            context.put("allQuestionModelsList", resultQuestionModel.getModule());
            context.put("paging", Boolean.FALSE);
        }
    }

}
