package com.comp301.a02adventure;

public interface Player {

  Position getPosition();

  Inventory getInventory();

  String getName();

  void move(Direction direction);
}
