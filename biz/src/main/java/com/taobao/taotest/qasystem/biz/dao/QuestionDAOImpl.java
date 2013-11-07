package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.SqlMapBaseDAO;
import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time: 上午9:31
 * To change this template use File | Settings | File Templates.
 */
public class QuestionDAOImpl extends SqlMapBaseDAO implements QuestionDAO {

    public QuestionDO insertQuestionInfo(QuestionDO questionDO)
            throws DAOException {
        super.executeInsert("QuestionDAO.insert", questionDO, null);
        return questionDO;
    }


    public void updateQuestionInfo(QuestionDO questionDO)
            throws DAOException {
        super.executeUpdate("QuestionDAO.update", questionDO, null);
    }

    public QuestionDO queryQuestionInfoById(Integer questionId)
            throws DAOException {
        return (QuestionDO) super.executeQueryForObject("QuestionDAO.queryById", questionId, null);
    }

    public List<QuestionDO> queryQuestionsByUserId(Integer userId)
            throws DAOException {
    return super.executeQueryForList("QuestionDAO.queryListByUserId", userId, null);
}

    public Integer queryAllQuestionsCount()
            throws DAOException {
        return (Integer)super.executeQueryForObject("QuestionDAO.queryAllQuestionsCount", null, null);
    }

    public List<QuestionDO> queryAllQuestions4Paging(PageDO pageDO)
            throws DAOException {
        return super.executeQueryForList("QuestionDAO.queryAllQuestions4Paging", pageDO, null);
    }

    public List<QuestionDO> queryPersonalQuestions4Paging(PageDO pageDO)
            throws DAOException {
        return super.executeQueryForList("QuestionDAO.queryUserQuestions4Paging", pageDO, null);
    }

    public List<QuestionDO> queryPersonalAttentionQuestions4Paging(PageDO pageDO)
            throws DAOException {
        return super.executeQueryForList("QuestionDAO.queryPersonalAttentionQuestions4Paging", pageDO, null);
    }

    public int deleteQuestionById(Integer questionId)
            throws DAOException {
        return super.executeUpdate("QuestionDAO.deleteById", questionId, null);
    }
}
