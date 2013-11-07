package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.taotest.qasystem.biz.domain.UserDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午10:03
 * To change this template use File | Settings | File Templates.
 */
public interface UserManager {

    public ResultDO<UserDO> queryUserInfoById(Integer userId);

    public ResultDO<UserDO> queryUserInfoByName(String name);
}
