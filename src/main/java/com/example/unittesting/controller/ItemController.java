package com.example.unittesting.controller;

import com.example.unittesting.business.ItemBusinessService;
import com.example.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("dummy-item")
    public Item getDummyItem(){
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("item-from-business-service")
    public Item getItemFromBusinessService(){
        return businessService.retreiveHardcodedItem();
    }

    @GetMapping("all-items-from-database")
    public List<Item> retrieveAllItems() {
        return businessService.retrieveAllItems();
    }
}
