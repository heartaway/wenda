package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.taotest.qasystem.biz.domain.CommentDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午7:17
 * To change this template use File | Settings | File Templates.
 */
public interface CommentManager {

    public ResultDO<CommentDO> insertComment(CommentDO commentDO);

    public ResultDO<CommentDO> updateComment(CommentDO commentDO);

    public ResultDO<CommentDO> queryCommentById(Integer commentId);

    public ResultDO<List<CommentDO>> queryCommentsByTargetId(Integer targetId);

    public ResultDO<CommentDO> deleteCommentById(Integer commentId);
}
