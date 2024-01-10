package com.comp301.a04junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Inventory;
import com.comp301.a04junit.adventure.InventoryImpl;
import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;
import com.comp301.a04junit.adventure.Player;
import com.comp301.a04junit.adventure.PlayerImpl;

import com.comp301.a04junit.adventure.Position;
import com.comp301.a04junit.adventure.PositionImpl;
import org.junit.Test;

/** Write unit tests for the PlayerImpl class here */
public class JediPlayerTests {
  @Test
  public void playerConstructorTest() {
    Player username = new PlayerImpl("gamer tag", 0, 5);
    assertEquals("gamer tag", username.getName());
    Position confirmation = new PositionImpl(0, 5);
    assertEquals(username.getPosition().getX(), confirmation.getX());
    assertEquals(username.getPosition().getY(), confirmation.getY());
    assertEquals(username.getInventory().getNumItems(), new InventoryImpl().getNumItems());
    try {
      Player cpu = new PlayerImpl(null, 1, 2);
      fail();
    }
    catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }

  @Test
  public void getPositionTest() {
    Player username = new PlayerImpl("gamer tag", 0, 5);
    Position place = new PositionImpl(0, 5 );
    assertEquals(username.getPosition().getX(), place.getX());
    assertEquals(username.getPosition().getY(), place.getY());
  }

  @Test
  public void getInventoryTest() {
    Player username = new PlayerImpl("gamer tag", 0, 5);
    Inventory purse = new InventoryImpl();

    assertEquals(username.getInventory().getNumItems(), purse.getNumItems());
    Inventory backpack = new InventoryImpl();
    ItemImpl one = new ItemImpl("pen");
    ItemImpl two = new ItemImpl("marker");
    ItemImpl three = new ItemImpl("pencil");
    ItemImpl four = new ItemImpl("crayon");
    backpack.addItem(one);
    backpack.addItem(two);
    backpack.addItem(three);
    backpack.addItem(four);
    username.getInventory().addItem(one);
    username.getInventory().addItem(two);
    username.getInventory().addItem(three);
    username.getInventory().addItem(four);

    assertEquals(username.getInventory().getNumItems(), backpack.getNumItems());
  }

  @Test
  public void getNameTest() {
    Player username = new PlayerImpl("gamer tag", 0, 5);
    assertEquals("gamer tag", username.getName());
  }

  @Test
  public void moveTest() {
    Player username = new PlayerImpl("gamer tag", 0, 0);
    Player player1 = new PlayerImpl("cpu", -2, 3);
    Player player2 = new PlayerImpl("cpu", -7, -4);
    Player player3 = new PlayerImpl("cpu", -3, 3);
    Position north = new PositionImpl(0, 1);
    Position east = new PositionImpl(-1, 3);
    Position south = new PositionImpl(-7, -5);
    Position west = new PositionImpl(-4, 3);

    username.move(Direction.NORTH);
    assertEquals(username.getPosition().getX(), north.getX());
    assertEquals(username.getPosition().getY(), north.getY());

    player1.move(Direction.EAST);
    assertEquals(player1.getPosition().getX(), east.getX());
    assertEquals(player1.getPosition().getY(), east.getY());

    player2.move(Direction.SOUTH);
    assertEquals(player2.getPosition().getX(), south.getX());
    assertEquals(player2.getPosition().getY(), south.getY());

    player3.move(Direction.WEST);
    assertEquals(player3.getPosition().getX(), west.getX());
    assertEquals(player3.getPosition().getY(), west.getY());
  }
}
