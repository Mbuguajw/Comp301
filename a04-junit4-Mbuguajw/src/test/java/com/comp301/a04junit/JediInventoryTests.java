package com.comp301.a04junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;
import com.comp301.a04junit.adventure.Inventory;
import com.comp301.a04junit.adventure.InventoryImpl;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/** Write unit tests for the InventoryImpl class here */
public class JediInventoryTests {
  @Test
  public void inventConstructorTest() {
    InventoryImpl backpack = new InventoryImpl();
    assertTrue(backpack.isEmpty());
    assertEquals(backpack.getNumItems(), new InventoryImpl().getNumItems());
  }

  @Test
  public void getItemsTest() {
    InventoryImpl backpack = new InventoryImpl();
    ArrayList list = new ArrayList();
    ItemImpl one = new ItemImpl("pen");
    ItemImpl two = new ItemImpl("marker");
    ItemImpl three = new ItemImpl("pencil");
    ItemImpl four = new ItemImpl("crayon");
    backpack.addItem(one);
    backpack.addItem(two);
    backpack.addItem(three);
    backpack.addItem(four);
    list.add(one);
    list.add(two);
    list.add(three);
    list.add(four);
    assertEquals(backpack.getItems(), list);
  }

  @Test
  public void getNumItemsTest() {
    InventoryImpl backpack = new InventoryImpl();
    ItemImpl one = new ItemImpl("pen");
    ItemImpl two = new ItemImpl("marker");
    ItemImpl three = new ItemImpl("pencil");
    ItemImpl four = new ItemImpl("crayon");
    backpack.addItem(one);
    backpack.addItem(two);
    backpack.addItem(three);
    backpack.addItem(four);
    assertEquals(4, backpack.getNumItems());
  }

  @Test
  public void addItemsTest() {
    InventoryImpl backpack = new InventoryImpl();
    ItemImpl one = new ItemImpl("pen");
    ItemImpl two = new ItemImpl("marker");
    ItemImpl three = new ItemImpl("pencil");
    ItemImpl four = new ItemImpl("crayon");
    backpack.addItem(one);
    backpack.addItem(two);
    backpack.addItem(three);
    backpack.addItem(four);
    assertEquals(4, backpack.getNumItems());
    assertFalse(backpack.isEmpty());
  }

  @Test
  public void removeItemTest() {
    InventoryImpl backpack = new InventoryImpl();
    ItemImpl one = new ItemImpl("pen");
    ItemImpl two = new ItemImpl("marker");
    ItemImpl three = new ItemImpl("pencil");
    ItemImpl four = new ItemImpl("crayon");
    backpack.addItem(one);
    backpack.addItem(two);
    backpack.addItem(three);
    backpack.addItem(four);
    backpack.removeItem(one);
    assertEquals(3, backpack.getNumItems());
    assertFalse(backpack.isEmpty());
  }

  @Test
  public void clearTest() {
    InventoryImpl backpack = new InventoryImpl();
    ItemImpl one = new ItemImpl("pen");
    ItemImpl two = new ItemImpl("marker");
    ItemImpl three = new ItemImpl("pencil");
    ItemImpl four = new ItemImpl("crayon");
    backpack.addItem(one);
    backpack.addItem(two);
    backpack.addItem(three);
    backpack.addItem(four);
    Inventory empty = new InventoryImpl();
    backpack.clear();
    assertEquals(backpack.getNumItems(), empty.getNumItems());
  }

  @Test
  public void transferFromTest() {
    InventoryImpl backpack = new InventoryImpl();
    InventoryImpl purse = new InventoryImpl();
    ItemImpl one = new ItemImpl("pen");
    ItemImpl two = new ItemImpl("marker");
    ItemImpl three = new ItemImpl("pencil");
    ItemImpl four = new ItemImpl("crayon");
    backpack.addItem(one);
    backpack.addItem(two);
    purse.addItem(three);
    purse.addItem(four);
    backpack.transferFrom(purse);
    assertTrue(purse.isEmpty());
    assertEquals(4, backpack.getNumItems());
    backpack.transferFrom(null);
    assertEquals(4, backpack.getNumItems());
  }
}
