package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.taotest.qasystem.biz.domain.GoodBadDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-2
 * Time: 上午11:30
 * To change this template use File | Settings | File Templates.
 */
public interface GoodBadManager {
    public ResultDO<GoodBadDO> insertGoodBad(GoodBadDO goodBadDO)  ;

    public ResultDO<GoodBadDO> queryGoodBad(Integer answerId, Integer userId)  ;
}
