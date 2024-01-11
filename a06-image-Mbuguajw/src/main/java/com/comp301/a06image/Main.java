package com.comp301.a06image;

import java.awt.Color;
import java.io.IOException;
import javafx.application.Application;

public class Main {

  /**
   * Creates and returns an image object for testing. The image that this method produces will be
   * automatically displayed on the screen when main() is run below. Use this method to test
   * different decorators.
   */
  public static Image makeImage() throws IOException {
    // TODO use this method for testing your decorators
    PictureImage kmp = new PictureImage("img/kmp.jpg");
    Color rojo = new Color(255, 0, 0);
    Color azul = new Color(0, 0, 255);
    Color amarillo = new Color(255, 255, 0);
    Color orange = new Color(200, 80, 10);
    BorderDecorator red = new BorderDecorator(kmp, 5, rojo);
    BorderDecorator blue = new BorderDecorator(red, 50, azul);
    CircleDecorator yellowC = new CircleDecorator(blue, 50, 50, 40, amarillo);
    SquareDecorator orangeC = new SquareDecorator(yellowC, 100, 100, 40, orange);
    ZoomDecorator zoomOut = new ZoomDecorator(orangeC);
    return zoomOut;
  }

  /**
   * Use this method for testing your code. When main() runs, the image you created and decorated in
   * the makeImage() method above will be generated and displayed on the screen. You don't need to
   * make any changes to this main() method.
   */
  public static void main(String[] args) throws IOException {
    Application.launch(ImageDisplay.class, args);
  }
}