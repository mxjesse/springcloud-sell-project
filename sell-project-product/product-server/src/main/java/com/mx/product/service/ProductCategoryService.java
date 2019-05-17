package com.mx.product.service;

import com.mx.product.domain.ProductCategory;

import java.util.List;

/**
 * @author mx
 * @date 2019/5/8 12:57 AM
 */
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);
}
