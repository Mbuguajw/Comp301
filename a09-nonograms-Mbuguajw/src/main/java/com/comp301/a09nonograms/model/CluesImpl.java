package com.comp301.a09nonograms.model;

public class CluesImpl implements Clues {

  private final int[][] row;
  private final int[][] col;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    // Constructor code here
    if (rowClues == null || colClues == null) {
      throw new IllegalArgumentException();
    }
    row = rowClues;
    col = colClues;
  }

  @Override
  public int getWidth() {
    return col.length;
  }

  @Override
  public int getHeight() {
    return row.length;
  }

  @Override
  public int[] getRowClues(int index) {
    return row[index];
  }

  @Override
  public int[] getColClues(int index) {
    return col[index];
  }

  @Override
  public int getRowCluesLength() {
    return row[0].length;
  }

  @Override
  public int getColCluesLength() {
    return col[0].length;
  }
}
