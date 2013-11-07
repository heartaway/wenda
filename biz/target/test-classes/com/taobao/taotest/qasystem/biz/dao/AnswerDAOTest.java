//package com.taobao.taotest.qasystem.biz.dao;
//
//import com.taobao.taotest.qasystem.biz.domain.AnswerDO;
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
// * Time: 下午7:14
// * To change this template use File | Settings | File Templates.
// */
//@Ignore
//public class AnswerDAOTest extends BaseDAOTestCase {
//    Integer id ;
//
//    @Test
//    public void insertAnswerInfo_test() throws Exception{
//        AnswerDO answerDO = new AnswerDO();
//        answerDO.setContent("第一个问题的答案是什么呢？");
//        answerDO.setQuestionId(1);
//        answerDO.setUserId(new Integer(123456));
//         answerDAO.insertAnswerInfo(answerDO);
//    }
//
//    @Test
//    public void queryAnswersByUserId_test() throws Exception{
//        List<AnswerDO> answerDOs =  answerDAO.queryAnswersByUserId(123456);
//        this.id = answerDOs.get(0).getId();
//        assertEquals(1,answerDOs.size());
//        System.out.println(answerDOs.get(0).getContent());
//    }
//
//    @Test
//    public void updateAnswerInfo_test() throws Exception{
//        List<AnswerDO> answerDOs =  answerDAO.queryAnswersByUserId(123456);
//        this.id = answerDOs.get(0).getId();
//        AnswerDO answer = answerDAO.queryAnswerInfoById(id);
//        answer.setStatus(1);
//        answerDAO.updateAnswerInfo(answer);
//        AnswerDO answerDO = answerDAO.queryAnswerInfoById(id);
//        assertEquals("1", answerDO.getStatus().toString());
//    }
//
//    @Test
//    public void queryAnswerInfoById_test() throws Exception{
//        List<AnswerDO> answerDOs =  answerDAO.queryAnswersByUserId(123456);
//        this.id = answerDOs.get(0).getId();
//        AnswerDO answerDO = answerDAO.queryAnswerInfoById(id);
//        System.out.println(answerDO.getContent());
//        assertEquals("第一个问题的答案是什么呢？",answerDO.getContent());
//    }
//
//    @Test
//    public void deleteAnswerById_test() throws Exception{
//        List<AnswerDO> answerDOs =  answerDAO.queryAnswersByUserId(123456);
//        this.id = answerDOs.get(0).getId();
//        answerDAO.deleteAnswerById(id);
//        AnswerDO answer = answerDAO.queryAnswerInfoById(id);
//        assertNull(answer);
//    }
//
//}
