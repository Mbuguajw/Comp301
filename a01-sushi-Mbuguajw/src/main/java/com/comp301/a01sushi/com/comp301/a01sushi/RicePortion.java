package com.comp301.a01sushi;

public class RicePortion extends IngredientPortionImpl {
  public RicePortion(double amount) {
    super(amount, new Rice());
  }

  public RicePortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("Invalid type");
    } else {
      double newAmount = this.getAmount() + other.getAmount();
      RicePortion combined = new RicePortion(newAmount);
      return combined;
    }
  }
}
