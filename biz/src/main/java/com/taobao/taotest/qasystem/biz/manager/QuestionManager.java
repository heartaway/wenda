package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午7:15
 * To change this template use File | Settings | File Templates.
 */
public interface QuestionManager {

    public ResultDO<QuestionDO> insertQuestionInfo(QuestionDO questionDO);

    public ResultDO<QuestionDO> updateQuestionInfo(QuestionDO widgetDO);

    public ResultDO<QuestionDO> queryQuestionInfoById(Integer questionId);

    public ResultDO<Integer> queryAllQuestionsCount();

    public ResultDO<List<QuestionDO>> queryAllQuestions4Paging(PageDO pageDO);

    public ResultDO<List<QuestionDO>> queryQuestionsByUserId(Integer userId);

    public ResultDO<List<QuestionDO>> queryPersonalQuestions4Paging(PageDO pageDO);

    public ResultDO<List<QuestionDO>> queryPersonalAttentionQuestions4Paging(PageDO pageDO);

    public ResultDO<QuestionDO> deleteWidgetById(Integer questionId);
}
