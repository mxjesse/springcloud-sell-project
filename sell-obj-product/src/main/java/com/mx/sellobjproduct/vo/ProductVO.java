package com.mx.sellobjproduct.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author mx
 * @date 2019/5/9 9:45 AM
 */
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("products")
    private List<ProductInfoVO> productInfoVOList;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVO> getProductInfoVOList() {
        return productInfoVOList;
    }

    public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
        this.productInfoVOList = productInfoVOList;
    }
}
