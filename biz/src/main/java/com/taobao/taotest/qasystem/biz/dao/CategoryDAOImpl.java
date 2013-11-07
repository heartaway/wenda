package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.SqlMapBaseDAO;
import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.CategoryDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time: 上午9:30
 * To change this template use File | Settings | File Templates.
 */
public class CategoryDAOImpl extends SqlMapBaseDAO implements CategoryDAO {

    public CategoryDO insertCategory(CategoryDO categoryDO)
            throws DAOException {
        super.executeInsert("CategoryDAO.insert", categoryDO, null);
        return categoryDO;
    }


    public void updateCategory(CategoryDO categoryDO)
            throws DAOException {
        super.executeUpdate("CategoryDAO.update", categoryDO, null);
    }

    public CategoryDO queryCategoryById(Integer categoryId)
            throws DAOException {
        return (CategoryDO) super.executeQueryForObject("CategoryDAO.queryById", categoryId, null);
    }

    public List<CategoryDO> queryCategoryByName(String name)
            throws DAOException {
        return super.executeQueryForList("CategoryDAO.queryByName", name, null);
    }

    public List<CategoryDO> queryAllCategory()
            throws DAOException {
        return super.executeQueryForList("CategoryDAO.queryAllCategory", null, null);
    }

    public int deleteCategoryById(Integer categoryId)
            throws DAOException {
        return super.executeUpdate("CategoryDAO.deleteById", categoryId, null);
    }

}
