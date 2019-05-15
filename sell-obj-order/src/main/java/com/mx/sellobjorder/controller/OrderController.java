package com.mx.sellobjorder.controller;

import com.mx.sellobjorder.converter.OrderForm2OrderDTOConverter;
import com.mx.sellobjorder.domain.OrderDetail;
import com.mx.sellobjorder.dto.OrderDTO;
import com.mx.sellobjorder.enums.ResultEnum;
import com.mx.sellobjorder.exception.OrderException;
import com.mx.sellobjorder.form.OrderForm;
import com.mx.sellobjorder.service.OrderService;
import com.mx.sellobjorder.util.ResultVOUtil;
import com.mx.sellobjorder.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * @author mx
 * @date 2019/5/8 4:36 PM
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @return
     */
    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm) {

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();

        if (CollectionUtils.isEmpty(orderDetailList)) {
            logger.error("【创建订单】购物车信息为空！");
            throw new OrderException(ResultEnum.CART_EMPTY.getCode(), ResultEnum.CART_EMPTY.getMsg());
        }

        OrderDTO result = orderService.create();

        HashMap<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }
}
