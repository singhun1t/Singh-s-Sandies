package com.pluralsight.foodType;

import com.pluralsight.interfaces.Orderable;
import com.pluralsight.toppings.Toppings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sandwich implements Orderable {
    public static final List<String> breadTypes = Arrays.asList("white", "Wheat", "Rye", "Wrap");


    String size;
    List<Toppings> toppings;
    String breadType;
    boolean isToasted;


    public Sandwich(String size, String breadType, List<Toppings> toppings, boolean isToasted) {
        if(!breadTypes.contains(breadType)){
            throw new IllegalArgumentException("Bread type does not match available bread types");
        }
        this.size = size;
        this.breadType = breadType;
        this.toppings = toppings;
        this.isToasted = isToasted;
    }







    public String getDetails(){
       // String details = " ";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(size.charAt(0)).append(size.substring(1)).append(" ").append(breadType).append(" sandwich");
        if(isToasted){
            stringBuilder.append(" Toasted");
        }
        if(!toppings.isEmpty()){
            stringBuilder.append("\n Toppings: ");
            for (Toppings topping : toppings) {
                stringBuilder.append(topping.toString());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }



    @Override
    public double getPrice() {
        double totalPrice = 0.0;
        switch(size){
            case "small":
                totalPrice = totalPrice + 5.50;
                break;
            case "medium":
                totalPrice = totalPrice + 7.00;
                break;
            case "large":
                totalPrice = totalPrice + 8.50;
                break;
        }
        for (Toppings topping : toppings){
            totalPrice += topping.getPricebySize(size);
        }
        return totalPrice;
    }
}
