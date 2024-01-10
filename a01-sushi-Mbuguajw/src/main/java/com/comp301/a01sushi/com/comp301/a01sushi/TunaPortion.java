package com.comp301.a01sushi;

public class TunaPortion extends IngredientPortionImpl {
  public TunaPortion(double amount) {
    super(amount, new Tuna());
  }

  public TunaPortion combine(IngredientPortionImpl other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("Invalid input");
    } else {
      double newAmount = this.getAmount() + other.getAmount();
      TunaPortion combined = new TunaPortion(newAmount);
      return combined;
    }
  }
}
