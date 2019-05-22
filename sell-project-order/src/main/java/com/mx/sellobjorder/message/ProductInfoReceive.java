package com.mx.sellobjorder.message;

import com.alibaba.fastjson.JSON;
import com.mx.product.common.ProductInfoOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author mx
 * @date 2019/5/16 6:18 PM
 */
@Component
public class ProductInfoReceive {

    public static final String PRODUCT_STOCK = "PRODUCT_STOCK_%s";

    public static final Logger logger = LoggerFactory.getLogger(ProductInfoReceive.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfoQueue"))
    public void reduceStock(String msg) {

        List<ProductInfoOutput> productInfoOutputs = JSON.parseArray(msg, ProductInfoOutput.class);
        logger.info("从消息队列【{}】接收到的消息{}", "productInfoQueue", productInfoOutputs.toString());

        if (productInfoOutputs.size() > 0) {

            for (ProductInfoOutput productInfoOutput : productInfoOutputs) {
                stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK, String.valueOf(productInfoOutput.getProductId())),
                        String.valueOf(productInfoOutput.getProductStock()));
            }
        }
    }
}
