package com.mx.sellobjorder.message;

import com.alibaba.fastjson.JSON;
import com.mx.product.common.ProductInfoOutput;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mx
 * @date 2019/5/16 6:18 PM
 */
@Component
public class ProductInfoReceive {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfoQueue"))
    public void reduceStock(String msg) {
        ProductInfoOutput productInfoOutput = JSON.parseObject(msg, ProductInfoOutput.class);

    }
}
