package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.dao.UserDAO;
import com.taobao.taotest.qasystem.biz.domain.UserDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.result.ResultSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午10:03
 * To change this template use File | Settings | File Templates.
 */
public class UserManagerImpl implements UserManager {

    @Resource
    private UserDAO userDAO;
    private static final Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);


    public ResultDO<UserDO> queryUserInfoById(Integer userId) {
        ResultDO<UserDO> result = new ResultSupport<UserDO>(false);
        try {
            if(userId == null){
                return  result;
            }
            result.setModule(userDAO.queryUserInfoById(userId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query user : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<UserDO> queryUserInfoByName(String name) {
        ResultDO<UserDO> result = new ResultSupport<UserDO>(false);
        try {
            if(name == null){
                return  result;
            }
            result.setModule(userDAO.queryUserInfoByName(name));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query user : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


}
