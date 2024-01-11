package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PuzzleGrid implements FXComponent {

  private Controller gameData;

  public PuzzleGrid(Controller cache) {
    gameData = cache;
  }

  @Override
  public Parent render() {
    BorderPane background = new BorderPane();
    GridPane nonogram = new GridPane();
    background.setCenter(nonogram);
    nonogram.setMouseTransparent(true);
    // set grid to the center
    // Stage stool = new Stage();
    // stool.setScene(scene);
    nonogram.setPadding(new Insets(1));
    nonogram.setHgap(18);
    nonogram.setVgap(15);
    for (int i = 0; i < gameData.getClues().getHeight(); i++) {
      for (int j = 0; j < gameData.getClues().getWidth(); j++) {
        if (i == 0 && j == 0) {
          boolean sir = false;
        } else if (i == 0) {
          StringBuilder convert = new StringBuilder();
          for (int clue : gameData.getClues().getRowClues(j)) {
            if (clue != 0) {
              convert.append(clue).append(" ");
            }
          }
          Button col = new Button(convert.toString());
          col.setMinHeight(5);
          col.setMinWidth(5);
          col.setStyle("-fx-background-color: #aa00aa");
          nonogram.add(col, 0, j, 1, 1);
        } else if (j == 0) {
          StringBuilder convert = new StringBuilder();
          for (int clue : gameData.getClues().getRowClues(i)) {
            if (clue != 0) {
              convert.append(clue).append("\n");
            }
          }
          Button col = new Button(convert.toString());
          col.setMinHeight(5);
          col.setMinWidth(5);
          col.setStyle("-fx-background-color: #aa00aa");
          nonogram.add(col, i, 0, 1, 1);
        } else {
          Button toggleMe = new Button();
          toggleMe.setMinHeight(5);
          toggleMe.setMinWidth(5);

          int finalI = i;
          int finalJ = j;
          toggleMe.setOnMouseClicked(
              event -> {
                MouseButton button = event.getButton();
                if (button == MouseButton.PRIMARY) {
                  gameData.toggleShaded(finalI, finalJ);
                } else if (button == MouseButton.SECONDARY) {
                  gameData.toggleEliminated(finalI, finalJ);
                }
              });
          if (gameData.isShaded(finalI, finalJ)) {
            toggleMe.setStyle("-fx-background-color: #000000");
            toggleMe.setStyle("\u1F7E9");
          }
          if (gameData.isEliminated(finalI, finalJ)) {
            toggleMe.setText("\u274C");
          }
          nonogram.add(toggleMe, i, j, 1, 1);
        }
      }
    }
    String instructions =
        "How to Play"
            + "\n"
            + "1. Left click to shade a square"
            + "\n"
            + "2. Right click to eliminate a square"
            + "How to Play"
            + "\n"
            + "1. Left click to shade a square"
            + "\n"
            + "3. If you want to try other puzzles, hit a button below :)";
    Pane space = new Pane(new Label(instructions));
    space.setMouseTransparent(true);
    nonogram.setMouseTransparent(true);
    background.setMouseTransparent(true);
    background.setBottom(space);

    return background;
  }
}
