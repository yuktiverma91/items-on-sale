package com.rbc.interview.user.controller;

import com.rbc.interview.user.exceptions.UserNotFoundException;
import com.rbc.interview.user.models.User;
import com.rbc.interview.user.models.UserWishList;
import com.rbc.interview.user.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class WishListController {
    @Autowired
    WishListRepo wishListRepo;

    /**
     *
     * */
    @GetMapping("/usersWishList/{user-id}")
    public List<String> getWlById(@PathVariable(value = "user-id") String userId) throws UserNotFoundException {
        return wishListRepo.findWishListByUserId(userId);
    }
}
