package com.example.unittesting.business;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.data.SomeDataService;
import com.example.unittesting.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business;

    @Mock
    private ItemRepository repository;

    @Test
    void calculateSum_basics(){
        when(repository.findAll()).thenReturn(List.of(
                new Item(2, "Item2", 10, 10),
                new Item(3, "Item3", 20, 20)
        ));

        List<Item> result = business.retrieveAllItems();

        assertEquals(100, result.get(0).getValue());
        assertEquals(400, result.get(1).getValue());
    }

}