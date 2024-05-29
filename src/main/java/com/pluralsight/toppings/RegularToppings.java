package com.pluralsight.toppings;

import java.util.List;
import java.util.stream.Stream;

public class RegularToppings extends Toppings{
    private final List<String> vegetables = Stream.of("lettuce","peppers","onions","tomatoes","jalapenos","cucumbers","pickles","guacamole","mushrooms")
            .toList();


    public RegularToppings(String name, double price) {
        super(name, 0.0);

        if(!vegetables.contains(name)){
            throw new IllegalArgumentException("Bread type does not match available vegetables");
        }
    }

    @Override
    public double getPricebySize(String size) {
        return 0.0;
    }
}