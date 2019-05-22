package com.mx.product.service.impl;

import com.mx.product.common.DecreaseStockInput;
import com.mx.product.common.ProductInfoOutput;
import com.mx.product.domain.ProductInfo;
import com.mx.product.enums.ResultEnum;
import com.mx.product.exception.ProductException;
import com.mx.product.repository.ProductInfoRepository;
import com.mx.product.service.ProductService;
import com.mx.product.util.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author mx
 * @date 2019/5/20 3:56 PM
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputs) {

        // 减库存
        List<ProductInfo> productInfos = this.doDecreasestock(decreaseStockInputs);

        List<Object> list = productInfos.stream().map(e -> {
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e, productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());
        // 发送消息队列
        amqpTemplate.convertAndSend("productInfoQueue", JsonUtil.toJson(list));
    }

    /**
     * 减库存操作具体方法
     * @param decreaseStockInputs
     * @return
     */
    @Transactional
    public List<ProductInfo> doDecreasestock(List<DecreaseStockInput> decreaseStockInputs) {

        List<ProductInfo> productInfos = new ArrayList<>();

        decreaseStockInputs.forEach(decreaseStockInput -> {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            // 判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            // 检查库存是否足够
            Integer stock = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (stock < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(stock);
            productInfoRepository.save(productInfo);

            productInfos.add(productInfo);
        });
        return productInfos;
    }
}
