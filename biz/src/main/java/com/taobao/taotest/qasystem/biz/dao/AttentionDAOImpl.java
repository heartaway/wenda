package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.SqlMapBaseDAO;
import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.AttentionDO;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time: 上午9:29
 * To change this template use File | Settings | File Templates.
 */
public class AttentionDAOImpl extends SqlMapBaseDAO implements AttentionDAO {


    public AttentionDO addAttention(AttentionDO attentionDO)
            throws DAOException {
        super.executeInsert("AttentionDAO.insert", attentionDO, null);
        return attentionDO;
    }


    public AttentionDO queryAttentionById(Integer answerId)
            throws DAOException {
        return (AttentionDO) super.executeQueryForObject("AttentionDAO.queryById", answerId, null);
    }

    public List<AttentionDO> queryAttentionsByUserId(Integer userId)
            throws DAOException {
        return super.executeQueryForList("AttentionDAO.queryListByUserId", userId, null);
    }

    public AttentionDO queryAttentionByQuestionIdAndUserId(Integer questionId, Integer userId)
            throws DAOException{
        Map map = new HashMap();
        map.put("questionId",questionId);
        map.put("userId",userId);
        return (AttentionDO)super.executeQueryForObject("AttentionDAO.queryByQuestionIdAndUserId", map, null);
    }
    public int deleteAttentionById(Integer attentionId)
            throws DAOException {
        return super.executeUpdate("AttentionDAO.deleteById", attentionId, null);
    }
    public int deleteAttentionByQuestionIdAndUserId(Integer questionId,Integer userId) throws DAOException{
        Map map = new HashMap();
        map.put("questionId",questionId);
        map.put("userId",userId);
        return super.executeUpdate("AttentionDAO.deleteByQuestionIdAndUserId", map, null);
    }

}
