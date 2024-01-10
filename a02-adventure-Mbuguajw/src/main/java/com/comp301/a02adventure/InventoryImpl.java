package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {

  private List<Item> backPack;

  public InventoryImpl() {
    this.backPack = new ArrayList<>();
  }

  @Override
  public boolean isEmpty() {
    return this.backPack.isEmpty();
  }

  @Override
  public int getNumItems() {
    return this.backPack.size();
  }

  @Override
  public List<Item> getItems() {
    return new ArrayList<>(this.backPack);
  }

  @Override
  public void addItem(Item item) {
    this.backPack.add(item);
  }

  @Override
  public void removeItem(Item item) {
    this.backPack.remove(item);
  }

  @Override
  public void clear() {
    this.backPack.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    List<Item> otherList = new ArrayList<>(other.getItems());
    other.clear();
    this.backPack.addAll(otherList);
  }
}
