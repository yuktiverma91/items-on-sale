package com.rbc.interview.rating.RatingManagement.controller;

import com.rbc.interview.rating.RatingManagement.models.Rating;
import com.rbc.interview.rating.RatingManagement.models.RatingId;
import com.rbc.interview.rating.RatingManagement.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RatingController {

    @Autowired
    RatingRepo ratingRepo;

    @GetMapping("/{user-id}/{item-id}")
    public Optional<Rating> getAllRatingsByUserIdItemId(@PathVariable(value = "user-id") String userId,
                                                        @PathVariable(value = "item-id") String itemId) {
        return ratingRepo.findById(new RatingId(userId,itemId));
    }
    @GetMapping("/{user-id}/itemList/{rating}")
    public Map<String,Integer> getRatingOfItemsByUserId(@PathVariable(value = "user-id") String userId,
                                                        @PathVariable(value = "rating") String itemIdList) {
            String[] itemIdArray = itemIdList.split(",");
            Map<String,Integer> itemIdRatingMap = new HashMap<>();

            Arrays.asList(itemIdArray).forEach(itemId -> {
            if (ratingRepo.findById(new RatingId(userId, itemId)).isPresent())
            itemIdRatingMap.put(itemId, ratingRepo.findById(new RatingId(userId, itemId)).get().getRating());
        });
        return itemIdRatingMap;
    }

}
