//package com.taobao.taotest.qasystem.biz.dao;
//
//import org.junit.Ignore;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * mysql dao 测试基类
// * @author xinyuan.ymm
// * @since 12-11-14
// */
//@Ignore
//public class BaseDAOTestCase  {
//
//    public static UserDAO userDAO;
//    public static AnswerDAO answerDAO;
//    public static AttentionDAO attentionDAO;
//    public static CategoryDAO categoryDAO;
//    public static CommentDAO commentDAO;
//    public static QuestionDAO questionDAO;
//    public static WidgetDAO widgetDAO;
//
//    static{
//        ApplicationContext context= new ClassPathXmlApplicationContext("test_ctx.xml");
//        UserDAO userDAOBean  = (UserDAO)context.getBean("userDAO");
//        AnswerDAO answerDAOBean  = (AnswerDAO)context.getBean("answerDAO");
//        AttentionDAO attentionDAOBean  = (AttentionDAO)context.getBean("attentionDAO");
//        CategoryDAO categoryDAOBean  = (CategoryDAO)context.getBean("categoryDAO");
//        CommentDAO commentDAOBean  = (CommentDAO)context.getBean("commentDAO");
//        QuestionDAO questionDAOBean  = (QuestionDAO)context.getBean("questionDAO");
//        WidgetDAO widgetDAOBean  = (WidgetDAO)context.getBean("widgetDAO");
//
//        userDAO = userDAOBean;
//        answerDAO = answerDAOBean;
//        attentionDAO = attentionDAOBean;
//        categoryDAO = categoryDAOBean;
//        commentDAO = commentDAOBean;
//        questionDAO = questionDAOBean;
//        widgetDAO = widgetDAOBean;
//
//    }
//
//}
