package com.comp301.a06image;

import java.awt.Color;

public class CircleDecorator implements Image {

  private final Image picture;
  private final int originX;
  private final int originY;
  private final int radius_;
  private final Color shade;

  public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
    // Constructor code goes here
    if (radius < 0 || image == null) {
      throw new IllegalArgumentException();
    }
    picture = image;
    originX = cx;
    originY = cy;
    radius_ = radius;
    shade = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException();
    }
    double newX = Math.pow((originX - x), 2);
    double newY = Math.pow((originY - y), 2);
    double distance = Math.sqrt(newX + newY);
    if (distance < radius_) {
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
