package com.rbc.interview.order.ordermanagement.repository;

import com.rbc.interview.order.ordermanagement.models.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderRepo extends JpaRepository<UserOrder,String> {

    @Query("Select orderId from UserOrder where userId = ?1 ")
    List<String> findOrdersByUserId(String userId);


}
