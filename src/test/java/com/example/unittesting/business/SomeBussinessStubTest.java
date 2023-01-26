package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}

class SomeDataServiceOneElementStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1};
    }
}

// Bad approach. It is not maintainable.
// For example if we add a new method to SomeDataService we have got error in here.(Not implemented method)

public class SomeBussinessStubTest {

    @Test
    void calculateSumUsingDataService_basics(){
        SomeBusiness business = new SomeBusiness();
        business.setSomeDataService(new SomeDataServiceStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumUsingDataService_empty(){
        SomeBusiness business = new SomeBusiness();
        business.setSomeDataService(new SomeDataServiceEmptyStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumUsingDataService_oneValue(){
        SomeBusiness business = new SomeBusiness();
        business.setSomeDataService(new SomeDataServiceOneElementStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 1;

        assertEquals(expectedResult, actualResult);
    }
}
