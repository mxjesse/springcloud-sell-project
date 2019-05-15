package com.mx.sellobjorder.repository;

import com.mx.sellobjorder.domain.Order;
import com.mx.sellobjorder.enums.OrderStatusEnum;
import com.mx.sellobjorder.enums.PayStatusEnum;
import com.netflix.discovery.converters.Auto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author mx
 * @date 2019/5/9 5:19 PM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void save() {

        Order order = new Order();
        order.setBuyerName("张三");
        order.setBuyerAddress("马坡花园二区8号楼6单元101");
        order.setBuyerPhone("17600000000");
        order.setOpenId("123456");
        order.setOrderAmount(new BigDecimal("50.0"));
        order.setOrderStatus(OrderStatusEnum.NEW.getCode());
        order.setPayStatus(PayStatusEnum.WAIT.getCode());
        order.setCreateTime(new Date());

        Order result = orderRepository.save(order);

        Assert.assertTrue(result != null);
    }
}