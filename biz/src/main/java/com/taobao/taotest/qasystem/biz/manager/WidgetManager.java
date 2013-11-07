package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.taotest.qasystem.biz.domain.WidgetDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午1:54
 * To change this template use File | Settings | File Templates.
 */
public interface WidgetManager {
    /**
     * 新建一个 模块
     *
     * @param widgetDO
     * @return
     */
    public ResultDO<WidgetDO> insertModuleInfo(WidgetDO widgetDO);

    /**
     * 新建一个布局模块
     *
     * @param widgetDO
     * @return
     */
    public ResultDO<WidgetDO> insertLayoutInfo(WidgetDO widgetDO);

    /**
     * 更新一个 widget
     *
     * @param widgetDO
     * @return
     */
    public ResultDO<WidgetDO> updateWidgetInfo(WidgetDO widgetDO);

    /**
     * 根据ID 查询 widget
     *
     * @param widgetId
     * @return
     */
    public ResultDO<WidgetDO> queryWidgetInfoById(Integer widgetId);

    /**
     * 查询所有 模块
     *
     * @return
     */
    public ResultDO<List<WidgetDO>> queryAllModule();

    /**
     * 查询所有显示出来的模块
     *
     * @return
     */
    public ResultDO<List<WidgetDO>> queryShowModule();

    /**
     * 根据name 查询 Module
     *
     * @param name
     * @return
     */
    public ResultDO<WidgetDO> queryModuleByName(String name);

    /**
     * 根据那么查询布局
     *
     * @param name
     * @return
     */
    public ResultDO<WidgetDO> queryLayoutByName(String name);

    /**
     * 根据ID 删除一个widget
     * @param widgetId
     * @return
     */
    public ResultDO<WidgetDO> deleteWidgetById(Integer widgetId);
}
