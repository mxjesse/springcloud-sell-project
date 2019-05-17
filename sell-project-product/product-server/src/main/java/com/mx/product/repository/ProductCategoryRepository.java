package com.mx.product.repository;

import com.mx.product.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mx on 2019/5/7 11:42 PM
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 根据产品类别编号categoryTypes查询产品类别信息
     * @param categoryTypes
     * @return
     */
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);
}
