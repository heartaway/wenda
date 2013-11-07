package com.taobao.taotest.qasystem.biz.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-13
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
public class WidgetDO {

    private Integer id;

    private String name;

    private String src;

    private WidgetTpye type;

    private Boolean status;

    private Boolean person;

    private Date gmtCreate;

    private Date gmtModified;

    public enum WidgetTpye {
        MODULE,LAYOUT
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public WidgetTpye getType() {
        return type;
    }

    public void setType(WidgetTpye type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    public Boolean getPerson() {
        return person;
    }

    public void setPerson(Boolean person) {
        this.person = person;
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
