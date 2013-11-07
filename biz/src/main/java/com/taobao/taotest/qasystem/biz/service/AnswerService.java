package com.taobao.taotest.qasystem.biz.service;

import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.model.AnswerModel;
import com.taobao.taotest.qasystem.biz.model.QuestionModel;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午11:14
 * To change this template use File | Settings | File Templates.
 */
public interface AnswerService {

    public ResultDO<List<AnswerModel>> findAnswers4Detail(Integer questionId) ;

    public ResultDO<List<QuestionModel>> findPersonalAnswers4Pagin(PageDO pageDO);

}
