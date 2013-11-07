//package com.taobao.taotest.qasystem.biz.service;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * Created with IntelliJ IDEA.
// * User: xinyuan.ymm
// * Date: 12-11-30
// * Time: 上午10:19
// * To change this template use File | Settings | File Templates.
// */
//public class BaseServiceTestCase {
//    public static AnswerService answerService;
//    public static QuestionService questionService;
//
//    static{
//        ApplicationContext context= new ClassPathXmlApplicationContext("test_ctx.xml");
//        AnswerService answerServiceBean  = (AnswerService)context.getBean("answerService");
//        QuestionService questionServiceBean  = (QuestionService)context.getBean("questionService");
//
//        answerService = answerServiceBean;
//        questionService = questionServiceBean;
//    }
//
//
//}
