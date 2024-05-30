package com.pluralsight.toppings;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Meat extends PremiumToppings{
    public static final List<String> meats = Stream.of(
            "Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"
    ).toList();

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }


}
