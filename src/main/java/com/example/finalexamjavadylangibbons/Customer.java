//Name: Dylan Gibbons; Student Number: 200230810

package com.example.finalexamjavadylangibbons;

import java.util.Arrays;

public class Customer {
    public int id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public Integer[] purchases;
    public double salePrice;
    public double[] regularPrices;
    public double[] salePrices;

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
