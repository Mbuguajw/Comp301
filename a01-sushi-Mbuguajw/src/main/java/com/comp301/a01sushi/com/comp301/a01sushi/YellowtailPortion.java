package com.comp301.a01sushi;

public class YellowtailPortion extends IngredientPortionImpl {

  public YellowtailPortion(double amount) {
    super(amount, new Yellowtail());
  }

  public YellowtailPortion combine(IngredientPortionImpl other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("Invalid input");
    } else {
      double newAmount = this.getAmount() + other.getAmount();
      YellowtailPortion combined = new YellowtailPortion(newAmount);
      return combined;
    }
  }
}
