package com.taobao.taotest.qasystem.biz.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-13
 * Time: 下午10:50
 * To change this template use File | Settings | File Templates.
 */
public class UserDO {

    private Integer id;

    private Integer oldId;

    private String name;

    private String displayName;

    private String password;

    private boolean actived;

    private String email;

    private boolean admin;

    private Date createdAt;

    private Date updatedAt;


    public Integer getId() {
        return id;
    }

    public Integer getOldId() {
        return oldId;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActived() {
        return actived;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
