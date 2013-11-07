package com.taobao.taotest.qasystem.biz.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-12-2
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */
public class GoodBadDO {

    private Integer id;

    private Integer answerId;

    private Integer userId;

    private Boolean good;

    private Boolean bad;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getGood() {
        return good;
    }

    public void setGood(Boolean good) {
        this.good = good;
    }

    public Boolean getBad() {
        return bad;
    }

    public void setBad(Boolean bad) {
        this.bad = bad;
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
}
