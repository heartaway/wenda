package com.taobao.taotest.qasystem.biz.result;


import java.util.List;

public interface ResultDO<T> extends java.io.Serializable {
    /**
     * serial version UID
     */
	public static final long serialVersionUID = 1L;
    
    /**
     * 成功标识
     *
     * @return 是否成功
     */
    public boolean isSuccess();

    /**
     * 成功标识
     *
     * @param success 成功标识
     */
    public void setSuccess(boolean success);

    /**
     * 结果编码
     *
     * @return 编码
     */
    String getResultCode();

    /**
     * 备注
     *
     * @return 备注
     */
    String getRemark();

    /**
     * 获取调用的返回值
     *
     * @return 返回值
     */
    public T getModule();

    /**
     * 设置获取返回值
     *
     * @param module 返回值
     */
    public void setModule(T module);

    /**
     * 分页查询，返回查询结果总数
     *
     * @return 返回的总数
     */
    public long getTotalCount();

    /**
     * 异常
     *
     * @return exception
     */
    public Exception getException();

    /**
     * 设置异常
     *
     * @param exception exception
     */
    public void setException(Exception exception);

    /**
     * 总记录数
     *
     * @param totalCount 总的记录数
     */
    public void setTotalCount(long totalCount);


    public List<String> getMessages() ;

    public void setMessages(List<String> messages);

    public void addMessages(List<String> messages) ;

    public void addMessage(String message) ;

    public String getMessage() ;
}
