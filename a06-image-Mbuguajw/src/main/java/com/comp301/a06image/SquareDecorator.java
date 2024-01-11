package com.comp301.a06image;

import java.awt.Color;

public class SquareDecorator implements Image {

  private final Image picture;
  private final int x;
  private final int y;
  private final int length;
  private final Color shade;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    // Constructor code goes here
    if (image == null || squareSize < 0) {
      throw new IllegalArgumentException();
    }
    picture = image;
    x = squareX;
    y = squareY;
    length = squareSize;
    shade = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException();
    }
    if (x < this.x + length && x >= this.x && y < this.y + length && y >= this.y) {
      return shade;
    } else {
      return picture.getPixelColor(x, y);
    }
  }

  @Override
  public int getWidth() {
    return picture.getWidth();
  }

  @Override
  public int getHeight() {
    return picture.getHeight();
  }

  @Override
  public int getNumLayers() {
    return picture.getNumLayers() + 1;
  }
}
