package com.pluralsight.toppings;

public abstract class Toppings {

    String name;
    double price;

    public Toppings(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract double getPricebySize(String size);



    @Override
    public String toString() {
        return name;
    }
}
