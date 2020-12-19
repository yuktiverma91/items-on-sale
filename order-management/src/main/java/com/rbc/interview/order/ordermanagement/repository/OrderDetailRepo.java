package com.rbc.interview.order.ordermanagement.repository;
import java.lang.String;

import com.rbc.interview.order.ordermanagement.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail,String>  {

@Query("Select itemId from OrderDetail where orderId = ?1 ")
List<String> findItemsByOrderId(String orderId);

}
