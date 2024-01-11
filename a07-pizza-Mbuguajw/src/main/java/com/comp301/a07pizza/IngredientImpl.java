package com.comp301.a07pizza;

public class IngredientImpl implements Ingredient {
  protected String name;
  protected boolean vegetarian;
  protected boolean vegan;

  public IngredientImpl(String ingredientName, boolean isVegetarian, boolean isVegan) {
    name = ingredientName;
    vegetarian = isVegetarian;
    vegan = isVegan;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isVegetarian() {
    return vegetarian;
  }

  @Override
  public boolean isVegan() {
    return vegan;
  }
}
