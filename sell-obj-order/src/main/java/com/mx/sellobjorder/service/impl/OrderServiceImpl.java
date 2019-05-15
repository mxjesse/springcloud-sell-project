package com.mx.sellobjorder.service.impl;

import com.mx.sellobjorder.domain.Order;
import com.mx.sellobjorder.domain.OrderDetail;
import com.mx.sellobjorder.dto.OrderDTO;
import com.mx.sellobjorder.enums.OrderStatusEnum;
import com.mx.sellobjorder.enums.PayStatusEnum;
import com.mx.sellobjorder.repository.OrderRepository;
import com.mx.sellobjorder.service.OrderService;
import com.mx.sellobjorder.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mx
 * @date 2019/5/10 10:11 AM
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDTO create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(KeyUtil.genericKey());
        Order order = new Order();

        orderDTO.setBuyerName("孟先生");
        orderDTO.setBuyerPhone("17600884404");
        orderDTO.setBuyerAddress("马坡花园二区8号楼6单元101");
        orderDTO.setOrderAmount(new BigDecimal(50));

        BeanUtils.copyProperties(orderDTO, order);

        order.setOrderStatus(OrderStatusEnum.NEW.getCode());
        order.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderRepository.save(order);

        return orderDTO;
    }
}
