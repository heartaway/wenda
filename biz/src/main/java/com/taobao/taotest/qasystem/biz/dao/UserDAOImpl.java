package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.DBRoute;
import com.taobao.common.dao.persistence.SqlMapBaseDAO;
import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.UserDO;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time: 下午12:54
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl extends SqlMapBaseDAO implements UserDAO {
    private final DBRoute dbRoute = new DBRoute("taotestSqlMap");

    public UserDO queryUserInfoById( Integer  userId)
            throws DAOException {
        return  (UserDO)super.executeQueryForObject("UserDAO.queryById",userId,dbRoute);
    }
    public UserDO queryUserInfoByName( String name)
            throws DAOException {
        return  (UserDO)super.executeQueryForObject("UserDAO.queryByName",name,dbRoute);
    }

}
