package com.comp301.a01sushi;

public class ShrimpPortion extends IngredientPortionImpl {
  public ShrimpPortion(double amount) {
    super(amount, new Shrimp());
  }

  public ShrimpPortion combine(IngredientPortionImpl other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("Invalid input");
    } else {
      double newAmount = this.getAmount() + other.getAmount();
      ShrimpPortion combined = new ShrimpPortion(newAmount);
      return combined;
    }
  }
}
