package com.comp301.a01sushi;

import java.util.ArrayList;
import java.util.LinkedList;

public class Roll implements Sushi {
  private String _name;
  private IngredientPortionImpl[] _recipeList;

  public Roll(String name, IngredientPortionImpl[] roll_ingredients) {
    if (roll_ingredients == null || name == null) {
      throw new IllegalArgumentException();
    } else {
      IngredientPortionImpl[] compared = roll_ingredients.clone();

      for (int z = 0; z < compared.length; z++) {
        if (compared[z] == null) {
          throw new IllegalArgumentException();
        }
      }
      this._name = name;
      boolean hasSeaweed = false;
      ArrayList<IngredientPortionImpl > arrayConverter = new ArrayList<>();

      /*for (int i = 0; i < compared.length; i++) {
        IngredientPortion newer = compared[i];
        for (int j = 0; j < roll_ingredients.length; j++) {
          IngredientPortion older = roll_ingredients[i];
          if (newer.getName().equals(older.getName())) {
            IngredientPortion combined = newer.combine(older);
            arrayConverter.add(combined);
          }
        }
        arrayConverter.add(newer);
      }*/
      // Seaweed loop checker

      for (int y = 0; y < compared.length; y++) {
        arrayConverter.add(compared[y]);
      }

      for (int k = 0; k < arrayConverter.size(); k++) {
        if (arrayConverter.get(k) instanceof SeaweedPortion) {
          if (((IngredientPortionImpl) arrayConverter.get(k)).getAmount() >= 0.1) {
            hasSeaweed = true;
            break;
          }
        }
      }

      if (hasSeaweed) {
        arrayConverter.add(new SeaweedPortion(0.1));
        IngredientPortionImpl[] newArray = new IngredientPortionImpl[arrayConverter.size() + 1];
        for (int l = 0; l < arrayConverter.size(); l++) {
          newArray[l] = arrayConverter.get(l);
        }
        this._recipeList = newArray;
      } else {
        IngredientPortionImpl[] newArray = new IngredientPortionImp;[arrayConverter.size()];
        for (int l = 0; l < arrayConverter.size(); l++) {
          newArray[l] = arrayConverter.get(l);
        }
        this._recipeList = newArray;
      }
    }
  }

  @Override
  public String getName() {
    return this._name;
  }

  @Override
  public IngredientPortionImp;[] getIngredients() {
    return this._recipeList;
  }

  @Override
  public int getCalories() {
    int caloricCount = 0;
    for (int i = 0; i < this.getIngredients().length; i++) {
      double calories = this.getIngredients()[i].getCalories();
      caloricCount += calories;
    }
    return Math.round(caloricCount);
  }

  @Override
  public double getCost() {
    double sushiRoll = 0;
    for (int i = 0; i < this.getIngredients().length; i++) {
      double cost = this.getIngredients()[i].getCost();
      sushiRoll += cost;
    }
    sushiRoll = sushiRoll * 100;
    return (Math.round(sushiRoll)) / 100;
  }

  @Override
  public boolean getHasRice() {
    for (int i = 0; i < this.getIngredients().length; i++) {
      if (this.getIngredients()[i].getIngredient().getName().equalsIgnoreCase("rice")) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    for (int i = 0; i < this.getIngredients().length; i++) {
      if (this.getIngredients()[i].getIngredient().getIsShellfish()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    for (int i = 0; i < this.getIngredients().length; i++) {
      if (!this.getIngredients()[i].getIngredient().getIsVegetarian()) {
        return false;
      }
    }
    return true;
  }
}
