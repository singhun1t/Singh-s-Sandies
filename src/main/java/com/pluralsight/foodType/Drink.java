package com.pluralsight.foodType;

import com.pluralsight.interfaces.Orderable;

import java.util.List;
import java.util.stream.Stream;

public class Drink implements Orderable {
    String flavor;
    String size;
    private final List<String> drinkFlavors = Stream.of("Coke","Pepsi","Sprite","Mtn. Dew")
            .toList();

    private final double smallSoda = 2.00;
    private final double mediumSoda = 2.50;
    private final double largeSoda = 3.00;

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    public String getDetails(){
        return String.format("%s %s", size, flavor);
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
