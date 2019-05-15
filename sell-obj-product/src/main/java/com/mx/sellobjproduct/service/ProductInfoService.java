package com.mx.sellobjproduct.service;

import com.mx.sellobjproduct.domain.ProductInfo;

import java.util.List;

/**
 * @author mx
 * @date 2019/5/8 12:17 AM
 */
public interface ProductInfoService {

    /**
     * 查询所有在出售商品列表
     * @return
     */
    List<ProductInfo> findAllUp();
}
