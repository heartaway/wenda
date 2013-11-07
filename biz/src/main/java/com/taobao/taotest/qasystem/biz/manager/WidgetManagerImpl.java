package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.Exception.DataException;
import com.taobao.taotest.qasystem.biz.dao.WidgetDAO;
import com.taobao.taotest.qasystem.biz.result.*;
import com.taobao.taotest.qasystem.biz.domain.WidgetDO;
import org.apache.poi.hssf.record.formula.functions.True;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午1:55
 * To change this template use File | Settings | File Templates.
 */
public class WidgetManagerImpl implements WidgetManager {

    @Resource
    private WidgetDAO widgetDAO;

    private static final Logger logger = LoggerFactory.getLogger(WidgetManagerImpl.class);

    /**
     * 新建一个 模块
     * @param widgetDO
     * @return
     */
    public ResultDO<WidgetDO> insertModuleInfo(WidgetDO widgetDO) {
        ResultDO<WidgetDO> result = new ResultSupport<WidgetDO>(false);
        try {
            validWidgetDO(widgetDO);
            widgetDO.setType(WidgetDO.WidgetTpye.MODULE);
            WidgetDO isExist = widgetDAO.queryModuleByName(widgetDO.getName());
             if(isExist != null){
                 return result ;
             }
                 result.setModule(widgetDAO.insertWidgetInfo(widgetDO));
                 result.setSuccess(null != result.getModule());
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while insert module : " + e.getMessage();
            result.addMessage(exmsg);
         } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while insert module : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    /**
     * 新建一个布局模块
     * @param widgetDO
     * @return
     */
    public ResultDO<WidgetDO> insertLayoutInfo(WidgetDO widgetDO) {
        ResultDO<WidgetDO> result = new ResultSupport<WidgetDO>(false);
        try {
            validWidgetDO(widgetDO);
            widgetDO.setType(WidgetDO.WidgetTpye.LAYOUT);
            WidgetDO isExist = widgetDAO.queryModuleByName(widgetDO.getName());
            if(isExist != null){
                return result ;
            }
            result.setModule(widgetDAO.insertWidgetInfo(widgetDO));
            result.setSuccess(null != result.getModule());
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while insert module : " + e.getMessage();
            result.addMessage(exmsg);
        } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while insert module : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    /**
     * 更新一个 widget
     * @param widgetDO
     * @return
     */
    public ResultDO<WidgetDO> updateWidgetInfo(WidgetDO widgetDO) {
        ResultDO<WidgetDO> result = new ResultSupport<WidgetDO>(false);
        try {
            validWidgetDO(widgetDO);
            widgetDAO.updateWidgetInfo(widgetDO);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while update module : " + e.getMessage();
            result.addMessage(exmsg);
        } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while update module : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    /**
     *  根据ID 查询 widget
     * @param widgetId
     * @return
     */
    public ResultDO<WidgetDO> queryWidgetInfoById(Integer widgetId) {
        ResultDO<WidgetDO> result = new ResultSupport<WidgetDO>(false);
        try {
            if(widgetId == null){
                return  result;
            }
            result.setModule(widgetDAO.queryWidgetInfoById(widgetId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query module : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    /**
     * 查询所有 模块
     * @return
     */
    public ResultDO<List<WidgetDO>> queryAllModule() {
        ResultDO<List<WidgetDO>> result = new ResultSupport<List<WidgetDO>>(false);
        try {
            result.setModule(widgetDAO.queryAllModule());
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query module : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    /**
     *  查询所有显示出来的模块
     * @return
     * @throws DAOException
     */
    public ResultDO<List<WidgetDO>> queryShowModule() {
        ResultDO<List<WidgetDO>> result = new ResultSupport<List<WidgetDO>>(false);
        try {
            result.setModule(widgetDAO.queryShowModule());
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query module : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    /**
     * 根据name 查询 Module
     * @param name
     * @return
     */
    public ResultDO<WidgetDO> queryModuleByName(String name) {
        ResultDO<WidgetDO> result = new ResultSupport<WidgetDO>(false);
        try {
            if("".equals(name)){
                return  result;
            }
            result.setModule(widgetDAO.queryModuleByName(name));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query module : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    /**
     * 根据那么查询布局
     * @param name
     * @return
     */
    public ResultDO<WidgetDO> queryLayoutByName(String name) {
        ResultDO<WidgetDO> result = new ResultSupport<WidgetDO>(false);
        try {
            if("".equals(name)){
                return  result;
            }
            result.setModule(widgetDAO.queryLayoutByName(name));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query module : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    /**
     * 根据ID 删除一个widget
     * @param widgetId
     * @return
     */
    public ResultDO<WidgetDO> deleteWidgetById(Integer widgetId) {
        ResultDO<WidgetDO> result = new ResultSupport<WidgetDO>(false);
        try {
            if(widgetId == null){
                return  result;
            }
            widgetDAO.deleteWidgetById(widgetId);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while delete module : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    private void validWidgetDO(WidgetDO widgetDO) throws DataException {
        if (widgetDO == null) {
            throw new DataException("-1", "widget对象不能为NULL");
        }
        if ("".equals(widgetDO.getName())) {
            throw new DataException("-1", "widget对象name 不能为空！");
        }
    }

    public WidgetDAO getWidgetDAO() {
        return widgetDAO;
    }

    public void setWidgetDAO(WidgetDAO widgetDAO) {
        this.widgetDAO = widgetDAO;
    }
}
