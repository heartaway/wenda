//package com.taobao.taotest.qasystem.biz.dao;
//
//import com.taobao.taotest.qasystem.biz.domain.PageDO;
//import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
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
// * Time: 下午7:17
// * To change this template use File | Settings | File Templates.
// */
//@Ignore
//public class QuestionDAOTest extends  BaseDAOTestCase {
//
//    @Test
//    public void testInsertQuestionInfo() throws Exception{
//        QuestionDO questionDO = new QuestionDO();
//        questionDO.setContent("第一个问题是什么呢？");
//        questionDO.setAttentionCount(1);
//        questionDO.setSameAskCount(1);
//        questionDO.setTopAnswerId(1);
//        questionDO.setUserId(123456);
//        questionDAO.insertQuestionInfo(questionDO);
//    }
//
//    @Test
//    public void testQueryQuestionsByUserId() throws Exception{
//        List<QuestionDO> questionDOs =  questionDAO.queryQuestionsByUserId(123456);
//        assertEquals(1,questionDOs.size());
//        System.out.println(questionDOs.get(0).getContent());
//    }
//
//    @Test
//    public void testQueryUserQuestions4Paging() throws Exception{
//        PageDO pageDO = new PageDO();
//        pageDO.setIntValue(123456);
//        pageDO.setStartRecord(0);
//        pageDO.setPageSize(10);
//        List<QuestionDO> questionDOs =  questionDAO.queryPersonalQuestions4Paging(pageDO);
//
//        System.out.println(questionDOs.get(0).getContent());
//    }
//
//    @Test
//    public void testUpdateQuestionInfo() throws Exception{
//        List<QuestionDO> questionDOs =  questionDAO.queryQuestionsByUserId(123456);
//        QuestionDO question = questionDAO.queryQuestionInfoById(questionDOs.get(0).getId());
//        question.setStatus(1);
//        question.setAnswerCount(10);
//        questionDAO.updateQuestionInfo(question);
//        QuestionDO questionDO = questionDAO.queryQuestionInfoById(questionDOs.get(0).getId());
//        assertEquals("1", questionDO.getStatus().toString());
//        assertEquals("10", questionDO.getAnswerCount().toString());
//
//    }
//
//    @Test
//    public void testQueryQuestionInfoById() throws Exception{
//        List<QuestionDO> questionDOs =  questionDAO.queryQuestionsByUserId(123456);
//        QuestionDO question = questionDAO.queryQuestionInfoById(questionDOs.get(0).getId());
//        System.out.println(question.getContent());
//        assertEquals("第一个问题是什么呢？",question.getContent());
//    }
//
//    @Test
//    public void testDeleteQuestionById() throws Exception{
//        List<QuestionDO> questionDOs =  questionDAO.queryQuestionsByUserId(123456);
//        questionDAO.deleteQuestionById(questionDOs.get(0).getId());
//        QuestionDO questionDO = questionDAO.queryQuestionInfoById(questionDOs.get(0).getId());
//        assertNull(questionDO);
//    }
//
//
//}
