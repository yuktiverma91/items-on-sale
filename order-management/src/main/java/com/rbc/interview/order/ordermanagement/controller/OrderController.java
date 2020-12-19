package com.rbc.interview.order.ordermanagement.controller;

import com.rbc.interview.order.ordermanagement.models.OrderDetail;
import com.rbc.interview.order.ordermanagement.models.UserOrder;
import com.rbc.interview.order.ordermanagement.repository.OrderDetailRepo;
import com.rbc.interview.order.ordermanagement.repository.UserOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    OrderDetailRepo orderDetailRepo;
    @Autowired
    UserOrderRepo userOrderRepo;
    //get all orders with user id
    @GetMapping("/order/{user-id}")
    public Map<String, List<String>> getOrderByUserId(@PathVariable(value = "user-id")String userId) {

        List<String> userOrders = userOrderRepo.findOrdersByUserId(userId);
        Map<String, List<String>> userOrdersMap = new HashMap<>();
        userOrders.forEach(userOrder -> userOrdersMap.put(userOrder, orderDetailRepo.findItemsByOrderId(userOrder)));
        return userOrdersMap;

    }





    //for each order id, get list of item ids
}
