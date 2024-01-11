package com.comp301.a06image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PictureImage implements Image {

  private final BufferedImage backImage;

  public PictureImage(String pathname) throws IOException {
    // Constructor code goes here
    File imageAddress = new File(pathname);
    backImage = ImageIO.read(imageAddress);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException();
    }
    int pixelColor = backImage.getRGB(x, y);
    Color hue = new Color(pixelColor, true);
    int rojo = hue.getRed();
    int verde = hue.getGreen();
    int azul = hue.getBlue();
    return new Color(rojo, verde, azul);
  }

  @Override
  public int getWidth() {
    return backImage.getWidth();
  }

  @Override
  public int getHeight() {
    return backImage.getHeight();
  }

  @Override
  public int getNumLayers() {
    return 1;
  }
}
