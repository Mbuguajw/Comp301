package com.comp301.a01sushi;

public class CrabPortion extends IngredientPortionImpl {
  public CrabPortion(double amount) {
    super(amount, new Crab());
  }

  public CrabPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("Invalid Type");
    } else {
      double newAmount = this.getAmount() + other.getAmount();
      CrabPortion combined = new CrabPortion(newAmount);
      return combined;
    }
  }
}
