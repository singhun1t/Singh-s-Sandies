package com.pluralsight.toppings;

import java.util.List;
import java.util.stream.Stream;

public class Sauce extends RegularToppings{
    private final List<String> sauces = Stream.of("mayo","mustard","ketchup","ranch","thousand islands","vinaigrette")
            .toList();

    public Sauce(String name) {
        super(name, 0.0);
        if(!sauces.contains(name)){
            throw new IllegalArgumentException("Bread type does not match available sauces");
        }
    }
}
