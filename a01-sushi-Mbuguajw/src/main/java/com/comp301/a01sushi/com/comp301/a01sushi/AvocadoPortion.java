package com.comp301.a01sushi;

public class AvocadoPortion extends IngredientPortionImpl {
  public AvocadoPortion(double amount) {
    super(amount, new Avocado());
  }

  public AvocadoPortion combine(IngredientPortionImpl other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("Invalid Type");
    } else {
      double newAmount = this.getAmount() + other.getAmount();
      AvocadoPortion combined = new AvocadoPortion(newAmount);
      return combined;
    }
  }
}
