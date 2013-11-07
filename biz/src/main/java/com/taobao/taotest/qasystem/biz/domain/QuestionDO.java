package com.taobao.taotest.qasystem.biz.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-13
 * Time: 下午10:50
 * To change this template use File | Settings | File Templates.
 */
public class QuestionDO {


    private Integer id;

    private Integer userId;

    private Integer categoryId ;

    private Integer status;

    private String content;

    private Integer sameAskCount;

    private Integer topAnswerId;

    private Integer attentionCount;

    private Integer answerCount;

    private String features;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSameAskCount() {
        return sameAskCount;
    }

    public void setSameAskCount(Integer sameAskCount) {
        this.sameAskCount = sameAskCount;
    }

    public Integer getTopAnswerId() {
        return topAnswerId;
    }

    public void setTopAnswerId(Integer topAnswerId) {
        this.topAnswerId = topAnswerId;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
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
}
