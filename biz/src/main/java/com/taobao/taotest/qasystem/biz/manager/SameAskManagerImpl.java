package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.Exception.DataException;
import com.taobao.taotest.qasystem.biz.dao.SameAskDAO;
import com.taobao.taotest.qasystem.biz.domain.SameAskDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.result.ResultSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-2
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
public class SameAskManagerImpl implements  SameAskManager {
    @Resource
    private SameAskDAO sameAskDAO;

    private static final Logger logger = LoggerFactory.getLogger(SameAskManagerImpl.class);

    public ResultDO<SameAskDO> insertSameAsk(SameAskDO sameAskDO){
        ResultDO<SameAskDO> result = new ResultSupport<SameAskDO>(false);
        try {
            result.setModule(sameAskDAO.insertSameAsk(sameAskDO));
            result.setSuccess(null != result.getModule());
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while insert sameask : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public  ResultDO<SameAskDO> querySameAsk(Integer questionId, Integer userId){
        ResultDO<SameAskDO> result = new ResultSupport<SameAskDO>(false);
        try {
            result.setModule(sameAskDAO.querySameAsk(questionId,userId));
            result.setSuccess(null != result.getModule());
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query sameask : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }
}
