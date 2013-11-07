//package com.taobao.taotest.qasystem.biz.dao;
//
//import com.taobao.taotest.qasystem.biz.domain.CategoryDO;
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
// * Time: 下午7:16
// * To change this template use File | Settings | File Templates.
// */
//@Ignore
//public class CategoryDAOTest extends  BaseDAOTestCase {
//
//    @Test
//    public void testInsertCategory() throws Exception {
//        CategoryDO categoryDO  = new CategoryDO();
//        categoryDO.setCategoryId(1);
//        categoryDO.setName("软件测试");
//        categoryDO.setQuestionCount(100);
//        categoryDAO.insertCategory(categoryDO);
//        List<CategoryDO>  categoryDOs = categoryDAO.queryCategoryByName("软件测试");
//        Assert.assertEquals(1,categoryDOs.size());
//
//    }
//
//    @Test
//    public void testQueryCategoryById() throws Exception {
//        List<CategoryDO>  categoryDOs = categoryDAO.queryCategoryByName("软件测试");
//        CategoryDO categoryDO = categoryDAO.queryCategoryById(categoryDOs.get(0).getId());
//        Assert.assertNotNull(categoryDO);
//    }
//
//    @Test
//    public void testQueryCategoryByName() throws Exception {
//        List<CategoryDO>  categoryDOs = categoryDAO.queryCategoryByName("软件测试");
//        System.out.println("name"+categoryDOs.get(0).getName());
//        Assert.assertEquals(1,categoryDOs.size());
//    }
//
//    @Test
//    public void testDeleteCategoryById() throws Exception {
//        List<CategoryDO>  categoryDOs = categoryDAO.queryCategoryByName("软件测试");
//        System.out.println(categoryDOs.get(0).getId());
//        categoryDAO.deleteCategoryById(categoryDOs.get(0).getId());
//        CategoryDO categoryDO = categoryDAO.queryCategoryById(categoryDOs.get(0).getId());
//        Assert.assertNull(categoryDO);
//    }
//}
