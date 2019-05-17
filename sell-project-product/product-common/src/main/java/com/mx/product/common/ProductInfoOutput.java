package com.mx.product.common;

import java.math.BigDecimal;

/**
 * @author mx
 * @date 2019/5/17 1:05 AM
 */
public class ProductInfoOutput {

    private Integer productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品价格
     */
    private BigDecimal productPrice;

    /**
     * 产品库存
     */
    private Integer productStock;

    /**
     * 产品描述
     */
    private String productDescription;

    /**
     * 产品略缩图
     */
    private String productIcon;

    /**
     * 产品上下架状态
     */
    private Integer status;

    /**
     * 产品品种类型
     */
    private Integer categoryType;
}
