//package com.taobao.taotest.qasystem.biz.dao;
//
//import com.taobao.taotest.qasystem.biz.domain.CommentDO;
//import org.junit.Ignore;
//import org.junit.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//
///**
// * Created with IntelliJ IDEA.
// * User: xinyuan.ymm
// * Date: 12-11-14
// * Time: 下午7:16
// * To change this template use File | Settings | File Templates.
// */
//@Ignore
//public class CommentDAOTest extends  BaseDAOTestCase {
//
//    @Test
//    public void testInsertComment() throws Exception{
//        CommentDO commentDO = new CommentDO();
//        commentDO.setContent("第一个评论是什么呢？");
//        commentDO.setTargetId(123456);
//        commentDO.setUserId(123456);
//        commentDAO.insertComment(commentDO);
//    }
//
//    @Test
//    public void testQueryCommentsByUserId() throws Exception{
//        List<CommentDO> commentDOs =  commentDAO.queryCommentsByTargetId(123456);
//        assertEquals(1,commentDOs.size());
//        assertEquals("第一个评论是什么呢？",commentDOs.get(0).getContent());
//
//        System.out.println(commentDOs.get(0).getContent());
//    }
//
//    @Test
//    public void testUpdateComment() throws Exception{
//        List<CommentDO> commentDOs =  commentDAO.queryCommentsByTargetId(123456);
//        CommentDO comment = commentDOs.get(0);
//        comment.setTargetType("comment");
//        commentDAO.updateComment(comment);
//        CommentDO commentDO = commentDAO.queryCommentById(commentDOs.get(0).getId());
//        assertEquals("comment", commentDO.getTargetType().toString());
//    }
//
//    @Test
//    public void testQueryCommentById() throws Exception{
//        List<CommentDO> commentDOs =  commentDAO.queryCommentsByTargetId(123456);
//        CommentDO commentDO = commentDAO.queryCommentById(commentDOs.get(0).getId());
//        System.out.println(commentDO.getContent());
//        assertEquals("第一个评论是什么呢？",commentDO.getContent());
//    }
//
//    @Test
//    public void testDeleteCommentById() throws Exception{
//        List<CommentDO> commentDOs =  commentDAO.queryCommentsByTargetId(123456);
//        commentDAO.deleteCommentById(commentDOs.get(0).getId());
//        CommentDO commentDO = commentDAO.queryCommentById(commentDOs.get(0).getId());
//        assertNull(commentDO);
//    }
//
//}
