package com.example.unittesting.business;

import com.example.unittesting.enums.Color;

public class ParameterTestExample {

    public boolean canCarPassAccordingToTheTrafficLight(Color color){
        return Color.GREEN.equals(color);
    }

    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
