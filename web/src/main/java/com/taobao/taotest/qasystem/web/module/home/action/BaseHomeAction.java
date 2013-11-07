package com.taobao.taotest.qasystem.web.module.home.action;

import com.taobao.taotest.qasystem.biz.domain.UserDO;
import com.taobao.taotest.qasystem.biz.manager.*;
import com.taobao.taotest.qasystem.biz.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-18
 * Time: 下午6:53
 * To change this template use File | Settings | File Templates.
 */
public class BaseHomeAction {

    private static final Logger logger = LoggerFactory.getLogger(BaseHomeAction.class);

    @Resource
    protected AnswerManager answerManager;

    @Resource
    protected AttentionManager attentionManager;

    @Resource
    protected CategoryManager categoryManager;

    @Resource
    protected CommentManager commentManager;

    @Resource
    protected InvitationManager invitationManager;

    @Resource
    protected QuestionManager questionManager;

    @Resource
    protected QuestionService questionService;

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected UserManager userManager;

    public AnswerManager getAnswerManager() {
        return answerManager;
    }

    public void setAnswerManager(AnswerManager answerManager) {
        this.answerManager = answerManager;
    }

    public AttentionManager getAttentionManager() {
        return attentionManager;
    }

    public void setAttentionManager(AttentionManager attentionManager) {
        this.attentionManager = attentionManager;
    }

    public CategoryManager getCategoryManager() {
        return categoryManager;
    }

    public void setCategoryManager(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    public CommentManager getCommentManager() {
        return commentManager;
    }

    public void setCommentManager(CommentManager commentManager) {
        this.commentManager = commentManager;
    }

    public InvitationManager getInvitationManager() {
        return invitationManager;
    }

    public void setInvitationManager(InvitationManager invitationManager) {
        this.invitationManager = invitationManager;
    }

    public QuestionManager getQuestionManager() {
        return questionManager;
    }

    public void setQuestionManager(QuestionManager questionManager) {
        this.questionManager = questionManager;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }


    protected void loginToSession(Integer userId) {
        request.getSession().setAttribute(userId.toString(), Boolean.TRUE);
    }

    protected void logoutToSession(Integer userId) {
        request.getSession().removeAttribute(userId.toString());
    }

    protected UserDO loginCheck(Integer userId){
        HttpSession session = request.getSession();
        UserDO userDO;
        if(userId !=null&&isLogin(session,userId.toString())){
            userDO = new UserDO();
            userDO = userManager.queryUserInfoById(userId).getModule();
        }else {
            userDO = null;
        }
        return userDO;
    }

    protected boolean isLogin(HttpSession session, String userId) {
        if (session.getAttribute(userId) != null) {
            return true;
        } else {
            return false;
        }
    }
}
