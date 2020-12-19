package com.rbc.interview.inventory.inventorymanagement.repository;

import com.rbc.interview.inventory.inventorymanagement.models.CategoryItemMapping;
import com.rbc.interview.inventory.inventorymanagement.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryItemRepo  extends JpaRepository<CategoryItemMapping,String> {

    @Query("Select categoryId from CategoryItemMapping where itemId = ?1 ")
    String findCategoryByItem(String itemId) ;

    @Query("Select itemId, itemName from CategoryItemMapping, Item where CategoryItemMapping.itemId = Item.itemId" +
            "  categoryId = ?1 LIMIT ?2")
    List<String> findItemsFromCategory(String categoryId, int rowLimit) ;
}
