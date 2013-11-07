package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.Exception.DataException;
import com.taobao.taotest.qasystem.biz.dao.QuestionDAO;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.result.ResultSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午7:15
 * To change this template use File | Settings | File Templates.
 */
public class QuestionManagerImpl implements  QuestionManager {

    @Resource
    private QuestionDAO questionDAO;

    private static final Logger logger = LoggerFactory.getLogger(QuestionManagerImpl.class);


    /**
     * 新建问题
     * @param questionDO
     * @return
     */
    public ResultDO<QuestionDO> insertQuestionInfo(QuestionDO questionDO) {
        ResultDO<QuestionDO> result = new ResultSupport<QuestionDO>(false);
        try {
            validQuestionDO(questionDO);
            result.setModule(questionDAO.insertQuestionInfo(questionDO));
            result.setSuccess(null != result.getModule());
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while insert question : " + e.getMessage();
            result.addMessage(exmsg);
        } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while insert question : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    public ResultDO<QuestionDO> updateQuestionInfo(QuestionDO widgetDO) {
        ResultDO<QuestionDO> result = new ResultSupport<QuestionDO>(false);
        try {
            validQuestionDO(widgetDO);
            questionDAO.updateQuestionInfo(widgetDO);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while update question : " + e.getMessage();
            result.addMessage(exmsg);
        } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while update question : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    public ResultDO<QuestionDO> queryQuestionInfoById(Integer questionId) {
        ResultDO<QuestionDO> result = new ResultSupport<QuestionDO>(false);
        try {
            if(questionId == null){
                return  result;
            }
            result.setModule(questionDAO.queryQuestionInfoById(questionId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query question : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<List<QuestionDO>> queryQuestionsByUserId(Integer userId) {
        ResultDO<List<QuestionDO>> result = new ResultSupport<List<QuestionDO>>(false);
        try {
            if(userId == null){
                return  result;
            }
            result.setModule(questionDAO.queryQuestionsByUserId(userId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query question : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<Integer> queryAllQuestionsCount(){
        ResultDO<Integer> result = new ResultSupport<Integer>(false);
        try {
            result.setModule(questionDAO.queryAllQuestionsCount());
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query all question : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<List<QuestionDO>> queryAllQuestions4Paging(PageDO pageDO) {
        ResultDO<List<QuestionDO>> result = new ResultSupport<List<QuestionDO>>(false);
        try {
            if(pageDO == null){
                result.setModule(null);
                result.setSuccess(Boolean.FALSE);
                return  result;
            }
            result.setModule(questionDAO.queryAllQuestions4Paging(pageDO));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query all question : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    public ResultDO<List<QuestionDO>> queryPersonalQuestions4Paging(PageDO pageDO) {
        ResultDO<List<QuestionDO>> result = new ResultSupport<List<QuestionDO>>(false);
        try {
            if(pageDO == null){
                return  result;
            }
            result.setModule(questionDAO.queryPersonalQuestions4Paging(pageDO));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query question : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<List<QuestionDO>> queryPersonalAttentionQuestions4Paging(PageDO pageDO) {
        ResultDO<List<QuestionDO>> result = new ResultSupport<List<QuestionDO>>(false);
        try {
            if(pageDO == null){
                return  result;
            }
            result.setModule(questionDAO.queryPersonalAttentionQuestions4Paging(pageDO));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query question : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<QuestionDO> deleteWidgetById(Integer questionId) {
        ResultDO<QuestionDO> result = new ResultSupport<QuestionDO>(false);
        try {
            if(questionId == null){
                return  result;
            }
            questionDAO.deleteQuestionById(questionId);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while delete question : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }



    private void validQuestionDO(QuestionDO questionDO) throws DataException {
        if (questionDO == null) {
            throw new DataException("-1", "问题不能为NULL");
        }
        if ("".equals(questionDO.getContent())) {
            throw new DataException("-1", "问题内容 不能为空！");
        }
    }

    public QuestionDAO getQuestionDAO() {
        return questionDAO;
    }

    public void setQuestionDAO(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }
}
