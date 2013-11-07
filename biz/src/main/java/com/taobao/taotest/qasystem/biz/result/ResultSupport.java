package com.taobao.taotest.qasystem.biz.result;


import org.apache.commons.lang.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 操作结果的封装类
 *
 * @author leijuan
 */
public class ResultSupport<T> implements ResultDO<T> {
    /**
     * serial version UID
     */
    private static final long serialVersionUID = -731035795941291301L;

    /**
     * argument is null
     */
    public static final String AugumentIsNull = "augument is null";
    /**
     * 结果代码
     */
    private String resultCode;
    /**
     * 消息数据
     */
    private List<String> messages = new LinkedList<String>();

    /**
     * 返回值
     */
    private T module;
    /**
     * 备注
     */
    private String remark;
    /**
     * 成功标识
     */
    private boolean success = false;
    /**
     * 总记录数目
     */
    private long totalCount;
    /**
     * 异常
     */
    private Exception exception;

    /**
     * 空构造函数
     */
    public ResultSupport() {
    }

    /**
     * 构造函数
     *
     * @param success 成功标识
     */
    public ResultSupport(boolean success) {
        this.success = success;
    }


    /**
     * 构造函数
     *
     * @param success 成功标识
     * @param module  承载的数据对象
     */
    public ResultSupport(boolean success, T module) {
        this.success = success;
        this.module = module;
    }

    /**
     * 构造函数
     *
     * @param success 成功标识
     * @param e       异常
     */
    public ResultSupport(boolean success, Exception e) {
        this.success = success;
        this.exception = e;
    }


    /**
     * 获取 备注
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 获取 结果代码
     *
     * @return 结果代码
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 获取 成功标识
     *
     * @return 成功标识
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @param resultCode the resultCode to set
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }


    /**
     * 获取 返回值
     *
     * @return 返回值
     */
    public T getModule() {
        return module;
    }

    /**
     * @param module the module to set
     */
    public void setModule(T module) {
        this.module = module;
    }


    /**
     * 获取 总记录数目
     *
     * @return 总记录数目
     */
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * 设置 总记录数目
     *
     * @param totalCount 总记录数目
     */
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取 异常
     *
     * @return 异常
     */
    public Exception getException() {
        return exception;
    }

    /**
     * 设置 异常
     *
     * @param exception 异常
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }


    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void addMessages(List<String> messages) {
        this.messages.addAll(messages);
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    /**
     * 返回用","分隔的messages的信息
     *
     * @return 用","分隔的messages的信息
     */
    public String getMessage() {
        return StringUtils.join(messages, ",");
    }
}
