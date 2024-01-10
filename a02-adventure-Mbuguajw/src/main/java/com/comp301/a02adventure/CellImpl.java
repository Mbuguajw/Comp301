package com.comp301.a02adventure;

public class CellImpl implements Cell {

  private String title;
  private String description;
  private Position location;
  private Inventory chestItem;
  private boolean isVisited;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null || description == null) {
      throw new IllegalArgumentException();
    } else {
      Position location = new PositionImpl(x, y);
      this.title = name;
      this.description = description;
      this.location = location;
      this.chestItem = null;
      this.isVisited = false;
    }
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  @Override
  public String getName() {
    return this.title;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public Position getPosition() {
    return this.location;
  }

  @Override
  public Inventory getChest() {
    return this.chestItem;
  }

  @Override
  public boolean getIsVisited() {
    return this.isVisited;
  }

  @Override
  public boolean hasChest() {
    return this.chestItem != null;
  }

  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    } else {
      this.title = name;
    }
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException();
    } else {
      this.description = description;
    }
  }

  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException();
    } else {
      System.out.println("There must be chest here!!");
      this.chestItem = chest;
    }
  }

  @Override
  public void visit() {
    this.isVisited = true;
  }
}
