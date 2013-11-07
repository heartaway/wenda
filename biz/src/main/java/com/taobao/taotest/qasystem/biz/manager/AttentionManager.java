package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.taotest.qasystem.biz.domain.AttentionDO;
import com.taobao.taotest.qasystem.biz.domain.PageDO;
import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午7:16
 * To change this template use File | Settings | File Templates.
 */
public interface AttentionManager {

    public ResultDO<AttentionDO> addAttention(AttentionDO attentionDO);

    public ResultDO<List<AttentionDO>> queryAttentionsByUserId(Integer userId);

    public ResultDO<AttentionDO> queryAttentionByQuestionIdAndUserId(Integer questionId,Integer userId);

    public ResultDO<Integer> removeAttention(Integer attentionId);

    public ResultDO<Integer> removeAttention(Integer question,Integer userId);
}
