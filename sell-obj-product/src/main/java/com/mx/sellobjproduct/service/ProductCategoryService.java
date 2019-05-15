package com.mx.sellobjproduct.service;

import com.mx.sellobjproduct.domain.ProductCategory;

import java.util.List;

/**
 * @author mx
 * @date 2019/5/8 12:57 AM
 */
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);
}
