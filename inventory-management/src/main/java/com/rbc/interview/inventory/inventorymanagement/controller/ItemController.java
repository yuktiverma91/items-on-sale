package com.rbc.interview.inventory.inventorymanagement.controller;

import com.rbc.interview.inventory.inventorymanagement.exception.ItemNotFoundException;
import com.rbc.interview.inventory.inventorymanagement.models.CategoryItemMapping;
import com.rbc.interview.inventory.inventorymanagement.models.Item;
import com.rbc.interview.inventory.inventorymanagement.repository.CategoryItemRepo;
import com.rbc.interview.inventory.inventorymanagement.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    CategoryItemRepo categoryItemRepo;

    @GetMapping("/item/{item-id}")
    public Optional<Item> getItemDetails(@PathVariable(value = "item-id") String item_id) throws ItemNotFoundException{
        return itemRepo.findById(item_id);
    }
    @GetMapping("/category/{item-id}")
    public String getCategoryByItemId(@PathVariable(value = "item-id") String item_id) {
        return categoryItemRepo.findCategoryByItem(item_id);
    }

    @GetMapping("/category/{category-id}/{row-limit}")
    public List<String> findItemsFromCategory(@PathVariable(value = "category-id") String categoryId, @PathVariable(value = "row-limit") int rowLimit) {
         return categoryItemRepo.findItemsFromCategory(categoryId,rowLimit);
    }
    //findItemsFromCategory
}
