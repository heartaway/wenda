package com.taobao.taotest.qasystem.biz.model;

import com.taobao.taotest.qasystem.biz.domain.CommentDO;
import com.taobao.taotest.qasystem.biz.domain.UserDO;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午9:08
 * To change this template use File | Settings | File Templates.
 */
public class AnswerModel {

    private Integer questionId;

    private String questionContent;

    private Integer answerId;

    private String answerContent;

    private Integer commentCount;

    private Integer goodCount;

    private Integer badCount;

    private UserDO answerUser;

    private Date createTime;

    private Boolean bestAnswer;

    private List<CommentDO> comments;

    public AnswerModel() {
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Integer getBadCount() {
        return badCount;
    }

    public void setBadCount(Integer badCount) {
        this.badCount = badCount;
    }

    public UserDO getAnswerUser() {
        return answerUser;
    }

    public void setAnswerUser(UserDO answerUser) {
        this.answerUser = answerUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getBestAnswer() {
        return bestAnswer;
    }

    public void setBestAnswer(Boolean bestAnswer) {
        this.bestAnswer = bestAnswer;
    }

    public List<CommentDO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDO> comments) {
        this.comments = comments;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}
