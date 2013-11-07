//package com.taobao.taotest.qasystem.biz.service;
//
//import com.taobao.taotest.qasystem.biz.domain.PageDO;
//import com.taobao.taotest.qasystem.biz.model.AnswerModel;
//import com.taobao.taotest.qasystem.biz.model.QuestionModel;
//import com.taobao.taotest.qasystem.biz.result.ResultDO;
//
//import java.util.List;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
///**
// * Created with IntelliJ IDEA.
// * User: xinyuan.ymm
// * Date: 12-11-17
// * Time: 下午11:14
// * To change this template use File | Settings | File Templates.
// */
//public class AnswerServiceTest extends BaseServiceTestCase {
//
//    public void findAnswers4Detail() {
//        Integer questionId;
//
//
//    }
//    @Ignore
//    @Test
//    public void findPersonalAnswers4Pagin() {
//        PageDO pageDO = new PageDO();
//        pageDO.setIntValue(1);
//        pageDO.setStartRecord(0);
//        pageDO.setPageSize(10);
//        ResultDO<List<QuestionModel>> resultDO = answerService.findPersonalAnswers4Pagin(pageDO);
//        System.out.println(resultDO.getModule().get(0).getAnswerModelList().size());
//    }
//
//}
