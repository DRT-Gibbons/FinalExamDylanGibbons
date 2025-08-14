package com.example.finalexamjavadylangibbons;

import java.util.Arrays;

public class Customer {
    public int id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public Integer[] purchases;

    // Method to return total purchases as double using streams
    public double getTotalPurchases() {
        if (purchases == null) {
            return 0.0;
        }

        // Convert array to stream avoid null exception and convert to double then sum
        return Arrays.stream(purchases).filter(p -> p != null)
                .mapToDouble(Integer::doubleValue)
                .sum();
    }
}
