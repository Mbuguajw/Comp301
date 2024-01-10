package com.comp301.a02adventure;

public interface Map {

  int getWidth();

  int getHeight();

  Cell getCell(int x, int y);

  Cell getCell(Position position);

  void initCell(int x, int y);

  int getNumItems();

  Cell[][] getMapLocations();
}
