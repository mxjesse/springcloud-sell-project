package com.mx.sellobjproduct.service.impl;

import com.mx.sellobjproduct.domain.ProductCategory;
import com.mx.sellobjproduct.repository.ProductCategoryRepository;
import com.mx.sellobjproduct.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mx
 * @date 2019/5/8 2:30 PM
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypes);
    }
}
