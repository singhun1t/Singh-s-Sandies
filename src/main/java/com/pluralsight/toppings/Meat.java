package com.pluralsight.toppings;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Meat extends PremiumToppings{
    private static final List<String> meats = Stream.of(
            "Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"
    ).toList();

    public Meat(String name, double price, boolean isExtra) {
        super(name, 0.0, isExtra);
    }


}
