package com.taobao.taotest.qasystem.biz.manager;

import com.taobao.taotest.qasystem.biz.domain.CategoryDO;
import com.taobao.taotest.qasystem.biz.result.ResultDO;
import com.taobao.taotest.qasystem.biz.result.ResultSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-17
 * Time: 下午7:17
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryManager {

    public ResultDO<CategoryDO> insertCategory(CategoryDO categoryDO);

    public ResultDO<CategoryDO> updateCategory(CategoryDO categoryDO);

    public ResultDO<CategoryDO> queryCategoryById(Integer categoryId);

    public ResultDO<List<CategoryDO>> queryCategoryByName(String name);

    public ResultDO<List<CategoryDO>> queryAllCategory();

    public ResultDO<CategoryDO> deleteCategoryById(Integer categoryId);

}
