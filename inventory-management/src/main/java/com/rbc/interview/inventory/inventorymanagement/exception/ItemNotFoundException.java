package com.rbc.interview.inventory.inventorymanagement.exception;

public class ItemNotFoundException extends Exception{

    private String itemId;
    public ItemNotFoundException(String itemId) {
        super(String.format("Item is not found with id : '%s'", itemId));
    }
}
