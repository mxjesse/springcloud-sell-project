package com.mx.sellobjorder.repository;

import com.mx.sellobjorder.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mx
 * @date 2019/5/8 4:08 PM
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
