package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.taotest.qasystem.biz.domain.SameAskDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-2
 * Time: 上午11:24
 * To change this template use File | Settings | File Templates.
 */
public interface SameAskManager {
    public ResultDO<SameAskDO> insertSameAsk(SameAskDO sameAskDO);

    public ResultDO<SameAskDO> querySameAsk(Integer questionId, Integer userId);
}
