package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.SqlMapBaseDAO;
import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.AnswerDO;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time: 上午9:33
 * To change this template use File | Settings | File Templates.
 */
public class AnswerDAOImpl extends SqlMapBaseDAO implements AnswerDAO {


    public AnswerDO insertAnswerInfo( AnswerDO answerDO)
            throws DAOException {
        super.executeInsert("AnswerDAO.insert", answerDO, null);
        return answerDO;
    }


    public int updateAnswerInfo( AnswerDO answerDO)
            throws DAOException {
        return super.executeUpdate("AnswerDAO.update", answerDO, null);
    }

    public AnswerDO queryAnswerInfoById( Integer answerId)
            throws DAOException {
        return (AnswerDO) super.executeQueryForObject("AnswerDAO.queryById", answerId, null);
    }

    public List<AnswerDO> queryAnswersByUserId( Integer userId)
            throws DAOException {
        return super.executeQueryForList("AnswerDAO.queryListByUserId", userId, null);
    }


    public List<Integer> queryPersonalAnswersDistinctQuestion4Paging(PageDO pageDO)
            throws DAOException{
        return super.executeQueryForList("AnswerDAO.queryPersonalAnswersDistinctQuestion4Paging", pageDO, null);
    }

    public List<AnswerDO> queryPersonalAnswersByQuestionId(Integer questionId,Integer userId) throws DAOException{
        Map map = new HashMap();
        map.put("questionId",questionId);
        map.put("userId",userId);
        return super.executeQueryForList("AnswerDAO.queryPersonalAnswersByQuestionId", map, null);
    }

    public List<AnswerDO> queryAnswersByQuestionId( Integer questionId) throws DAOException{
        return super.executeQueryForList("AnswerDAO.queryAnswersByQuestionId", questionId, null);
    }

    public Integer queryPersonalAnswersDistinctQuestionCount(Integer userId) throws DAOException{
        return (Integer)super.executeQueryForObject("AnswerDAO.queryPersonalAnswersDistinctQuestionCount", userId, null);
    }
    public int deleteAnswerById( Integer answerId)
            throws DAOException {
        return super.executeUpdate("AnswerDAO.deleteById", answerId, null);
    }

}
