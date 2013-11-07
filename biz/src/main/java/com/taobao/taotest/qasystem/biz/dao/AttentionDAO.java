package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.AttentionDO;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time: 上午9:35
 * To change this template use File | Settings | File Templates.
 */
public interface AttentionDAO {
    /**
     *  添加关注
     * @param attentionDO
     * @throws DAOException
     */
    public AttentionDO addAttention( AttentionDO attentionDO) throws DAOException;

    /**
     * 查询我关注的列表
     * @param userId
     * @return
     * @throws DAOException
     */
    public List<AttentionDO> queryAttentionsByUserId( Integer userId) throws DAOException;

    /**
     * 查询摸个问题我是够有关注
     * @param questionId
     * @param userId
     * @return
     * @throws DAOException
     */
    public AttentionDO queryAttentionByQuestionIdAndUserId(Integer questionId, Integer userId) throws DAOException;

    /**
     * 取消关注
     * @param attentionId
     * @return
     * @throws DAOException
     */
    public int deleteAttentionById( Integer attentionId) throws DAOException;

    /**
     * 取消关注
     * @return
     * @throws DAOException
     */
    public int deleteAttentionByQuestionIdAndUserId(Integer questionId,Integer userId) throws DAOException;

}
