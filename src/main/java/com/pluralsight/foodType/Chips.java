package com.pluralsight.foodType;

import com.pluralsight.interfaces.Orderable;

public class Chips implements Orderable {

    String flavor;
    double price = 1.50;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {

        return price;
    }

    public String getDetails(){
        return flavor + "chips";
    }


}
