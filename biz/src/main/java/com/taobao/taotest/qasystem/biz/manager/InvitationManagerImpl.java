package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.taotest.qasystem.biz.dao.InvitationDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午7:19
 * To change this template use File | Settings | File Templates.
 */
public class InvitationManagerImpl implements  InvitationManager {

    @Resource
    private InvitationDAO invitationDAO;
    private static final Logger logger = LoggerFactory.getLogger(InvitationManagerImpl.class);
    public InvitationDAO getInvitationDAO() {
        return invitationDAO;
    }

    public void setInvitationDAO(InvitationDAO invitationDAO) {
        this.invitationDAO = invitationDAO;
    }
}
