package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {

  private Player cpu;
  private Map server;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException();
    } else {
      this.cpu = player;
      this.server = map;
    }
  }

  @Override
  public Position getPlayerPosition() {
    return this.cpu.getPosition();
  }

  @Override
  public String getPlayerName() {
    return this.cpu.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return this.cpu.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    boolean isWinner = true;
    for (int i = 0; i < this.server.getWidth(); i++) {
      for (int j = 0; j < this.server.getHeight(); j++) {
        if (this.server.getCell(i, j) != null) {
          if (this.server.getCell(i, j).hasChest()) {
            if (!this.server.getCell(i, j).getChest().isEmpty()) {
              isWinner = false;
              break;
            }
          }
        }
      }
    }
    return isWinner;
  }

  @Override
  public void printCellInfo() {
    Position cellLocation = this.cpu.getPosition();
    Cell locationStats = this.server.getCell(cellLocation);
    System.out.println(
        "Location: " + locationStats.getName() + "\n" + locationStats.getDescription());
    if (locationStats.getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (locationStats.hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    this.server.getCell(cellLocation).visit();
  }

  @Override
  public void openChest() {
    Position playerLocation = this.cpu.getPosition();
    if (this.server.getCell(playerLocation).hasChest()) {
      if (!this.server.getCell(playerLocation).getChest().isEmpty()) {
        List<Item> inventList = this.server.getCell(playerLocation).getChest().getItems();
        this.server.getCell(playerLocation).getChest().clear();
        for (int i = 0; i < inventList.size(); i++) {
          this.cpu.getInventory().addItem(inventList.get(i));
        }
        System.out.println("You collected these items: " + inventList.toString());
      } else {
        System.out.println("The chest is empty.");
      }
    } else {
      System.out.println("No chest to open, sorry!");
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    if (this.server.getWidth() <= cpu.getPosition().getX()
        || cpu.getPosition().getX() < 0
        || this.server.getHeight() <= cpu.getPosition().getY()
        || cpu.getPosition().getY() < 0) {
      return false;
    }
    boolean canMove = false;
    Player original = new PlayerImpl("name", cpu.getPosition().getX(), cpu.getPosition().getY());
    original.move(direction);
    int newX = original.getPosition().getX();
    int newY = original.getPosition().getY();
    if (this.server.getWidth() > newX && newX >= 0) {
      if (this.server.getHeight() > newY && newY >= 0) {
        if (this.server.getCell(original.getPosition()) != null) {
          canMove = true;
        }
      }
    }
    return canMove;
  }

  @Override
  public void move(Direction direction) {
    if (this.canMove(direction)) {
      this.cpu.move(direction);
      printCellInfo();
    } else {
      System.out.println("You can't go that way! Try another direction.");
    }
  }
}
