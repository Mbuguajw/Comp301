package com.comp301.a09nonograms.model;

public class BoardImpl implements Board {

  private final Clues hint;
  private int[][] space;

  public BoardImpl(Clues clue) {
    if (clue == null) {
      throw new IllegalArgumentException();
    }
    hint = clue;
    space = new int[hint.getHeight()][hint.getWidth()];
    clear();
  }

  @Override
  public boolean isShaded(int row, int col) {
    if (row > hint.getHeight() || col > hint.getWidth() || row < 0 || col < 0) {
      throw new RuntimeException();
    }
    return space[row][col] == 1;
  }

  @Override
  public boolean isEliminated(int row, int col) {
    if (row > hint.getHeight() || col > hint.getWidth() || row < 0 || col < 0) {
      throw new RuntimeException();
    }
    return space[row][col] == 2;
  }

  @Override
  public boolean isSpace(int row, int col) {
    if (row > hint.getHeight() || col > hint.getWidth() || row < 0 || col < 0) {
      throw new RuntimeException();
    }
    return space[row][col] == 0;
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (row > hint.getHeight() || col > hint.getWidth() || row < 0 || col < 0) {
      throw new RuntimeException();
    }
    if (isShaded(row, col)) {
      space[row][col] = 0;
    } else {
      space[row][col] = 1;
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (row > hint.getHeight() || col > hint.getWidth() || row < 0 || col < 0) {
      throw new RuntimeException();
    }
    if (isEliminated(row, col)) {
      space[row][col] = 0;
    } else {
      space[row][col] = 2;
    }
  }

  @Override
  public void clear() {
    for (int[] row : space) {
      for (int i = 0; i < row.length; i++) {
        row[i] = 0;
      }
    }
  }
}
