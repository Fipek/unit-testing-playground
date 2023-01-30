package com.example.unittesting.enums;

import java.util.HashMap;
import java.util.Map;

public enum Color {
    UNDEFINED(0), RED(1), YELLOW(2), GREEN(3);

    private final int id;
    private static final Map<Integer, Color> colorMap = new HashMap<>();

    private Color(final int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static Color getStatusById(int id){
        return colorMap.getOrDefault(id,Color.UNDEFINED);
    }
}
