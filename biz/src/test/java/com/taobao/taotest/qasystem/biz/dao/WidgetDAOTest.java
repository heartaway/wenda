//package com.taobao.taotest.qasystem.biz.dao;
//
//import com.taobao.common.dao.persistence.exception.DAOException;
//import com.taobao.taotest.qasystem.biz.domain.QuestionDO;
//import com.taobao.taotest.qasystem.biz.domain.WidgetDO;
//import org.junit.Ignore;
//import org.junit.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Created with IntelliJ IDEA.
// * User: xinyuan.ymm
// * Date: 12-11-14
// * Time: 下午7:17
// * To change this template use File | Settings | File Templates.
// */
//@Ignore
//public class WidgetDAOTest extends BaseDAOTestCase {
//
//    @Test
//    public void testInsertWidgetInfo() throws Exception {
//        WidgetDO widgetDO = new WidgetDO();
//        widgetDO.setSrc("homeList.vm");
//        widgetDO.setName("个人列表");
//        widgetDO.setStatus(Boolean.TRUE);
//        widgetDO.setType(WidgetDO.WidgetTpye.MODULE);
//        widgetDAO.insertWidgetInfo(widgetDO);
//    }
//
//    @Test
//    public void testQueryAllModule() throws Exception {
//        List<WidgetDO> widgetDOs = widgetDAO.queryAllModule();
//        assertNotSame(0, widgetDOs.size());
//    }
//
//    @Test
//    public void testQueryShowModule() throws Exception {
//        List<WidgetDO> widgetDOs = widgetDAO.queryAllModule();
//        assertNotSame(0, widgetDOs.size());
//    }
//
//
//    @Test
//    public void testQueryWidgetInfoById() throws Exception {
//        List<WidgetDO> widgetDOs = widgetDAO.queryAllModule();
//        WidgetDO widgetDO = widgetDAO.queryWidgetInfoById(widgetDOs.get(0).getId());
//        System.out.println(widgetDO.getSrc());
//        assertEquals("homeList.vm", widgetDO.getSrc());
//        assertTrue(widgetDO.getStatus());
//        assertEquals(WidgetDO.WidgetTpye.MODULE, widgetDO.getType());
//    }
//
//    @Ignore
//    @Test
//    public void testQueryModuleByName() throws Exception {
//        WidgetDO widgetDO = widgetDAO.queryModuleByName("个人列表");
//        assertNotNull(widgetDO);
//        assertEquals("个人列表", widgetDO.getName());
//        assertTrue(widgetDO.getStatus());
//        assertEquals(WidgetDO.WidgetTpye.MODULE, widgetDO.getType());
//    }
//
//    @Test
//    public void testUpdateWidgetInfo() throws Exception {
//        List<WidgetDO> widgetDOs = widgetDAO.queryAllModule();
//        WidgetDO widgetDO = widgetDAO.queryWidgetInfoById(widgetDOs.get(0).getId());
//        widgetDO.setName("我的列表");
//        widgetDO.setType(WidgetDO.WidgetTpye.LAYOUT);
//        widgetDAO.updateWidgetInfo(widgetDO);
//        WidgetDO widgetDOAfter = widgetDAO.queryWidgetInfoById(widgetDOs.get(0).getId());
//        assertEquals("我的列表", widgetDOAfter.getName().toString());
//    }
//
//
//    @Test
//    public void testQueryLayoutByName() throws Exception {
//        WidgetDO widgetDO = widgetDAO.queryLayoutByName("我的列表");
//        assertNotNull(widgetDO);
//        assertEquals("我的列表", widgetDO.getName());
//        assertTrue(widgetDO.getStatus());
//        assertEquals(WidgetDO.WidgetTpye.LAYOUT, widgetDO.getType());
//    }
//
//    @Test
//    public void testDeleteWidgetById() throws Exception {
//        WidgetDO widgetDO = widgetDAO.queryLayoutByName("我的列表");
//        widgetDAO.deleteWidgetById(widgetDO.getId());
//        WidgetDO widgetDOAfter = widgetDAO.queryWidgetInfoById(widgetDO.getId());
//        assertNull(widgetDOAfter);
//    }
//
//
//}
