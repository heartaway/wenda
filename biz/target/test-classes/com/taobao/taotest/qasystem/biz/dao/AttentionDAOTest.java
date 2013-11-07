//package com.taobao.taotest.qasystem.biz.dao;
//
//import com.taobao.common.dao.persistence.exception.DAOException;
//import com.taobao.taotest.qasystem.biz.domain.AttentionDO;
//import junit.framework.Assert;
//import org.junit.Ignore;
//import org.junit.Test;
//
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * User: xinyuan.ymm
// * Date: 12-11-14
// * Time: 下午7:15
// * To change this template use File | Settings | File Templates.
// */
//@Ignore
//public class AttentionDAOTest extends BaseDAOTestCase {
//
//
//    @Test
//    public void testAddAttention() throws Exception {
//        AttentionDO attentionDO = new AttentionDO();
//        attentionDO.setQuestionId(1);
//        attentionDO.setUserId(123456);
//        attentionDAO.addAttention(attentionDO);
//        List<AttentionDO>  attentionDOs = attentionDAO.queryAttentionsByUserId(123456);
//        System.out.println(attentionDOs.get(0).getUserId());
//        Assert.assertEquals(1,attentionDOs.size());
//    }
//
//    @Test
//    public void testDeleteAttentionById() throws Exception {
//        List<AttentionDO>  attentionDOs = attentionDAO.queryAttentionsByUserId(123456);
//        attentionDAO.deleteAttentionById(attentionDOs.get(0).getId());
//        List<AttentionDO>  attentionDOList = attentionDAO.queryAttentionsByUserId(123456);
//        Assert.assertEquals(0,attentionDOList.size());
//    }
//
//
//}
