package com.taobao.taotest.qasystem.biz.model;

import com.taobao.taotest.qasystem.biz.domain.UserDO;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午9:02
 * To change this template use File | Settings | File Templates.
 */
public class QuestionModel {


    private Integer questionId;

    private String questionContent;

    private UserDO questionUser;

    private Integer attentionCount;

    private Integer answerCount;

    private Integer sameAskCount;

    private Integer categoryId;

    private Boolean isAttention;

    private Date createTime;

    private List<AnswerModel> answerModelList;

    public QuestionModel() {
    }

    public UserDO getQuestionUser() {
        return questionUser;
    }

    public void setQuestionUser(UserDO questionUser) {
        this.questionUser = questionUser;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSameAskCount() {
        return sameAskCount;
    }

    public void setSameAskCount(Integer sameAskCount) {
        this.sameAskCount = sameAskCount;
    }


    public List<AnswerModel> getAnswerModelList() {
        return answerModelList;
    }

    public void setAnswerModelList(List<AnswerModel> answerModelList) {
        this.answerModelList = answerModelList;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getIsAttention() {
        return isAttention;
    }

    public void setIsAttention(Boolean isAttention) {
        this.isAttention = isAttention;
    }
}
