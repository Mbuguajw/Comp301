package com.comp301.a02adventure;

public class PositionImpl implements Position {

  private int _x;
  private int _y;

  public PositionImpl(int x, int y) {
    this._x = x;
    this._y = y;
  }

  @Override
  public int getX() {
    return this._x;
  }

  @Override
  public int getY() {
    return this._y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException();
    }
    switch (direction) {
      case EAST:
        return new PositionImpl(this._x + 1, this._y);
      case WEST:
        return new PositionImpl(this._x - 1, this._y);
      case NORTH:
        return new PositionImpl(this._x, this._y + 1);
      case SOUTH:
        return new PositionImpl(this._x, this._y - 1);
    }
    throw new IllegalArgumentException();
  }
}
