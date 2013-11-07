package com.taobao.taotest.qasystem.web.pipline;

import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.support.AbstractValve;
import com.alibaba.citrus.service.uribroker.URIBrokerService;
import com.alibaba.webx.util.WebxUtil;
import com.taobao.taotest.qasystem.web.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class SessionValve extends AbstractValve {
    private final static Logger logger = LoggerFactory.getLogger(SessionValve.class);

    @Autowired
    private HttpSession session;

    public void invoke(PipelineContext pipelineContext) throws Exception {
        try {


            if (hasLogin()) {
                String lastTime = (String) session.getAttribute(SessionKeeper.ATTRIBUTE_LAST_VISIT_COOKIE);
                int lastVisitTime = 0;

                if (lastTime != null) {
                    try {
                        lastVisitTime = Integer.parseInt(lastTime);
                    } catch (NumberFormatException e1) {
                        lastVisitTime = 0;
                    }
                }

                // 去除Session表，只从Cookie中判断，半个小时Cookie失效
                if (Math.abs((System.currentTimeMillis() / 1000) - lastVisitTime) >= 3600) {
                    session.invalidate();
                }
            }

            // 更新上次访问时间
            session.setAttribute(SessionKeeper.ATTRIBUTE_LAST_VISIT_COOKIE, Long.toString(System.currentTimeMillis() / 1000));
        } catch (Exception e) {
            logger.error(ExceptionUtil.PRE_STRING+"SessionValue:设置session失败", e);
        }



        pipelineContext.invokeNext();
    }


    private boolean hasLogin() {
        if (session == null) {
            return false;
        }
        return "true".equals(session.getAttribute(SessionKeeper.ATTRIBUTE_LOGIN));
    }
}

