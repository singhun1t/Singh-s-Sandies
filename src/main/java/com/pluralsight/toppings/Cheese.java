package com.pluralsight.toppings;

import java.util.List;
import java.util.stream.Stream;

public class Cheese extends PremiumToppings{

    public static final List<String> cheese = Stream.of(
            "american", "provolone", "cheddar", "swiss"
    ).toList();

    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);

        if(!cheese.contains(name)){
            throw new IllegalArgumentException("Invalid cheese choice");
        }
    }




}
