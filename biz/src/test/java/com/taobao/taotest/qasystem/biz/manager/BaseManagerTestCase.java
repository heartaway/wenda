package com.taobao.taotest.qasystem.biz.manager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-30
 * Time: 上午10:24
 * To change this template use File | Settings | File Templates.
 */
public class BaseManagerTestCase {
    public static UserManager userManager;
    public static AnswerManager answerManager;
    public static AttentionManager attentionManager;
    public static CategoryManager categoryManager;
    public static CommentManager commentManager;
    public static QuestionManager questionManager;
    public static WidgetManager widgetManager;

    static{
        ApplicationContext context= new ClassPathXmlApplicationContext("test_ctx.xml");
        UserManager userManagerBean  = (UserManager)context.getBean("userManager");
        AnswerManager answerManagerBean  = (AnswerManager)context.getBean("answerManager");
        AttentionManager categoryManagerBean  = (AttentionManager)context.getBean("attentionManager");
        CategoryManager categoryDAOBean  = (CategoryManager)context.getBean("categoryManager");
        CommentManager commentManagerBean  = (CommentManager)context.getBean("commentManager");
        QuestionManager questionManagerBean  = (QuestionManager)context.getBean("questionManager");
        WidgetManager widgetManagerBean  = (WidgetManager)context.getBean("widgetManager");

        userManager = userManagerBean;
        answerManager = answerManagerBean;
        attentionManager = categoryManagerBean;
        categoryManager = categoryDAOBean;
        commentManager = commentManagerBean;
        questionManager = questionManagerBean;
        widgetManager = widgetManagerBean;

    }
}
