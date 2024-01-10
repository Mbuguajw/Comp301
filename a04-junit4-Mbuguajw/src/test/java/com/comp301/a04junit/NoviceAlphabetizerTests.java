package com.comp301.a04junit;

import com.comp301.a04junit.alphabetizer.Alphabetizer;


import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
/** Write tests for the Alphabetizer class here */
public class NoviceAlphabetizerTests {
  @Test
  public void alphaConstructorTest() {
    String[] alpha = new String[4];
    alpha[3] = "A";
    alpha[2] = "Z";
    alpha[0] = "c";
    alpha[1] = "d";
    Alphabetizer abc = new Alphabetizer(alpha);
    assertTrue(abc.hasNext());
    assertEquals("A", abc.next());
    assertTrue(abc.hasNext());
    assertEquals("Z", abc.next());
    assertTrue(abc.hasNext());
    assertEquals("c", abc.next());
    assertTrue(abc.hasNext());
    assertEquals("d", abc.next());
    assertFalse(abc.hasNext());
  }

  @Test
  public void nextTest() {
    String[] alpha = new String[4];
    alpha[3] = "a";
    alpha[2] = "b";
    alpha[0] = "c";
    alpha[1] = "d";
    Alphabetizer abc = new Alphabetizer(alpha);
    assertEquals("a", abc.next());
    assertEquals("b", abc.next());
    assertEquals("c", abc.next());
    assertEquals("d", abc.next());
    try {
      abc.next();
      fail();
    }
    catch (NoSuchElementException e) {
      return;
    }
    fail();
  }

  @Test
  public void hasNextTest() {
    String[] alpha = new String[4];
    alpha[3] = "a";
    alpha[2] = "b";
    alpha[0] = "c";
    alpha[1] = "d";
    Alphabetizer abc = new Alphabetizer(alpha);
    assertEquals(4, alpha.length);
    assertEquals("c", alpha[0]);
    assertEquals("d", alpha[1]);
    assertEquals("b", alpha[2]);
    assertEquals("a", alpha[3]);
    assertEquals("a", abc.next());
    assertEquals("b", abc.next());
    assertEquals("c", abc.next());
    assertEquals("d", abc.next());
  }

  @Test
  public void nullCheckedTest() {
    try{
      Alphabetizer empty = new Alphabetizer(null);
      return;
    }
    catch (RuntimeException e) {
      fail();
    }
  }
}
