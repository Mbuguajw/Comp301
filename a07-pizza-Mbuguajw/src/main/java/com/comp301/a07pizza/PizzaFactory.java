package com.comp301.a07pizza;

import com.comp301.a07pizza.Pizza.Size;
import java.util.ArrayList;

public class PizzaFactory {
  public static Pizza makeCheesePizza(Size size) {
    return new PizzaImpl(
        size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, new ArrayList<Topping>());
  }

  public static Pizza makeHawaiianPizza(Size size) {
    ArrayList<Topping> hamPineapple = new ArrayList<>();
    hamPineapple.add(Topping.HAM);
    hamPineapple.add(Topping.PINEAPPLE);
    return new PizzaImpl(size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, hamPineapple);
  }

  public static Pizza makeMeatLoversPizza(Size size) {
    ArrayList<Topping> theMeats = new ArrayList<>();
    theMeats.add(Topping.PEPPERONI);
    theMeats.add(Topping.SAUSAGE);
    theMeats.add(Topping.BACON);
    theMeats.add(Topping.GROUND_BEEF);
    return new PizzaImpl(size, Crust.DEEP_DISH, Sauce.TOMATO, Cheese.BLEND, theMeats);
  }

  public static Pizza makeVeggieSupremePizza(Size size) {
    ArrayList<Topping> veggies = new ArrayList<>();
    veggies.add(Topping.SUN_DRIED_TOMATO);
    veggies.add(Topping.GREEN_PEPPER);
    veggies.add(Topping.MUSHROOMS);
    veggies.add(Topping.OLIVES);
    return new PizzaImpl(size, Crust.THIN, Sauce.TOMATO, Cheese.BLEND, veggies);
  }

  public static Pizza makeDailySpecialPizza() {
    ArrayList<Topping> everything = new ArrayList<>();
    everything.add(Topping.TOMATO);
    everything.add(Topping.SPINACH);
    everything.add(Topping.ONION);
    everything.add(Topping.GROUND_BEEF);
    everything.add(Topping.GARLIC);
    everything.add(Topping.BUFFALO_CHICKEN);
    everything.add(Topping.BACON);
    everything.add(Topping.PINEAPPLE);
    everything.add(Topping.SAUSAGE);
    everything.add(Topping.PEPPERONI);
    everything.add(Topping.HAM);
    everything.add(Topping.OLIVES);
    everything.add(Topping.GREEN_PEPPER);
    everything.add(Topping.MUSHROOMS);
    everything.add(Topping.SUN_DRIED_TOMATO);
    everything.add(Topping.ANCHOVIES);
    everything.add(Topping.JALAPENO);
    return new PizzaImpl(Size.LARGE, Crust.DEEP_DISH, Sauce.PESTO, Cheese.MOZZARELLA, everything);
  }
}
