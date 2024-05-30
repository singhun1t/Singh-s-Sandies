package com.pluralsight.foodType;

import com.pluralsight.interfaces.Orderable;

import java.util.List;
import java.util.stream.Stream;

public class Drink implements Orderable {
   private String flavor;
    private String size;
    private double price;

    public static List<String> drinkFlavors = Stream.of("Coke","Pepsi","Sprite","Mtn. Dew")
            .toList();

    private final double smallSoda = 2.00;
    private final double mediumSoda = 2.50;
    private final double largeSoda = 3.00;

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
        this.price = calculatePrice(size);
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


    public double calculatePrice(String size) {
        switch (size) {
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: throw new IllegalArgumentException("Invalid size");

        }

    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
