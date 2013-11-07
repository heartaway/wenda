package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.SqlMapBaseDAO;
import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.GoodBadDO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-2
 * Time: 上午11:07
 * To change this template use File | Settings | File Templates.
 */
public class GoodBadDAOImpl extends SqlMapBaseDAO implements  GoodBadDAO {

    public GoodBadDO insertGoodBad(GoodBadDO goodBadDO) throws DAOException{
        super.executeInsert("GoodBadDAO.insert", goodBadDO, null);
        return goodBadDO;
    }

    public GoodBadDO queryGoodBad(Integer answerId, Integer userId) throws DAOException{
        Map map = new HashMap();
        map.put("answerId",answerId);
        map.put("userId",userId);
        return  (GoodBadDO)super.executeQueryForObject("GoodBadDAO.queryByAnswerIdAndUserId", map, null);
    }
}
