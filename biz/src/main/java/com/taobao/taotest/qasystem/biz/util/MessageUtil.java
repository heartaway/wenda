package com.taobao.taotest.qasystem.biz.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
public class MessageUtil implements ApplicationContextAware {
    private static ApplicationContext ctx;

    public static String getMessage(String code, Object... params) {
        return getMessage(code, Locale.SIMPLIFIED_CHINESE, params);
    }

    public static String getMessage(String code, Locale locale, Object... params) {
        return ctx.getMessage(code, params, locale);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        ctx = applicationContext;
    }
}
