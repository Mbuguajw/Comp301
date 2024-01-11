package com.comp301.a06image;

import java.awt.Color;

public class BorderDecorator implements Image {

  private final Image picture;
  private final int thick;
  private final Color outline;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    // Constructor code goes here
    if (thiccness < 0 || image == null) {
      throw new IllegalArgumentException();
    }
    picture = image;
    thick = thiccness;
    outline = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException();
    }
    if ((x >= thick) && (x < getWidth() - thick) && (y >= thick) && (y < getHeight() - thick)) {
      return picture.getPixelColor(x - thick, y - thick);
    } else {
      return outline;
    }
  }

  @Override
  public int getWidth() {
    return picture.getWidth() + (2 * thick);
  }

  @Override
  public int getHeight() {
    return picture.getHeight() + (2 * thick);
  }

  @Override
  public int getNumLayers() {
    return picture.getNumLayers() + 1;
  }
}
