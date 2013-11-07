package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.AnswerDO;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time: 上午 9:15
 * To change this template use File | Settings | File Templates.
 */
public interface AnswerDAO {
    /**
     * 回答问题
     * @param answerDO
     * @throws DAOException
     */
    public AnswerDO insertAnswerInfo( AnswerDO answerDO) throws DAOException;

    /**
     * 对答案进行更新
     * @param answerDO
     * @throws DAOException
     */
    public int updateAnswerInfo( AnswerDO answerDO) throws DAOException;

    /**
     * 查找特定答案
     * @param answerId
     * @return
     * @throws DAOException
     */
    public AnswerDO queryAnswerInfoById(Integer answerId) throws DAOException;

    /**
     * 查找我回答的所有答案
     * @param userId
     * @return
     * @throws DAOException
     */
    public List<AnswerDO> queryAnswersByUserId( Integer userId) throws DAOException;

    /**
     * 查询 在特定问题下 我给出的答案
     * @param userId
     * @return
     * @throws DAOException
     */
    public List<AnswerDO> queryPersonalAnswersByQuestionId(Integer questionId,Integer userId) throws DAOException;

    /**
     * 分页查询 我回答过的问题
     * @param pageDO
     * @return
     */
    public List<Integer> queryPersonalAnswersDistinctQuestion4Paging(PageDO pageDO)throws DAOException;
    /**
     * 查找一个问题下的所有答案
     * @param questionId
     * @return
     * @throws DAOException
     */
    public List<AnswerDO> queryAnswersByQuestionId( Integer questionId) throws DAOException;

    public Integer queryPersonalAnswersDistinctQuestionCount(Integer userId) throws DAOException;

    /**
     *  删除我回答的问题
     * @param answerId
     * @return
     * @throws DAOException
     */
    public int deleteAnswerById( Integer answerId) throws DAOException;
}
