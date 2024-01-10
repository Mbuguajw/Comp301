package com.comp301.a01sushi;

public class IngredientImpl implements Ingredient {
  protected String _name;
  protected double _price;
  protected int _calories;
  protected boolean _isVegetarian;
  protected boolean _hasRice;
  protected boolean _hasShellfish;

  public String getName() {
    return this._name;
  }

  public double getCaloriesPerDollar() {
    double calPerPrice = this.getCaloriesPerOunce() / this.getPricePerOunce();
    return calPerPrice;
  }

  public int getCaloriesPerOunce() {
    return this._calories;
  }

  public double getPricePerOunce() {
    return this._price;
  }

  public boolean getIsVegetarian() {
    return this._isVegetarian;
  }

  public boolean getIsRice() {
    return this._hasRice;
  }

  public boolean getIsShellfish() {
    return this._hasShellfish;
  }

  public boolean equals(IngredientImpl other) {
    if (other != null) {
      if (this.getName().equals(other.getName())) {
        if (this.getPricePerOunce() == other.getPricePerOunce()) {
          if (this.getCaloriesPerOunce() == other.getCaloriesPerOunce()) {
            if (this.getIsVegetarian() == other.getIsVegetarian()) {
              if (this.getIsRice() == other.getIsRice()) {
                if (this.getIsShellfish() == other.getIsShellfish()) {
                  return true;
                }
              }
            }
          }
        }
      }
    }
    return false;
  }
}
