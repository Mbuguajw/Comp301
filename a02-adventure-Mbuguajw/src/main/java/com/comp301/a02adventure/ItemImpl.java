package com.comp301.a02adventure;

public class ItemImpl implements Item {

  private final String itemName;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    } else {
      this.itemName = name;
    }
  }

  @Override
  public String getName() {
    return this.itemName;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ItemImpl) {
      return this.getName().equals(((ItemImpl) obj).getName());
    }
    return false;
  }

  @Override
  public String toString() {
    return this.getName();
  }
}
