//package com.taobao.taotest.qasystem.biz.dao;
//
//import com.taobao.taotest.qasystem.biz.domain.UserDO;
//import org.junit.Ignore;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created with IntelliJ IDEA.
// * User: xinyuan.ymm
// * Date: 12-11-14
// * Time: 下午7:18
// * To change this template use File | Settings | File Templates.
// */
//@Ignore
//public class UserDAOTest extends BaseDAOTestCase {
//
//    @Test
//    public void testGetUserInfoById() throws Exception{
//        UserDO userDO = userDAO.queryUserInfoById(1);
//        System.out.println(userDO.getName());
//        assertEquals("taotestadmin",userDO.getName());
//    }
//
//    @Test
//    public void testGetUserInfoByName() throws Exception{
//        UserDO userDO = userDAO.queryUserInfoByName("taotestadmin");
//        assertEquals("1",userDO.getId().toString());
//    }
//
//}
