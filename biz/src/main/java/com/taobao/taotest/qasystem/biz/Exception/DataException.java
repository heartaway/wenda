package com.taobao.taotest.qasystem.biz.Exception;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午2:20
 * To change this template use File | Settings | File Templates.
 */
public class DataException extends Exception {
    final static String ECODE = "DFAULT";

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    final private String message;

    final private String exceptionCode ;

    public DataException(String ecode, String format, Object... args) {
        this(ecode, format, args, null);
    }

    public DataException(String format, Object[] args, Throwable e) {
        this(ECODE, String.format(format, args), e);
    }

    public DataException(String ecode, String format, Object[] args, Throwable e) {
        this(ecode, String.format(format, args), e);
    }


    public DataException(String ecode, String message, Throwable e) {
        this.exceptionCode = StringUtils.isNotBlank(ecode) ? ecode : ECODE;
        this.message = message;
        logger.error(String.format("[Caught exception...exception code '%s'] : %s", ecode, message), e);
    }

    public String getMessage() {
        return this.message;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }
}
