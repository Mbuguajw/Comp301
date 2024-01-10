package com.comp301.a02adventure;

public class MapImpl implements Map {

  private final Cell[][] mapLocations;
  private final int collectables;

  public MapImpl(int width, int height, int numItems) {
    System.out.println(width + " " + height + " " + numItems);
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException();
    }
    this.mapLocations = new Cell[width][height];
    this.collectables = numItems;
  }

  @Override
  public int getWidth() {
    return this.mapLocations.length;
  }

  @Override
  public int getHeight() {
    return this.mapLocations[0].length;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x >= this.getWidth() || y >= this.getHeight()) {
      throw new IndexOutOfBoundsException();
    } else {
      return this.mapLocations[x][y];
    }
  }

  @Override
  public Cell getCell(Position position) {
    if (position.getX() >= this.getWidth() || position.getY() >= this.getHeight()) {
      throw new IndexOutOfBoundsException();
    } else {
      return getCell(position.getX(), position.getY());
    }
  }

  @Override
  public void initCell(int x, int y) {
    if (x >= this.getWidth() || y >= this.getHeight()) {
      throw new IndexOutOfBoundsException();
    } else {
      Cell place = new CellImpl(x, y);
      this.mapLocations[x][y] = place;
    }
  }

  @Override
  public int getNumItems() {
    return this.collectables;
  }

  public Cell[][] getMapLocations() {
    return this.mapLocations;
  }
}
