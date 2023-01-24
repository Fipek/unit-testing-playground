package com.example.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessTest {

    @Test
    void calculateSum_basics(){
        SomeBusiness business = new SomeBusiness();
        int actualResult = business.calculateSum(new int[]{1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_empty(){
        SomeBusiness business = new SomeBusiness();
        int actualResult = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_oneValue(){
        SomeBusiness business = new SomeBusiness();
        int actualResult = business.calculateSum(new int[]{5});
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}