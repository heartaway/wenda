package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.SameAskDO;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-2
 * Time: 上午11:01
 * To change this template use File | Settings | File Templates.
 */
public interface SameAskDAO {

    public SameAskDO insertSameAsk(SameAskDO sameAskDO) throws DAOException;

    public SameAskDO querySameAsk(Integer questionId, Integer userId) throws DAOException;
}
