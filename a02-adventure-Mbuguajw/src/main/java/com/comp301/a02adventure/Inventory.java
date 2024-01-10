package com.comp301.a02adventure;

import java.util.List;

public interface Inventory {

  boolean isEmpty();

  int getNumItems();

  List<Item> getItems();

  void addItem(Item item);

  void removeItem(Item item);

  void clear();

  void transferFrom(Inventory other);
}
