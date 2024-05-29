package com.pluralsight.classes;

import com.pluralsight.foodType.Chips;
import com.pluralsight.foodType.Drink;
import com.pluralsight.foodType.Sandwich;

import java.util.List;
import java.util.Scanner;

public class Order {

    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;
    private double orderTotal;
    private Customer customer;


    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips, double orderTotal, Customer customer) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
        this.orderTotal = 0;
        this.customer = customer;
    }

    public void addSandwich(Sandwich sandwich) {
        if (sandwich != null) {
            sandwiches.add(sandwich);
            orderTotal += sandwich.getPrice();
        }

    }
    public void addChips (Chips chip){
        if(chips != null){
            chips.add(chip);
            orderTotal += chip.getPrice();
        }
    }
    public void addDrinks (Drink drink){
        if(drink != null){
            drinks.add(drink);
            orderTotal+= drink.getPrice();
        }

    }
    public double calculateTotal(){

        for (Sandwich sandwich : sandwiches) {
            orderTotal += sandwich.getPrice();
        }
        for (Chips chip : chips){
            orderTotal += chip.getPrice();

        }
        for (Drink drink : drinks){
            orderTotal += drink.getPrice();
        }
        return orderTotal;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}



