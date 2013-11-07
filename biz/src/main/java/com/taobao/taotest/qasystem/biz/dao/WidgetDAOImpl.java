package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.SqlMapBaseDAO;
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
public class WidgetDAOImpl extends SqlMapBaseDAO implements WidgetDAO {

    public WidgetDO insertWidgetInfo(WidgetDO widgetDO)
            throws DAOException {
        super.executeInsert("WidgetDAO.insert", widgetDO, null);
        return widgetDO;
    }


    public int updateWidgetInfo(WidgetDO widgetDO)
            throws DAOException {
        return super.executeUpdate("WidgetDAO.update", widgetDO, null);
    }

    public WidgetDO queryWidgetInfoById(Integer widgetId)
            throws DAOException {
        return (WidgetDO) super.executeQueryForObject("WidgetDAO.queryById", widgetId, null);
    }

    public List<WidgetDO> queryAllModule()
            throws DAOException {
        return super.executeQueryForList("WidgetDAO.queryAllModule", null, null);
    }

    public WidgetDO queryModuleByName(String name)
            throws DAOException {
        return (WidgetDO) super.executeQueryForObject("WidgetDAO.queryModuleByName", name, null);
    }

    public List<WidgetDO> queryShowModule()
            throws DAOException {
        return super.executeQueryForList("WidgetDAO.queryShowModule", null, null);
    }

    public WidgetDO queryLayoutByName(String name4Layout)
            throws DAOException {
        return (WidgetDO) super.executeQueryForObject("WidgetDAO.queryLayoutByName", name4Layout, null);
    }

    public int deleteWidgetById(Integer widgetId)
            throws DAOException {
        return super.executeUpdate("WidgetDAO.deleteById", widgetId, null);
    }

}
