package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;

import java.util.Arrays;

public class SomeBusiness {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data){
        return Arrays.stream(data)
                .sum();
    }

    public int calculateSumUsingDataService(){
        int[] data = someDataService.retrieveAllData();
        return Arrays.stream(data)
                .sum();
    }
}
