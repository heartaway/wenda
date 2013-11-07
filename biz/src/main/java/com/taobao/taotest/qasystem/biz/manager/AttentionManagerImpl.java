package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.Exception.DataException;
import com.taobao.taotest.qasystem.biz.dao.AttentionDAO;
import com.taobao.taotest.qasystem.biz.domain.AttentionDO;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
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
 * Time: 下午7:16
 * To change this template use File | Settings | File Templates.
 */
public class AttentionManagerImpl implements  AttentionManager {

    @Resource
    private AttentionDAO attentionDAO;
    private static final Logger logger = LoggerFactory.getLogger(AttentionManagerImpl.class);


    public ResultDO<AttentionDO> addAttention(AttentionDO attentionDO) {
        ResultDO<AttentionDO> result = new ResultSupport<AttentionDO>(false);
        try {
            validAttentionDO(attentionDO);
            result.setModule(attentionDAO.addAttention(attentionDO));
            result.setSuccess(null != result.getModule());
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while insert attention : " + e.getMessage();
            result.addMessage(exmsg);
        } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while insert attention : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    public ResultDO<List<AttentionDO>> queryAttentionsByUserId(Integer userId) {
        ResultDO<List<AttentionDO>> result = new ResultSupport<List<AttentionDO>>(false);
        try {
            if(userId == null){
                return  result;
            }
            result.setModule(attentionDAO.queryAttentionsByUserId(userId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query attention : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<AttentionDO> queryAttentionByQuestionIdAndUserId(Integer questionId,Integer userId){
        ResultDO<AttentionDO> result = new ResultSupport<AttentionDO>(false);
        try {
            result.setModule(attentionDAO.queryAttentionByQuestionIdAndUserId(questionId,userId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query attention : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    public ResultDO<Integer> removeAttention(Integer attentionId) {
        ResultDO<Integer> result = new ResultSupport<Integer>(false);
        try {
            if(attentionId == null){
                return  result;
            }
            attentionDAO.deleteAttentionById(attentionId);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while delete attention : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<Integer> removeAttention(Integer question,Integer userId){
        ResultDO<Integer> result = new ResultSupport<Integer>(false);
        try {
            attentionDAO.deleteAttentionByQuestionIdAndUserId(question,userId);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while delete attention : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    private void validAttentionDO(AttentionDO attentionDO) throws DataException {
        if (attentionDO == null) {
            throw new DataException("-1", "关注 不能为NULL");
        }
    }

    public AttentionDAO getAttentionDAO() {
        return attentionDAO;
    }

    public void setAttentionDAO(AttentionDAO attentionDAO) {
        this.attentionDAO = attentionDAO;
    }
}
