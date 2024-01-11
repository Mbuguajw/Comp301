package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PuzzleControls implements FXComponent {

  private Controller gameData;

  public PuzzleControls(Controller cache) {
    gameData = cache;
  }

  @Override
  public Parent render() {
    Button pre = new Button("Previous Puzzle");
    Button next = new Button("Next Puzzle");
    Button rand = new Button("Random Puzzle");
    Button clear = new Button("Clear Puzzle");
    Font spice = Font.font("Courier New", FontWeight.BOLD, 12);
    pre.setFont(spice);
    next.setFont(spice);
    rand.setFont(spice);
    clear.setFont(spice);
    pre.setStyle("-fx-background-color: #00ff00");
    next.setStyle("-fx-background-color: #ff0000");
    rand.setStyle("-fx-background-color: #0000ff");
    clear.setStyle("-fx-background-color: #00bb00");
    pre.setOnAction(actionEvent -> gameData.prevPuzzle());
    next.setOnAction(actionEvent -> gameData.nextPuzzle());
    rand.setOnAction(actionEvent -> gameData.randPuzzle());
    clear.setOnAction(actionEvent -> gameData.clearBoard());
    return new HBox(pre, next, rand, clear);
  }
}
