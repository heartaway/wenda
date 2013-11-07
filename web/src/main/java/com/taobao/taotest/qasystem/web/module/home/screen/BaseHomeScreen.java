package com.taobao.taotest.qasystem.web.module.home.screen;

import com.alibaba.citrus.turbine.Context;
import com.taobao.taotest.qasystem.biz.domain.*;
import com.taobao.taotest.qasystem.biz.manager.*;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.service.AnswerService;
import com.taobao.taotest.qasystem.biz.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午6:48
 * To change this template use File | Settings | File Templates.
 */
public class BaseHomeScreen {

    private final Logger logger = LoggerFactory.getLogger(BaseHomeScreen.class);

    @Autowired
    protected HttpServletResponse response;

    @Resource
    protected HttpServletRequest request;

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
    protected WidgetManager widgetManager;

    @Resource
    protected GoodBadManager goodBadManager;

    @Resource
    protected SameAskManager sameAskManager;

    @Resource
    protected QuestionService questionService;

    @Resource
    protected AnswerService answerService;


    @Resource
    protected UserManager userManager;

    protected List<CategoryDO> categoryDOList;

    protected List<WidgetDO> widgetDOList;


    protected void init() {
        initCategory();
        initWidgetOnSideBar();
    }


    /**
     * 初始化 问题 分类
     *
     * @return
     */
    private void initCategory() {
        ResultDO<List<CategoryDO>> resultDO = categoryManager.queryAllCategory();
        this.categoryDOList = resultDO.getModule();
    }

    /**
     * 根据显示顺序 初始化侧边栏模块
     */
    private void initWidgetOnSideBar() {
        widgetDOList = new ArrayList<WidgetDO>();
        ResultDO<List<WidgetDO>> resultModuleDO = widgetManager.queryShowModule();
        List<WidgetDO> widgetDOs = resultModuleDO.getModule();
        ResultDO<WidgetDO> resultLayoutDO = widgetManager.queryLayoutByName("SideBarLayout");
        if (resultLayoutDO.getModule() == null) {
            initLayoutOnSideBar();
            this.widgetDOList = widgetDOs;
        } else {
            StringTokenizer token = new StringTokenizer(resultLayoutDO.getModule().getSrc(), ",");
            while (token.hasMoreTokens()) {
                String catId = token.nextToken();
                for (int i = 0; i < widgetDOs.size(); i++) {
                    if (catId.equals(widgetDOs.get(i).getId().toString())) {
                        this.widgetDOList.add(widgetDOs.get(i));
                        widgetDOs.remove(i);
                    }
                }
            }
        }
    }


    private void initLayoutOnSideBar() {
        WidgetDO widgetDO = new WidgetDO();
        StringBuffer src = new StringBuffer("");
        ResultDO<List<WidgetDO>> resultModuleDO = widgetManager.queryShowModule();
        widgetDO.setType(WidgetDO.WidgetTpye.LAYOUT);
        widgetDO.setName("SideBarLayout");
        widgetDO.setStatus(Boolean.TRUE);
        for (int i = 0; i < resultModuleDO.getModule().size(); i++) {
            src.append(resultModuleDO.getModule().get(i).getId());
            src.append(",");
        }
        widgetDO.setSrc(src.toString());
        widgetManager.insertLayoutInfo(widgetDO);
    }


    /**
     * 展现侧边栏widget
     *
     * @param context
     */
    protected void showSideBarWidget(Context context, UserDO userDO) {
        this.init();

        if (userDO != null && userDO.getId() != null) {
            ResultDO<List<QuestionDO>> resultQuestionDO = questionManager.queryQuestionsByUserId(userDO.getId());
            ResultDO<Integer> resultAnswerCount = answerManager.queryPersonalAnswersDistinctQuestionCount(userDO.getId());
            ResultDO<List<AttentionDO>> resultAttentionDO = attentionManager.queryAttentionsByUserId(userDO.getId());
            context.put("personalQuestionCount", resultQuestionDO.getModule().size());
            context.put("personalAnswerCount", resultAnswerCount.getModule());
            context.put("personalAttentionCount", resultAttentionDO.getModule().size());
            context.put("categoryList", this.categoryDOList);
            context.put("widgetList", this.widgetDOList);
            context.put("loginUser",userDO);
        } else {
            removePersonalWidget();
        }
    }


    /**
     * 在模块列表中删除 必须登录才能看到的模块
     */
    private void removePersonalWidget() {
        List<WidgetDO> removeWidgetList = new ArrayList<WidgetDO>();
        for (WidgetDO widgetDO : this.widgetDOList) {
            if (widgetDO.getPerson()) {
                removeWidgetList.add(widgetDO);
            }
        }
        for (WidgetDO removeWidgetDO : removeWidgetList) {
            this.widgetDOList.remove(removeWidgetDO);
        }
    }


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

    public WidgetManager getWidgetManager() {
        return widgetManager;
    }

    public void setWidgetManager(WidgetManager widgetManager) {
        this.widgetManager = widgetManager;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public List<CategoryDO> getCategoryDOList() {
        return categoryDOList;
    }

    public void setCategoryDOList(List<CategoryDO> categoryDOList) {
        this.categoryDOList = categoryDOList;
    }

    public List<WidgetDO> getWidgetDOList() {
        return widgetDOList;
    }

    public void setWidgetDOList(List<WidgetDO> widgetDOList) {
        this.widgetDOList = widgetDOList;
    }

    protected boolean isLogin(HttpSession session, String userId) {
        if (session.getAttribute(userId) != null) {
            return true;
        } else {
            return false;
        }
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
}
