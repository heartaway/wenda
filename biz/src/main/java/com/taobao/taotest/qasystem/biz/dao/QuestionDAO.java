package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time:上午9:36
 * To change this template use File | Settings | File Templates.
 */
public interface QuestionDAO {
    /**
     * 提出问题
     *
     * @param questionDO
     * @throws DAOException
     */
    public QuestionDO insertQuestionInfo(QuestionDO questionDO) throws DAOException;

    /**
     * 更新问题
     *
     * @param questionDO
     * @throws DAOException
     */
    public void updateQuestionInfo(QuestionDO questionDO) throws DAOException;

    /**
     * 查询单个问题
     *
     * @param questionId
     * @return
     * @throws DAOException
     */
    public QuestionDO queryQuestionInfoById(Integer questionId) throws DAOException;

    /**
     * 查询我发布的问题
     *
     * @param userId
     * @return
     * @throws DAOException
     */
    public List<QuestionDO> queryQuestionsByUserId(Integer userId) throws DAOException;

    /**
     * 查询问题总数条数
     * @return
     * @throws DAOException
     */
    public Integer queryAllQuestionsCount() throws DAOException;

    /**
     * 查询所有问题 分页分页
     *
     * @param pageDO
     * @return
     * @throws DAOException
     */
    public List<QuestionDO> queryAllQuestions4Paging(PageDO pageDO) throws DAOException;

    /**
     * 根据UserId分页分页
     *
     * @param pageDO
     * @return
     * @throws DAOException
     */
    public List<QuestionDO> queryPersonalQuestions4Paging(PageDO pageDO) throws DAOException;

    /**
     * 根据UserId查询 个人关注的问题分页
     *
     * @param pageDO
     * @return
     * @throws DAOException
     */
    public List<QuestionDO> queryPersonalAttentionQuestions4Paging(PageDO pageDO) throws DAOException;

    /**
     * 删除一个问题
     *
     * @param questionId
     * @return
     * @throws DAOException
     */
    public int deleteQuestionById(Integer questionId) throws DAOException;
}
