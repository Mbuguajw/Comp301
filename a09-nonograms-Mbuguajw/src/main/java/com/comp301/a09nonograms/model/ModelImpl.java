package com.comp301.a09nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  private final List<Clues> boardTabs;
  private int active;
  private Board inAction;
  private ArrayList<ModelObserver> observerList;
  private List<Board> savedGames;

  public ModelImpl(List<Clues> clues) {
    // Constructor code here
    boardTabs = clues;
    active = -1;
    observerList = new ArrayList<>();
    inAction = null;
    savedGames = new ArrayList<>();
    setPuzzleIndex(0);
  }

  @Override
  public ArrayList<ModelObserver> getObservers() {
    return observerList;
  }

  @Override
  public Clues getClues() {
    return boardTabs.get(active);
  }

  @Override
  public int getPuzzleCount() {
    return boardTabs.size();
  }

  @Override
  public int getPuzzleIndex() {
    return active;
  }

  @Override
  public void setPuzzleIndex(int index) {
    if (active != -1) {
      savedGames.add(inAction);
    }
    active = index;
    Clues picked = boardTabs.get(index);
    inAction = new BoardImpl(picked);
    signal();
  }

  private void signal() {
    for (ModelObserver alert : observerList) {
      alert.update(this);
    }
  }

  @Override
  public void addObserver(ModelObserver observer) {
    observerList.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observerList.remove(observer);
  }

  private int counted(int[] rowCol) {
    int blackCount = 0;
    for (int num : rowCol) {
      blackCount += num;
    }
    return blackCount;
  }

  @Override
  public boolean isSolved() {
    for (int i = 0; i < getHeight(); i++) {
      int shaded = 0;
      for (int j = 0; j < getWidth(); j++) {
        if (isShaded(i, j)) {
          shaded++;
        }
      }
      if (shaded != counted(getRowClues(i))) {
        return false;
      }
    }
    for (int i = 0; i < getWidth(); i++) {
      int black = 0;
      for (int j = 0; j < getHeight(); j++) {
        if (isShaded(j, i)) {
          black++;
        }
      }
      if (black != counted(getColClues(i))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isShaded(int row, int col) {
    return inAction.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return inAction.isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return inAction.isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    inAction.toggleCellShaded(row, col);
    signal();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    inAction.toggleCellEliminated(row, col);
    signal();
  }

  @Override
  public void clear() {
    inAction.clear();
    signal();
  }

  @Override
  public int getWidth() {
    return boardTabs.get(active).getWidth();
  }

  @Override
  public int getHeight() {
    return boardTabs.get(active).getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return boardTabs.get(active).getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return boardTabs.get(active).getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return boardTabs.get(active).getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return boardTabs.get(active).getColCluesLength();
  }
}
