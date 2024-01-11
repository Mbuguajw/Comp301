package com.comp301.a06image;

import java.awt.Color;

public class SolidColorImage implements Image {

  private int width_;
  private int height_;
  private Color shade_;

  public SolidColorImage(int width, int height, Color color) {
    // Constructor code goes here
    if (width < 0 || height < 0 || color == null) {
      throw new IllegalArgumentException();
    }
    width_ = width;
    height_ = height;
    shade_ = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException();
    }
    return shade_;
  }

  @Override
  public int getWidth() {
    return width_;
  }

  @Override
  public int getHeight() {
    return height_;
  }

  @Override
  public int getNumLayers() {
    return 1;
  }
}
