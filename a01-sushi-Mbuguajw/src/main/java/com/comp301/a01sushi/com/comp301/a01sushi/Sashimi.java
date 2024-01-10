package com.comp301.a01sushi;

public class Sashimi implements Sushi {
  private String _name;
  private IngredientPortion _recipe;

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  public Sashimi(SashimiType type) {
    switch (type) {
      case TUNA:
        this._name = "tuna";
        this._recipe = new TunaPortion(0.75);
        break;
      case YELLOWTAIL:
        this._name = "yellowtail";
        this._recipe = new YellowtailPortion(0.75);
        break;
      case EEL:
        this._name = "eel";
        this._recipe = new EelPortion(0.75);
        break;
      case CRAB:
        this._name = "crab";
        this._recipe = new CrabPortion(0.75);
        break;
      case SHRIMP:
        this._name = "shrimp";
        this._recipe = new ShrimpPortion(0.75);
        break;
    }
  }

  @Override
  public String getName() {
    return this._name + " sashimi";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortionImpl[] food = new IngredientPortionImpl[1];
    food[0] = this._recipe;
    return food;
  }

  @Override
  public int getCalories() {
    double calCount = this._recipe.getCalories();
    return (int) Math.round(calCount);
  }

  @Override
  public double getCost() {
    double total = this._recipe.getCost();
    return total;
  }

  @Override
  public boolean getHasRice() {
    return this._recipe.getIsRice();
  }

  @Override
  public boolean getHasShellfish() {
    return this._recipe.getIsShellfish();
  }

  @Override
  public boolean getIsVegetarian() {
    return this._recipe.getIsVegetarian();
  }
}
