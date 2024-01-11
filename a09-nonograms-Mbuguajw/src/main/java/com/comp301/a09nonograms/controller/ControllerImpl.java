package com.comp301.a09nonograms.controller;

import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.CluesImpl;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelObserver;

public class ControllerImpl implements Controller {

  private Model app;

  public ControllerImpl(Model model) {
    // Constructor code goes here
    app = model;
  }

  @Override
  public Clues getClues() {
    return app.getClues();
  }

  @Override
  public boolean isSolved() {
    return app.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return app.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return app.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    app.toggleCellEliminated(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    app.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    try {
      app.setPuzzleIndex(app.getPuzzleIndex() + 1);
    } catch (IndexOutOfBoundsException e) {
      app.setPuzzleIndex(0);
    }
  }

  @Override
  public void prevPuzzle() {
    try {
      app.setPuzzleIndex(app.getPuzzleIndex() - 1);
    } catch (IndexOutOfBoundsException e) {
      app.setPuzzleIndex(app.getPuzzleCount() - 1);
    }
  }

  @Override
  public void randPuzzle() {
    int min = 0;
    int max = app.getPuzzleCount() - 1;
    int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
    app.setPuzzleIndex(random);
  }

  @Override
  public void clearBoard() {
    app.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return app.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return app.getPuzzleCount();
  }

  @Override
  public void update(Model model) {
    for (ModelObserver item : model.getObservers()) {
      item.notify();
    }
  }
}
