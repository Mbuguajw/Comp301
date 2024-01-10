package com.comp301.a01sushi;

public class Nigiri implements Sushi {
  private String _name;
  private IngredientPortionImpl _recipe;
  private IngredientPortionImpl _base;

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  public Nigiri(NigiriType type) {
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

    this._base = new RicePortion(0.5);
  }

  @Override
  public String getName() {
    return this._name + " nigiri";
  }

  @Override
  public IngredientPortionImpl[] getIngredients() {
    IngredientPortionImpl[] food = new IngredientPortionImpl[2];
    food[0] = this._recipe;
    food[1] = new RicePortion(0.5);
    return food;
  }

  @Override
  public int getCalories() {
    return (int) Math.round(this._recipe.getCalories() + this._base.getCalories());
  }

  @Override
  public double getCost() {
    double riceCost = this._base.getCost();
    double meatCost = this._recipe.getCost();
    return riceCost + meatCost;
  }

  @Override
  public boolean getHasRice() {
    return true;
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
