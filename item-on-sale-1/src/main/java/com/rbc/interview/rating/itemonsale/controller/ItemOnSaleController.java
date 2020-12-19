package com.rbc.interview.rating.itemonsale.controller;

import com.rbc.interview.rating.itemonsale.models.Category;
import com.rbc.interview.rating.itemonsale.models.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommendations")
public class ItemOnSaleController {

    private final String ITEM_SERVICE_URL = "http://localhost:8082/";

    //check if valid userid
//get orders of a user id

    RestTemplate restTemplate = new RestTemplate();
    @RequestMapping("/{user-id}")
    public  Map<String, Double> getRecommendedList(@PathVariable(value = "user-id")String userId) {
        String ORDER_SERVICE_URL = "http://localhost:8083/order/";
        String RATING_SERVICE_URL = "http://localhost:8084/";

        RestTemplate restTemplate = new RestTemplate();

        List<String> allUserItemList = new ArrayList<>();

        //for each order, get all items
        Map<String, List<String>> orderMap = restTemplate.getForObject(ORDER_SERVICE_URL + userId, Map.class);
        if (null != orderMap) {
            orderMap.forEach((key, value) -> allUserItemList.addAll(value));
        }

        Map<String,Integer> itemRatingMap;
        String[] stringArray= Arrays.copyOf(allUserItemList.toArray(),allUserItemList.toArray().length,String[].class);

        itemRatingMap = restTemplate.getForObject(RATING_SERVICE_URL + userId + "/itemList/"+ String.join(",", stringArray), Map.class);

        //Item item = restTemplate1.getForObject("http://localhost:8082/item/"+itemId, Item.class);
        //for each item in itemRatingMap, get category id and add category id and item list to the map
        Map<String, List<String>> categoryItems = new HashMap<>();
        itemRatingMap.forEach((key,value) -> {
            String categoryId = restTemplate.getForObject(ITEM_SERVICE_URL + "category/" + key, String.class);
            if (null != categoryId) {
                categoryItems.computeIfAbsent(categoryId, K -> new ArrayList<>()).add(key);
            }
        });

        Map<String, Double> categoryRatings = new HashMap<>();

        //Why treemap
        Map<String, Double> categoryRatingsSorted = categoryRatings.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, TreeMap::new));

        categoryItems.forEach((categoryId, itemList) -> {
            List<Integer> ratingsInCategory = new ArrayList<>();
            itemList.forEach(itemId -> {
                if (null != itemRatingMap.get(itemId)) {
                    ratingsInCategory.add(itemRatingMap.get(itemId));
                }
            });
            var averageOfItems = ratingsInCategory.stream().mapToInt(Integer::intValue).average();
            if (averageOfItems.isPresent()) {
                categoryRatings.put(categoryId, averageOfItems.getAsDouble());
            }
        });

        categoryRatingsSorted.putAll(categoryRatings);
        //get all top n items based on category ranking from Item catalog
        return categoryRatingsSorted;
        //do
        //for each item

        //if there's a rating, add item to a map<item,rating>
        //group the items by category id
        //Map<Category,ItemList>
        //get average of rating of items for Map1
        //new treemap<Category,Rating>
        //for each category, display items on sale


        //traverse the queue and get category for each item and display items onSale
    }

}
