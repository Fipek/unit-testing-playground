package com.example.unittesting.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {

    @InjectMocks
    SomeBusiness business = new SomeBusiness();

    @Mock
    SomeDataService dataServiceMock;

    @BeforeEach
    public void before(){
        business.setSomeDataService(dataServiceMock);
    }

    @Test
    void calculateSum_basics(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});

        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    void calculateSum_empty(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});

        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    void calculateSum_oneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});

        assertEquals(5, business.calculateSumUsingDataService());
    }
}