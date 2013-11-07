package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.GoodBadDO;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-2
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
public interface GoodBadDAO {

    public GoodBadDO insertGoodBad(GoodBadDO goodBadDO) throws DAOException;

    public GoodBadDO queryGoodBad(Integer answerId, Integer userId) throws DAOException;
}
