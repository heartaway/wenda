package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.UserDO;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time: 下午12:54
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    /**
     *  根据userId 查询用户信息
     * @param userId
     * @return
     * @throws DAOException
     */
    public UserDO queryUserInfoById( Integer userId) throws DAOException;

    /**
     *  根据name 查询用户信息
     * @param name
     * @return
     * @throws DAOException
     */
    public UserDO queryUserInfoByName( String name) throws DAOException;

}
