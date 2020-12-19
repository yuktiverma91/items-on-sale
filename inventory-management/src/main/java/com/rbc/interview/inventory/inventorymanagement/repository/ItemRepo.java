package com.rbc.interview.inventory.inventorymanagement.repository;

import com.rbc.interview.inventory.inventorymanagement.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.SqlResultSetMapping;
import java.util.List;

@Repository

public interface ItemRepo extends JpaRepository<Item,String> {

     //@Query("Select categoryId,itemId, itemName from Item where itemId = ?1 ")
    // //findItem(String itemId) ;

//    KC01	0001	BarKeeper
  //  KC01	0002	DishwasherLiquid
    //BC001	0003	Windex
}
