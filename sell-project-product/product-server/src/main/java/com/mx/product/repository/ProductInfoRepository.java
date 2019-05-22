package com.mx.product.repository;

import com.mx.product.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mx on 2019/5/7 5:09 PM
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {

    /**
     * 根据上下架状态查询商品列表
     *
     * @param status
     * @return
     */
    public List<ProductInfo> findByStatus(Integer status);

    /**
     * 根据商品ids查询商品列表
     *
     * @param productIds
     * @return
     */
    public List<ProductInfo> findByProductIdIn(List<Integer> productIds);

}