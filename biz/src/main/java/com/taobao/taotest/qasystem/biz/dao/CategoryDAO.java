package com.taobao.taotest.qasystem.biz.dao;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.taotest.qasystem.biz.domain.CategoryDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-14
 * Time: 上午9:35
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryDAO {
    /**
     * 添加分类
     * @param categoryDO
     * @throws DAOException
     */
    public CategoryDO insertCategory( CategoryDO categoryDO) throws DAOException;

    /**
     *   更新分类
     * @param categoryDO
     * @throws DAOException
     */
    public void updateCategory( CategoryDO categoryDO) throws DAOException;

    /**
     *    根据id查询查询分类
     * @param categoryId
     * @return
     * @throws DAOException
     */
    public CategoryDO queryCategoryById( Integer categoryId) throws DAOException;

    /**
     * 根据Name查询分类
     * @param name
     * @return
     * @throws DAOException
     */
    public List<CategoryDO> queryCategoryByName( String  name)throws DAOException ;

    /**
     * 查询所有分类
     * @return
     * @throws DAOException
     */
    public List<CategoryDO> queryAllCategory( )throws DAOException ;


    /**
     *   删除分类
     * @param categoryId
     * @return
     * @throws DAOException
     */
    public int deleteCategoryById( Integer categoryId) throws DAOException;
}
