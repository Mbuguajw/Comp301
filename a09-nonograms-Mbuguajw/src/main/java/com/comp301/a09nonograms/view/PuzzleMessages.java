package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PuzzleMessages implements FXComponent {

  private Controller gameData;

  public PuzzleMessages(Controller cache) {
    gameData = cache;
  }

  @Override
  public Parent render() {
    Stage popWin = new Stage();
    popWin.setTitle("Congratulations!" + "\n" + "You Won!");
    StackPane bottomBox = new StackPane();
    Button button = new Button();
    button.setText("OK");

    button.setOnAction(actionEvent -> {});
    bottomBox.getChildren().add(button);
    Scene background = new Scene(bottomBox, 500, 500);
    popWin.setScene(background);
    popWin.show();
    return background.getRoot();
  }
}
