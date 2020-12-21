package com.rbc.interview.user.repository;

import com.rbc.interview.user.models.UserWishList;
import com.rbc.interview.user.models.WishListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface WishListRepo extends JpaRepository<UserWishList, String> {

    @Query("Select itemId from UserWishList where user_id = ?1 ")
    List<String> findWishListByUserId(String userId);
}
