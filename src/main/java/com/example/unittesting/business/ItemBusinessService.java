package com.example.unittesting.business;

import com.example.unittesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

    public Item retreiveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
