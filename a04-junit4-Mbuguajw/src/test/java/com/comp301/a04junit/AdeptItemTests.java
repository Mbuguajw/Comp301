package com.comp301.a04junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;

import org.junit.Test;

/** Write unit tests for the ItemImpl class here */
public class  AdeptItemTests {
  @Test
  public void itemConstructorTest() {
    Item tool = new ItemImpl("PEN");
    Item utensil = new ItemImpl("pencil");
    assertEquals("PEN",tool.getName());
    assertEquals("pencil", utensil.getName());
    try{
      Item thingy = new ItemImpl(null);
      fail();
    }
    catch (RuntimeException e) {
      return;
    }
  }

  @Test
  public void getNameTest() {
    Item tool = new ItemImpl("Pen");
    Item utensil = new ItemImpl("Pencil");
    assertTrue(tool.getName().equals("Pen") && utensil.getName().equals("Pencil"));
  }

  @Test
  public void equalsTest() {
    Item tool = new ItemImpl("PEN");
    Item utensil = new ItemImpl("PEN");
    assertEquals(tool, utensil);
  }
  @Test
  public void equals2Test() {
    Item fruit = new ItemImpl("tomato");
    Item vegetable = new ItemImpl("tomato");
    assertEquals(fruit, vegetable);
  }

  @Test
  public void toStringTest() {
    Item tool = new ItemImpl("pen");
    Item utensil = new ItemImpl("PEN");
    assertEquals("pen", tool.toString());
    assertEquals("PEN", utensil.toString());
  }
}
