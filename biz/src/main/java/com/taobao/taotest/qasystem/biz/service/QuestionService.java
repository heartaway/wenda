package com.taobao.taotest.qasystem.biz.service;

import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
import com.taobao.taotest.qasystem.biz.domain.UserDO;
import com.taobao.taotest.qasystem.biz.model.QuestionModel;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午9:49
 * To change this template use File | Settings | File Templates.
 */
public interface QuestionService {

    public ResultDO<QuestionModel> findQuestions4Detail(Integer questionId,UserDO user);
    public ResultDO<List<QuestionModel>>  queryAllQuestions4Paging(PageDO pageDO,UserDO user);
}
