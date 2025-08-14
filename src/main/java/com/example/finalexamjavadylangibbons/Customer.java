//Name: Dylan Gibbons; Student Number: 200230810

package com.example.finalexamjavadylangibbons;

import java.util.Arrays;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    double[] salePrices;
    private double[] regularPrices;

    //  getters for TableView
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Getter for total purchases, changed from what I initially had it
    public double getTotalPurchases() {
        if (salePrices == null) return 0.0;

        return Arrays.stream(salePrices)
                .sum();
    }

    // getter for savings
    public double getTotalSaved() {
        double totalSaved = 0.0;

        // length set this way to avoid index issues
        int length = Math.min(regularPrices.length, salePrices.length);
        //simple for loop
        for (int i = 0; i < length; i++) {
            //getting difference between for each set and adding to total saved
            totalSaved += (regularPrices[i] - salePrices[i]);
        }
        return totalSaved;
    }
}
