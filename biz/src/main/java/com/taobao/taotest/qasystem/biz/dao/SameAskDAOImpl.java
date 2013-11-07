package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.SqlMapBaseDAO;
import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.SameAskDO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-2
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
public class SameAskDAOImpl extends SqlMapBaseDAO implements SameAskDAO{

    public SameAskDO insertSameAsk(SameAskDO sameAskDO) throws DAOException{
        super.executeInsert("SameAskDAO.insert", sameAskDO, null);
        return sameAskDO;
    }

    public SameAskDO querySameAsk(Integer questionId, Integer userId) throws DAOException{
        Map map = new HashMap();
        map.put("questionId",questionId);
        map.put("userId",userId);
        return  (SameAskDO)super.executeQueryForObject("SameAskDAO.queryByQuestionIdAndUserId", map, null);
    }
}
