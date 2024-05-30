package com.pluralsight.classes;

import com.pluralsight.foodType.Chips;
import com.pluralsight.foodType.Drink;
import com.pluralsight.foodType.Sandwich;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private Order order;
    private LocalDateTime time;
    private String file;

    public Receipt(Order order) {
        this.order = order;
        this.time = LocalDateTime.now();
        this.file = createFile();
    }

    public String createFile() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return "receipt" + time.format(formatter) + " .txt";

    }

    public String generateReceipt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Receipt for Singh's Sandies");
        stringBuilder.append("\n===========================");
        stringBuilder.append("\n Customer: ").append(order.getCustomer().getName()).append("\n");

        if (!order.getSandwiches().isEmpty()) {
            stringBuilder.append("\n Sandwiches \n");
            for (Sandwich sandwich : order.getSandwiches()) {

                stringBuilder.append(sandwich.getDetails()).append(" $").append(String.format("%.2f", sandwich.getPrice())).append("\n ");
            }
        }
        if(!order.getDrinks().isEmpty()){

            stringBuilder.append("\n Drinks \n");

            for (Drink drink : order.getDrinks()) {

                stringBuilder.append(drink.getDetails()).append(" $").append(String.format("%.2f", drink.getPrice())).append("\n ");

            }
        }
        if(!order.getChips().isEmpty()){

            stringBuilder.append("\n Chips \n");

            for (Chips chip : order.getChips()) {
                stringBuilder.append(chip.getDetails()).append(" $").append(String.format("%.2f", chip.getPrice())).append("\n ");
            }
        }
        stringBuilder.append(" \n Total: $").append(String.format("%.2f", order.calculateTotal()));
        stringBuilder.append("\n Thanks for shooping at Singh's Sandies");
        stringBuilder.append("\n Date: " ).append(time.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")));

        return stringBuilder.toString();
    }
    public void saveReceipt() throws IOException{
        int fileCount = 1;
        String uniqueFile = file;

        File receiptFile = new File(uniqueFile);
        while (receiptFile.exists()) {
            uniqueFile = String.format("%s_%d.txt", file.replace(".txt", ""), fileCount);
            receiptFile = new File(uniqueFile);
            fileCount++;
        }

        try (FileWriter fileWriter = new FileWriter(receiptFile)) {
            fileWriter.write(generateReceipt());
        }
        }

    }

