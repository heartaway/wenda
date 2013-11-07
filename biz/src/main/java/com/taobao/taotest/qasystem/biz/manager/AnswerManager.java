package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.taotest.qasystem.biz.domain.AnswerDO;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.result.ResultSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午7:18
 * To change this template use File | Settings | File Templates.
 */
public interface AnswerManager {

    public ResultDO<AnswerDO> insertAnswerInfo(AnswerDO answerDO);

    public ResultDO<AnswerDO> updateAnswerInfo(AnswerDO answerDO);

    public ResultDO<List<AnswerDO>> queryAnswersByUserId(Integer userId);

    public ResultDO<AnswerDO> queryAnswerInfoById(Integer answerId);

    /**
     * 根据questionId 查询问题下的所有答案
     * @param questionId
     * @return
     */
    public ResultDO<List<AnswerDO>> queryAnswersByQuestionId(Integer questionId);

    /**
     * 查询一个问题下特定用户回答的所有问题列表
     * @param questionId
     * @param userId
     * @return
     */
    public ResultDO<List<AnswerDO>> queryPersonalAnswersByQuestionId(Integer questionId,Integer userId);

    /**
     * 分页查询一个用户所回答过的所有问题id列表，去除重复
     * @param pageDO
     * @return
     */
    public ResultDO<List<Integer>> queryPersonalAnswersDistinctQuestion4Paging(PageDO pageDO);

    /**
     * 查询一个用户所回答过的所有问题id数目，去除重复
     * @return
     */
    public ResultDO<Integer> queryPersonalAnswersDistinctQuestionCount(Integer userId);

    public ResultDO<AnswerDO> deleteAnswerById(Integer attentionId);
}
