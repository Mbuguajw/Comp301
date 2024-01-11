package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PuzzleStats implements FXComponent {
  private Controller gameData;

  public PuzzleStats(Controller cache) {
    gameData = cache;
  }

  @Override
  public Parent render() {
    VBox flat = new VBox();
    Label greet = new Label("NONOGRAMS!");
    Label collection =
        new Label("Puzzle " + (gameData.getPuzzleIndex() + 1) + "/" + gameData.getPuzzleCount());
    greet.setFont(new Font("Comic Sans", 50));
    collection.setFont(new Font("Comic Sans", 24));
    flat.getChildren().add(greet);
    flat.getChildren().add(collection);

    if (gameData.isSolved()) {
      Label winner = new Label("Winner, winner, chicken dinner!");
      winner.setFont(new Font("Comic Sans", 24));
      flat.getChildren().add(winner);
    }

    return flat;
  }
}
