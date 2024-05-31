package com.pluralsight;

import com.pluralsight.classes.Customer;
import com.pluralsight.classes.Order;
import com.pluralsight.classes.Receipt;
import com.pluralsight.foodType.Chips;
import com.pluralsight.foodType.Drink;
import com.pluralsight.foodType.Sandwich;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.Meat;
import com.pluralsight.toppings.RegularToppings;
import com.pluralsight.toppings.Toppings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Order currentOrder;


    public void homeScreen() {

        while (true) {
            displayHomeScreen();
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    System.out.println("Enter your name");
                    String userName = scanner.nextLine();
                    List<Sandwich> sandwiches = new ArrayList<>();
                    List<Drink> drinks = new ArrayList<>();
                    List<Chips> chips = new ArrayList<>();
                    currentOrder = new Order(sandwiches, drinks, chips, 0.0, new Customer(userName));
                    displayOrderScreen();
                    break;
                case 0:
                    System.out.println("Exiting the program");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    public void displayHomeScreen() {
        System.out.println("Welcome to Singh's Sandies Sandwich Shop");
        System.out.println("1. New Order");
        System.out.println("0. Exit Application");
    }

    public void displayOrderScreen() {
        while (true) {
            System.out.println("Current Order");
            displayOrderDetails(currentOrder);
            System.out.println(("\n 1. Add Sandwich"));
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel and exit");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    currentOrder.addSandwich(getSandwich());
                    break;
                case 2:
                    currentOrder.addDrinks(getDrink());
                    break;
                case 3:
                    currentOrder.addChips(getChip());
                    break;
                case 4:
                    Receipt receipt = new Receipt(currentOrder);
                    try {
                        receipt.saveReceipt();
                    } catch (IOException e) {
                        System.out.println("Unable to save receipt");
                    }
                    return;
                case 0:
                    System.out.println("Canceled order");
                    return;
            }
        }
    }

    public void displayOrderDetails(Order order) {
        List<Sandwich> sandwiches = order.getSandwiches();
        List<Drink> drinks = order.getDrinks();
        List<Chips> chips = order.getChips();

        if (sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }

        if (!sandwiches.isEmpty()) {
            System.out.println("Sandwiches:");
            for (Sandwich sandwich : sandwiches) {
                System.out.println("   " + sandwich.getDetails() + "  $" + String.format("%.2f", sandwich.getPrice()));
            }
        }
        if (!drinks.isEmpty()) {
            System.out.println("\nDrinks:");
            for (Drink drink : drinks) {
                System.out.println("   " + drink.getDetails() + " $" + String.format("%.2f", drink.getPrice()));
            }
        }

        if (!chips.isEmpty()) {
            System.out.println("\nChips:");
            for (Chips chip : chips) {
                System.out.println("   " + chip.getDetails() + " $" + String.format("%.2f", chip.getPrice()));
            }
        }

    }

    public Sandwich getSandwich() {
        System.out.println("Sandwich Order:");
        System.out.println("Select what size Sandwich you want:Small (4inch),Medium (8inch),Large (12inch)");
        String sandwichSize = scanner.nextLine().toLowerCase();

        int breadSelection;
        do {
            System.out.println("Select bread type:");
            for (int i = 0; i < Sandwich.breadTypes.size(); i++) {

                System.out.println((i + 1) + " " + Sandwich.breadTypes.get(i));
            }

            System.out.print("Enter the number of your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Enter a integer number");
                scanner.next();
            }
            breadSelection = scanner.nextInt();
            scanner.nextLine();

            if (breadSelection < 1 || breadSelection > Sandwich.breadTypes.size()) {
                System.out.println("Invalid slection");
            }
        } while (breadSelection < 1 || breadSelection > Sandwich.breadTypes.size());

        String breadType = Sandwich.breadTypes.get(breadSelection - 1);


        List<Toppings> toppings = new ArrayList<>();
                toppings.addAll(getToppings(RegularToppings.vegetables, "vegetables", 0.0));
                toppings.addAll(getToppings(Meat.meats,"meat",0.0));
                toppings.addAll(getToppings(Cheese.cheese,"cheese",0.0));


        System.out.println("Do you want to toast your sandwich (yes/no)");
        boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");


        Sandwich sandwich = new Sandwich(sandwichSize,breadType,toppings,isToasted);
        System.out.println(sandwich.getDetails());
        System.out.println("Price: $" + sandwich.getPrice());


        return sandwich;

    }
    public Drink getDrink(){
        System.out.println("Drink Selection:");
        System.out.println("Select Drink of choice");

        for (int i = 0; i < Drink.drinkFlavors.size(); i++) {
            System.out.println((i+1)+ " " + Drink.drinkFlavors.get(i));
        }
        String drinkType = scanner.nextLine().toLowerCase();

        System.out.println("Select the size of your drink: small, medium, large:");
        String drinkSize = scanner.nextLine().toLowerCase();
        return new Drink(drinkType,drinkSize);
    }
    public Chips getChip(){
        System.out.println("Chips selection:");
        System.out.println("Enter chip flavor (any)");
        String chipFlavor = scanner.nextLine();
        return new Chips(chipFlavor);
    }
    public List<Toppings> getToppings(List<String> types, String toppingType, double price){
        List<Toppings> toppings = new ArrayList<>();
        while (true) {
            System.out.println("\n Choose your " + toppingType + " 0 to finish adding toppings" );
            for (int i = 0; i < types.size(); i++) {
                System.out.println((i + 1) + ". " + types.get(i));
            }

            int toppingChoice = scanner.nextInt();
            scanner.nextLine();

            if (toppingChoice == 0) {
                break;
            }

            String toppingName = types.get(toppingChoice - 1);

            boolean isExtra = false;
            if (toppingType.equalsIgnoreCase("meat") || toppingType.equalsIgnoreCase("cheese")) {
                System.out.print("Would you like extra " + toppingName + " (yes/no): ");

                isExtra = scanner.nextLine().equalsIgnoreCase("yes");
            }

            Toppings topping;
            if (toppingType.equalsIgnoreCase("meat")) {
                topping = new Meat(toppingName, isExtra);
                toppings.add(topping);
            } else if (toppingType.equalsIgnoreCase("cheese")) {
                topping = new Cheese(toppingName, isExtra);
                toppings.add(topping);
            } else {
                topping = new RegularToppings(toppingName,0.0);
                toppings.add(topping);

            }

        }
        return toppings;
    }


}

