package com.comp301.a01sushi;

public class EelPortion extends IngredientPortionImpl {
  public EelPortion(double amount) {
    super(amount, new Eel());
  }

  public EelPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("Invalid Type");
    } else {
      double newAmount = this.getAmount() + other.getAmount();
      EelPortion combined = new EelPortion(newAmount);
      return combined;
    }
  }
}
