package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.Exception.DataException;
import com.taobao.taotest.qasystem.biz.dao.CommentDAO;
import com.taobao.taotest.qasystem.biz.domain.CommentDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.result.ResultSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午7:17
 * To change this template use File | Settings | File Templates.
 */
public class CommentManagerImpl implements  CommentManager {

    @Resource
    private CommentDAO commentDAO;
    private static final Logger logger = LoggerFactory.getLogger(CommentManagerImpl.class);


    public ResultDO<CommentDO> insertComment(CommentDO commentDO) {
        ResultDO<CommentDO> result = new ResultSupport<CommentDO>(false);
        try {
            validCommentDO(commentDO);
            result.setModule(commentDAO.insertComment(commentDO));
            result.setSuccess(null != result.getModule());
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while insert comment : " + e.getMessage();
            result.addMessage(exmsg);
        } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while insert comment : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }




    public ResultDO<CommentDO> updateComment(CommentDO commentDO) {
        ResultDO<CommentDO> result = new ResultSupport<CommentDO>(false);
        try {
            validCommentDO(commentDO);
            commentDAO.updateComment(commentDO);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while update comment : " + e.getMessage();
            result.addMessage(exmsg);
        } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while update comment : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }



    public ResultDO<CommentDO> queryCommentById(Integer commentId) {
        ResultDO<CommentDO> result = new ResultSupport<CommentDO>(false);
        try {
            if(commentId == null){
                return  result;
            }
            result.setModule(commentDAO.queryCommentById(commentId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query comment : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<List<CommentDO>> queryCommentsByTargetId(Integer targetId) {
        ResultDO<List<CommentDO>> result = new ResultSupport<List<CommentDO>>(false);
        try {
            if(targetId == null){
                return  result;
            }
            result.setModule(commentDAO.queryCommentsByTargetId(targetId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query comment : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<CommentDO> deleteCommentById(Integer commentId) {
        ResultDO<CommentDO> result = new ResultSupport<CommentDO>(false);
        try {
            if(commentId == null){
                return  result;
            }
            commentDAO.deleteCommentById(commentId);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while delete comment : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    private void validCommentDO(CommentDO commentDO) throws DataException {
        if (commentDO == null) {
            throw new DataException("-1", "评论不能为NULL");
        }
        if ("".equals(commentDO.getContent())) {
            throw new DataException("-1", "评论内容 不能为空！");
        }
    }

    public CommentDAO getCommentDAO() {
        return commentDAO;
    }

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }
}
