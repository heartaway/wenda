package com.taobao.taotest.qasystem.biz.domain;

/**
 * 分页查询参数类
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-19
 * Time: 下午7:54
 * To change this template use File | Settings | File Templates.
 */
public class PageDO {

    private Integer intValue;

    private String stringValue;

    private Object objectValue;

    private Integer startRecord;

    private Integer pageSize;

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(Integer startRecord) {
        this.startRecord = startRecord;
    }

    public Object getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(Object objectValue) {
        this.objectValue = objectValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
}
