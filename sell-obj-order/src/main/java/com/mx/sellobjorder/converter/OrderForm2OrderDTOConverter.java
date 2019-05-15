package com.mx.sellobjorder.converter;

import com.alibaba.fastjson.JSON;
import com.mx.sellobjorder.domain.OrderDetail;
import com.mx.sellobjorder.dto.OrderDTO;
import com.mx.sellobjorder.form.OrderForm;

import java.util.List;

/**
 * @author mx
 * @date 2019/5/10 2:05 PM
 */
public class OrderForm2OrderDTOConverter {

    /**
     * 将OrderForm转换为OrderDTO
     * @param orderForm
     * @return
     */
    public static OrderDTO convert(OrderForm orderForm) {

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setOpenId(orderForm.getOpenId());

        String items = orderForm.getItems();

        List<OrderDetail> orderDetails = JSON.parseArray(items, OrderDetail.class);
        orderDetails = (List<OrderDetail>) JSON.parse(items);

        orderDTO.setOrderDetailList(orderDetails);

        return orderDTO;

    }
}
