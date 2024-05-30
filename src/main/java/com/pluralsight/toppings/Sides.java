package com.pluralsight.toppings;

import java.util.List;
import java.util.stream.Stream;

public class Sides extends RegularToppings{
    private final List<String> sides = Stream.of("au jus","sauce")
            .toList();

    public Sides(String name, double price) {
        super(name,0.0);

        if(!sides.contains(name)){
            throw new IllegalArgumentException("Side does not exist");
        }
    }
}
