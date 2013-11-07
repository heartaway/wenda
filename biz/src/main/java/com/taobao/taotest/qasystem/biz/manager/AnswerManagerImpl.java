package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.Exception.DataException;
import com.taobao.taotest.qasystem.biz.dao.AnswerDAO;
import com.taobao.taotest.qasystem.biz.domain.AnswerDO;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
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
 * Time: 下午7:18
 * To change this template use File | Settings | File Templates.
 */
public class AnswerManagerImpl implements  AnswerManager {

    @Resource
    private AnswerDAO answerDAO;

    private static final Logger logger = LoggerFactory.getLogger(AnswerManagerImpl.class);


    public ResultDO<AnswerDO> insertAnswerInfo(AnswerDO answerDO) {
        ResultDO<AnswerDO> result = new ResultSupport<AnswerDO>(false);
        try {
            validAnswerDO(answerDO);
            result.setModule(answerDAO.insertAnswerInfo(answerDO));
            result.setSuccess(null != result.getModule());
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while insert answer : " + e.getMessage();
            result.addMessage(exmsg);
        } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while insert answer : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    public ResultDO<AnswerDO> updateAnswerInfo(AnswerDO answerDO) {
        ResultDO<AnswerDO> result = new ResultSupport<AnswerDO>(false);
        try {
            validAnswerDO(answerDO);
            answerDAO.updateAnswerInfo(answerDO);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while update answer : " + e.getMessage();
            result.addMessage(exmsg);
        } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while update answer : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<List<AnswerDO>> queryAnswersByUserId(Integer userId) {
        ResultDO<List<AnswerDO>> result = new ResultSupport<List<AnswerDO>>(false);
        try {
            if(userId == null){
                return  result;
            }
            result.setModule(answerDAO.queryAnswersByUserId(userId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query answer : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<List<AnswerDO>> queryPersonalAnswersByQuestionId(Integer questionId,Integer userId){
        ResultDO<List<AnswerDO>> result = new ResultSupport<List<AnswerDO>>(false);
        try {
            if(userId == null){
                return  result;
            }
            result.setModule(answerDAO.queryPersonalAnswersByQuestionId(questionId,userId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query answer : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<List<Integer>> queryPersonalAnswersDistinctQuestion4Paging(PageDO pageDO) {
        ResultDO<List<Integer>> result = new ResultSupport<List<Integer>>(false);
        try {
            if(pageDO == null){
                return  result;
            }
            result.setModule(answerDAO.queryPersonalAnswersDistinctQuestion4Paging(pageDO));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query answers : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<AnswerDO> queryAnswerInfoById(Integer answerId) {
        ResultDO<AnswerDO> result = new ResultSupport<AnswerDO>(false);
        try {
            if(answerId == null){
                return  result;
            }
            result.setModule(answerDAO.queryAnswerInfoById(answerId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query answer : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<List<AnswerDO>> queryAnswersByQuestionId(Integer questionId){
        ResultDO<List<AnswerDO>> result = new ResultSupport<List<AnswerDO>>(false);
        try {
            if(questionId == null){
                return  result;
            }
            result.setModule(answerDAO.queryAnswersByQuestionId(questionId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query answer : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    public ResultDO<AnswerDO> deleteAnswerById(Integer attentionId) {
        ResultDO<AnswerDO> result = new ResultSupport<AnswerDO>(false);
        try {
            if(attentionId == null){
                return  result;
            }
            answerDAO.deleteAnswerById(attentionId);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while delete answer : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    private void validAnswerDO(AnswerDO answerDO) throws DataException {
        if (answerDO == null) {
            throw new DataException("-1", "答案 不能为NULL");
        }
    }

    public ResultDO<Integer> queryPersonalAnswersDistinctQuestionCount(Integer userId){
        ResultDO<Integer> result = new ResultSupport<Integer>(false);
        try {
            if(userId == null){
                return  result;
            }
            result.setModule(answerDAO.queryPersonalAnswersDistinctQuestionCount(userId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query answer : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    public AnswerDAO getAnswerDAO() {
        return answerDAO;
    }

    public void setAnswerDAO(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }
}
