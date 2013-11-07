package com.taobao.taotest.qasystem.web.module.home.action;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.taobao.security.token.webx3.CsrfTokenForWeb3;
import com.taobao.taotest.qasystem.biz.domain.UserDO;
import com.taobao.taotest.qasystem.web.util.MD5Util;
import com.taobao.taotest.qasystem.web.util.TaoConstant;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 13-1-19
 * Time: 下午1:35
 * To change this template use File | Settings | File Templates.
 */
public class CommonAction extends BaseHomeAction {

    /**
     * 登 入
     */
    public void doLogin(Context context, Navigator navigator,
                        @Param("userName") String userName, @Param("password") String password) {
        if (!CsrfTokenForWeb3.check(request)) {
            return;
        }
        UserDO userDO = userManager.queryUserInfoByName(userName).getModule();
        if (userDO == null) {
            context.put("loginError", TaoConstant.LOGIN_ERROR);
        } else {
            if (userDO.getName().equals(userName) && !userDO.getPassword().equals(MD5Util.toMD5ByTaotest(password))) {
                context.put("loginError", TaoConstant.LOGIN_ERROR);
            }

            if (userDO.getName().equals(userName) && userDO.getPassword().equals(MD5Util.toMD5ByTaotest(password))) {
                context.put("loginInfo", TaoConstant.LOGIN_SUC);
                loginToSession(userDO.getId());
                navigator.forwardTo("index.vm").withParameter("userId", userDO.getId().toString());
            }
        }
    }


    /**
     * 登出
     */
    public void doLogout(Context context, Navigator navigator, @Param("userId") Integer userId) {
        if (userId != null) {
            logoutToSession(userId);
        }
        navigator.forwardTo("index.vm");
    }

}
