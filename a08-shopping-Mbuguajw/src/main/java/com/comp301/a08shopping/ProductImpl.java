package com.comp301.a08shopping;

public class ProductImpl implements Product {

  private String productName;
  private double price;

  public ProductImpl(String name, double basePrice) {
    if (basePrice <= 0.00) {
      throw new IllegalArgumentException();
    }
    productName = name;
    price = basePrice;
  }

  @Override
  public String getName() {
    return productName;
  }

  @Override
  public double getBasePrice() {
    return price;
  }
}
