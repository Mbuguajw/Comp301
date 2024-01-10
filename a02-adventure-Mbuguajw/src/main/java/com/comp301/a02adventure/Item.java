package com.comp301.a02adventure;

public interface Item {

  String getName();

  @Override
  boolean equals(Object other);

  @Override
  String toString();
}
