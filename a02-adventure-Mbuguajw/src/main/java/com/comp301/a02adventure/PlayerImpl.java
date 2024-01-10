package com.comp301.a02adventure;

public class PlayerImpl implements Player {

  private String userName;
  private Position location;
  private Inventory backpack;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException();
    } else {
      Position startPoint = new PositionImpl(startX, startY);
      this.userName = name;
      this.location = startPoint;
      this.backpack = new InventoryImpl();
    }
  }

  @Override
  public Position getPosition() {
    return this.location;
  }

  @Override
  public Inventory getInventory() {
    return this.backpack;
  }

  @Override
  public String getName() {
    return this.userName;
  }

  @Override
  public void move(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException();
    }
    this.location = this.getPosition().getNeighbor(direction);
  }
}
