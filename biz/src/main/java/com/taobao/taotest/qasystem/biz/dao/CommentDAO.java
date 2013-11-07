package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.CommentDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time: 下午12:48
 * To change this template use File | Settings | File Templates.
 */
public interface CommentDAO {
    /**
     *   插入评论
     * @param commentDO
     * @throws DAOException
     */
    public CommentDO insertComment( CommentDO commentDO) throws DAOException;

    /**
     *  更新评论
     * @param commentDO
     * @throws DAOException
     */
    public void updateComment( CommentDO commentDO) throws DAOException;

    /**
     * 查询一条特定评论
     * @param commentId
     * @return
     * @throws DAOException
     */
    public CommentDO queryCommentById( Integer commentId) throws DAOException;

    /**
     *  查询我发表过的所有评论
     * @param targetId
     * @return
     * @throws DAOException
     */
    public List<CommentDO> queryCommentsByTargetId( Integer targetId) throws DAOException;

    /**
     *   删除一条评论
     * @param commentId
     * @return
     * @throws DAOException
     */
    public int deleteCommentById( Integer commentId) throws DAOException;
}
