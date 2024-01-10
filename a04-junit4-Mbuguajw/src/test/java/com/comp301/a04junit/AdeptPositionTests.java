package com.comp301.a04junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Player;
import com.comp301.a04junit.adventure.PlayerImpl;
import com.comp301.a04junit.adventure.Position;
import com.comp301.a04junit.adventure.PositionImpl;

import org.junit.Test;

/** Write unit tests for the PositionImpl class here */
public class AdeptPositionTests {
  @Test
  public void positionConstructorTest() {
    Position origin = new PositionImpl(0, 0);
    assertTrue(origin.getX() == 0 && origin.getY() == 0);
  }

  @Test
  public void getXTest() {
    Position origin = new PositionImpl(0, 0);
    Position square = new PositionImpl(5, 2);
    Position away = new PositionImpl(-7, 4);
    assertTrue(origin.getX() == 0 && square.getX() == 5 && away.getX() == -7);
  }

  @Test
  public void getYTest() {
    Position origin = new PositionImpl(0, 0);
    Position square = new PositionImpl(5, 2);
    Position away = new PositionImpl(-7, 4);
    assertTrue(origin.getY() == 0 && square.getY() == 2 && away.getY() == 4);
  }

  @Test
  public void getNeighborTest() {
    Position origin = new PositionImpl(0, 0);
    Position state = new PositionImpl(0, 0);
    Position north = new PositionImpl(0, 1);
    Position south = new PositionImpl(0, -1);
    Position east = new PositionImpl(1, 0);
    Position west = new PositionImpl(-1, 0);
    assertEquals(origin.getNeighbor(Direction.NORTH).getX(), north.getX());
    assertEquals(origin.getNeighbor(Direction.NORTH).getY(), north.getY());
    assertEquals(origin.getX(), state.getX());
    assertEquals(origin.getY(), state.getY());
    assertEquals(origin.getNeighbor(Direction.SOUTH).getX(), south.getX());
    assertEquals(origin.getNeighbor(Direction.SOUTH).getY(), south.getY());
    assertEquals(origin.getX(), state.getX());
    assertEquals(origin.getY(), state.getY());
    assertEquals(origin.getNeighbor(Direction.WEST).getX(), west.getX());
    assertEquals(origin.getNeighbor(Direction.WEST).getY(), west.getY());
    assertEquals(origin.getX(), state.getX());
    assertEquals(origin.getY(), state.getY());
    assertEquals(origin.getNeighbor(Direction.EAST).getX(), east.getX());
    assertEquals(origin.getNeighbor(Direction.EAST).getY(), east.getY());
    assertEquals(origin.getX(), state.getX());
    assertEquals(origin.getY(), state.getY());
  }

  @Test
  public void getNeighborVarietyTest() {
    Position username = new PositionImpl( 100, 100);
    Position player1 = new PositionImpl( -2, 9);
    Position player2 = new PositionImpl( -57, -4);
    Position player3 = new PositionImpl( -39, 13);

    assertEquals(100, username.getNeighbor(Direction.NORTH).getX());
    assertEquals(101, username.getNeighbor(Direction.NORTH).getY());
    assertEquals(-1, player1.getNeighbor(Direction.EAST).getX());
    assertEquals(9, player1.getNeighbor(Direction.EAST).getY());
    assertEquals(-57, player2.getNeighbor(Direction.SOUTH).getX());
    assertEquals(-5, player2.getNeighbor(Direction.SOUTH).getY());
    assertEquals(-40, player3.getNeighbor(Direction.WEST).getX());
    assertEquals(13, player3.getNeighbor(Direction.WEST).getY());
    assertEquals(100, username.getX());
    assertEquals(100, username.getY());

  }
}
