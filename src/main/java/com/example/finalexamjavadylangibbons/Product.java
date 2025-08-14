package com.example.finalexamjavadylangibbons;

public class Product {
  public int id;
  public String sku;
  public String name;
  public double salePrice;
  public double regularPrice;

  @Override
  public String toString() {
    return name + "-$" + salePrice;
  }
}


//This class should track the sku, name, sale price, regular price and a String to hold the url information for
//the image. This class should also have a toString() method.
//The toString() method should format the response as “[name]-$[sale price]”.
//For example “T-shirt with Logo-$17.00”.