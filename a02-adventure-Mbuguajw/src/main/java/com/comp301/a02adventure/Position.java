package com.comp301.a02adventure;

public interface Position {

  int getX();

  int getY();

  Position getNeighbor(Direction direction);
}
