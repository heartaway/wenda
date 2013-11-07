package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.SqlMapBaseDAO;
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
public class CommentDAOImpl extends SqlMapBaseDAO implements CommentDAO {

    public CommentDO insertComment(CommentDO commentDO)
            throws DAOException {
        super.executeInsert("CommentDAO.insert", commentDO, null);
        return commentDO;
    }


    public void updateComment(CommentDO commentDO)
            throws DAOException {
        super.executeUpdate("CommentDAO.update", commentDO, null);
    }

    public CommentDO queryCommentById(Integer commentId)
            throws DAOException {
        return (CommentDO) super.executeQueryForObject("CommentDAO.queryById", commentId, null);
    }

    public List<CommentDO> queryCommentsByTargetId(Integer targetId)
            throws DAOException {
        return super.executeQueryForList("CommentDAO.queryListByTargetId", targetId, null);
    }

    public int deleteCommentById(Integer commentId)
            throws DAOException {
        return super.executeUpdate("CommentDAO.deleteById", commentId, null);
    }
}
