package com.comp301.a01sushi;

public class IngredientPortionImpl implements IngredientPortion {
  protected double _amount;
  protected IngredientImpl _ingredient;

  public IngredientPortionImpl(double amount, IngredientImpl food) {
    if (amount < 0) {
      throw new IllegalArgumentException("Invalid Type");
    } else {
      this._amount = amount;
      this._ingredient = food;
    }
  }

  @Override
  public IngredientImpl getIngredient() {
    return this._ingredient;
  }

  @Override
  public double getAmount() {
    return this._amount;
  }

  @Override
  public String getName() {
    return this.getIngredient().getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return this.getIngredient().getIsVegetarian();
  }

  @Override
  public boolean getIsRice() {
    return this.getIngredient().getIsRice();
  }

  @Override
  public boolean getIsShellfish() {
    return this.getIngredient().getIsShellfish();
  }

  @Override
  public double getCalories() {
    return this.getIngredient().getCaloriesPerOunce() * this.getAmount();
  }

  @Override
  public double getCost() {
    return this.getIngredient().getPricePerOunce() * this.getAmount();
  }

  public IngredientPortionImpl combine(IngredientPortion other) {
    return null;
  }
}
