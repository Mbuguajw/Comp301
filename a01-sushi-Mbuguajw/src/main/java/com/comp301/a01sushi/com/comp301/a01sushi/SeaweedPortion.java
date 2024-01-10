package com.comp301.a01sushi;

public class SeaweedPortion extends IngredientPortionImpl {
  public SeaweedPortion(double amount) {
    super(amount, new Seaweed());
  }

  public SeaweedPortion combine(IngredientPortionImpl other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("Invalid input");
    } else {
      double newAmount = this.getAmount() + other.getAmount();
      SeaweedPortion combined = new SeaweedPortion(newAmount);
      return combined;
    }
  }
}
