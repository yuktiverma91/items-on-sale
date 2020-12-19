package com.rbc.interview.inventory.inventorymanagement.models;

import com.rbc.interview.inventory.inventorymanagement.repository.ItemRepo;

import javax.persistence.*;


@Entity
@Table (name  = "item")
public class Item {


    @Id
    String itemId;
    String itemName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "CategoryItemMapping",
            joinColumns = { @JoinColumn(name = "itemId") },
            inverseJoinColumns = { @JoinColumn(name = "itemId") })


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
