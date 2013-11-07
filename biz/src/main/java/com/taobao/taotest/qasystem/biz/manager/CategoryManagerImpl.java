package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.Exception.DataException;
import com.taobao.taotest.qasystem.biz.dao.CategoryDAO;
import com.taobao.taotest.qasystem.biz.domain.CategoryDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.result.ResultSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午7:17
 * To change this template use File | Settings | File Templates.
 */
public class CategoryManagerImpl implements  CategoryManager {

    @Resource
    private CategoryDAO categoryDAO;
    private static final Logger logger = LoggerFactory.getLogger(CategoryManagerImpl.class);

  public ResultDO<CategoryDO> insertCategory(CategoryDO categoryDO) {
      ResultDO<CategoryDO> result = new ResultSupport<CategoryDO>(false);
      try {
          validCategoryDO(categoryDO);
          result.setModule(categoryDAO.insertCategory(categoryDO));
          result.setSuccess(null != result.getModule());
      } catch (DAOException e) {
          logger.error("", e);
          String exmsg = "Caught ex while insert category : " + e.getMessage();
          result.addMessage(exmsg);
      } catch (DataException e){
          logger.error("", e);
          String exmsg = "Caught ex while insert category : " + e.getMessage();
          result.addMessage(exmsg);
      }
      return result;
  }




    public ResultDO<CategoryDO> updateCategory(CategoryDO categoryDO) {
        ResultDO<CategoryDO> result = new ResultSupport<CategoryDO>(false);
        try {
            validCategoryDO(categoryDO);
            categoryDAO.updateCategory(categoryDO);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while update category : " + e.getMessage();
            result.addMessage(exmsg);
        } catch (DataException e){
            logger.error("", e);
            String exmsg = "Caught ex while update category : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }



    public ResultDO<CategoryDO> queryCategoryById(Integer categoryId) {
        ResultDO<CategoryDO> result = new ResultSupport<CategoryDO>(false);
        try {
            if(categoryId == null){
                return  result;
            }
            result.setModule(categoryDAO.queryCategoryById(categoryId));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query category : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<List<CategoryDO>> queryCategoryByName(String name) {
        ResultDO<List<CategoryDO>> result = new ResultSupport<List<CategoryDO>>(false);
        try {
            if(name == null){
                return  result;
            }
            result.setModule(categoryDAO.queryCategoryByName(name));
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query category : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<List<CategoryDO>> queryAllCategory() {
        ResultDO<List<CategoryDO>> result = new ResultSupport<List<CategoryDO>>(false);
        try {
            result.setModule(categoryDAO.queryAllCategory());
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while query all category : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }

    public ResultDO<CategoryDO> deleteCategoryById(Integer categoryId) {
        ResultDO<CategoryDO> result = new ResultSupport<CategoryDO>(false);
        try {
            if(categoryId == null){
                return  result;
            }
            categoryDAO.deleteCategoryById(categoryId);
            result.setSuccess(Boolean.TRUE);
        } catch (DAOException e) {
            logger.error("", e);
            String exmsg = "Caught ex while delete category : " + e.getMessage();
            result.addMessage(exmsg);
        }
        return result;
    }


    private void validCategoryDO(CategoryDO categoryDO) throws DataException {
        if (categoryDO == null) {
            throw new DataException("-1", "分类不能为NULL");
        }
        if ("".equals(categoryDO.getName())) {
            throw new DataException("-1", "分类名称 不能为空！");
        }
    }     
        
        
        
        
    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
}
