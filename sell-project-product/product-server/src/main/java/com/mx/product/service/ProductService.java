package com.mx.product.service;

import com.mx.product.common.DecreaseStockInput;

import java.util.List;

/**
 * @author mx
 * @date 2019/5/20 3:55 PM
 */
public interface ProductService {

    void decreaseStock(List<DecreaseStockInput> decreaseStockInputs);
}
