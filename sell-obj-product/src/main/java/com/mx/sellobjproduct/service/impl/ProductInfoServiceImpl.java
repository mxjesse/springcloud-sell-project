package com.mx.sellobjproduct.service.impl;

import com.mx.sellobjproduct.domain.ProductInfo;
import com.mx.sellobjproduct.enums.ProductStatusEnum;
import com.mx.sellobjproduct.repository.ProductInfoRepository;
import com.mx.sellobjproduct.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mx
 * @date 2019/5/8 12:58 AM
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findAllUp() {

        return productInfoRepository.findByStatus(ProductStatusEnum.UP.getCode());
    }
}
