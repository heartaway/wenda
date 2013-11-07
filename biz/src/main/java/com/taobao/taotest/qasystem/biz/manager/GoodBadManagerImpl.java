package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.dao.GoodBadDAO;
import com.taobao.taotest.qasystem.biz.domain.GoodBadDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.result.ResultSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-2
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
public class GoodBadManagerImpl implements  GoodBadManager {
    @Resource
    private GoodBadDAO goodBadDAO;

    private static final Logger logger = LoggerFactory.getLogger(GoodBadManagerImpl.class);

    public ResultDO<GoodBadDO> insertGoodBad(GoodBadDO goodBadDO){
        ResultDO<GoodBadDO> result = new ResultSupport<GoodBadDO>(false);
        try {
            result.setModule(goodBadDAO.insertGoodBad(goodBadDO));
            result.setSuccess(null != result.getModule());
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while insert goodbad : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    public ResultDO<GoodBadDO> queryGoodBad(Integer answerId, Integer userId) {
        ResultDO<GoodBadDO> result = new ResultSupport<GoodBadDO>(false);
        try {
            result.setModule(goodBadDAO.queryGoodBad(answerId,userId));
            result.setSuccess(null != result.getModule());
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while insert goodbad : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }
}
