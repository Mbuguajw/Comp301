package com.comp301.a06image;

import java.awt.Color;

public class ZoomDecorator implements Image {

  private final Image picture;
  private final int eXpander;

  public ZoomDecorator(Image image, int multiplier) {
    // Constructor code goes here
    if (multiplier <= 0 || image == null) {
      throw new IllegalArgumentException();
    }
    picture = image;
    eXpander = multiplier;
  }

  public ZoomDecorator(Image image) {
    // Constructor code goes here
    this(image, 2);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    int finalX = (int) Math.floor(x / eXpander);
    int finalY = (int) Math.floor(y / eXpander);
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException();
    } else {
      return picture.getPixelColor(finalX, finalY);
    }
  }

  @Override
  public int getWidth() {
    return picture.getWidth() * eXpander;
  }

  @Override
  public int getHeight() {
    return picture.getHeight() * eXpander;
  }

  @Override
  public int getNumLayers() {
    return picture.getNumLayers() + 1;
  }
}
