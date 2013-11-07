package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.WidgetDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
public interface WidgetDAO {

    /**
     * 插入一个widget
     * @param widgetDO
     * @throws DAOException
     */
    public WidgetDO insertWidgetInfo(WidgetDO widgetDO) throws DAOException;

    /**
     * 更新一个widget
     * @param widgetDO
     * @return
     * @throws DAOException
     */
    public int updateWidgetInfo(WidgetDO widgetDO) throws DAOException;

    /**
     * 通过ID 查询widget
     * @param widgetId
     * @return
     * @throws DAOException
     */
    public WidgetDO queryWidgetInfoById(Integer widgetId) throws DAOException;

    /**
     * 查询所有模块 ,
     * @return
     * @throws DAOException
     */
    public List<WidgetDO> queryAllModule() throws DAOException;

    /**
     *  查询所有显示出来的模块
     * @return
     * @throws DAOException
     */
    public List<WidgetDO> queryShowModule() throws DAOException;

    /**
     * 根据name 查询 Module
     * @param name
     * @return
     * @throws DAOException
     */
    public WidgetDO queryModuleByName(String name)  throws DAOException;

    /**
     * 根据那么查询布局
     * @param name4Layout
     * @return
     * @throws DAOException
     */
    public WidgetDO queryLayoutByName(String name4Layout) throws DAOException;

    /**
     * 删除一个widget
     * @param widgetId
     * @return
     * @throws DAOException
     */
    public int deleteWidgetById(Integer widgetId) throws DAOException;
}
