package com.comp301.a07pizza;

import java.util.ArrayList;

public class PizzaImpl implements Pizza {
  private Size circumference;
  private Crust breading;
  private Sauce saucy;
  private Cheese cheesy;
  private ArrayList<Topping> toppings;

  public PizzaImpl(Size size, Crust crust, Sauce sauce, Cheese cheese, ArrayList<Topping> topping) {
    if (size == null || crust == null || sauce == null || cheese == null || topping == null) {
      throw new IllegalArgumentException();
    }
    circumference = size;
    breading = crust;
    saucy = sauce;
    cheesy = cheese;
    toppings = topping;
  }

  @Override
  public boolean isVegetarian() {
    if (breading.isVegetarian() && saucy.isVegetarian() && cheesy.isVegetarian()) {
      boolean vegCheck = true;
      int i = 0;
      while (i < toppings.size() && vegCheck) {
        if (toppings.get(i).isVegetarian()) {
          vegCheck = true;
        } else {
          vegCheck = false;
        }
        i++;
      }
      return vegCheck;
    } else {
      return false;
    }
  }

  @Override
  public boolean isVegan() {
    if (breading.isVegan() && saucy.isVegan() && cheesy.isVegan()) {
      boolean vegCheck = true;
      int i = 0;
      while (i < toppings.size() && vegCheck) {
        if (toppings.get(i).isVegan()) {
          vegCheck = true;
        } else {
          vegCheck = false;
        }
        i++;
      }
      return vegCheck;
    } else {
      return false;
    }
  }

  @Override
  public double getPrice() {
    double total = 0;
    double topPrice = 0;
    if (circumference == Size.SMALL) {
      total += 7.00;
      topPrice += 0.25;
    }
    if (circumference == Size.MEDIUM) {
      total += 9.00;
      topPrice += 0.50;
    }
    if (circumference == Size.LARGE) {
      total += 11.00;
      topPrice += 0.75;
    }
    for (int i = 0; i < toppings.size(); i++) {
      total += topPrice;
    }
    return total;
  }

  @Override
  public Size getSize() {
    return circumference;
  }

  @Override
  public Ingredient getSauce() {
    return saucy;
  }

  @Override
  public Ingredient getCheese() {
    return cheesy;
  }

  @Override
  public Ingredient getCrust() {
    return breading;
  }

  @Override
  public Ingredient[] getToppings() {
    IngredientImpl[] getTop = new IngredientImpl[toppings.size()];
    for (int i = 0; i < getTop.length; i++) {
      getTop[i] = toppings.get(i);
    }
    return getTop;
  }

  @Override
  public Ingredient[] getIngredients() {
    IngredientImpl[] getIngred = new IngredientImpl[toppings.size() + 3];
    for (int i = 0; i < toppings.size(); i++) {
      getIngred[i] = toppings.get(i);
    }
    getIngred[toppings.size()] = cheesy;
    getIngred[toppings.size() + 1] = saucy;
    getIngred[toppings.size() + 2] = breading;
    return getIngred;
  }
}
