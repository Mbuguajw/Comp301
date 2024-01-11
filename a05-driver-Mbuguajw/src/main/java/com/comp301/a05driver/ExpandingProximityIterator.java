package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExpandingProximityIterator implements Iterator<Driver> {

  private Iterator<Driver> driverCounter;
  private final Position clientLocale;
  private Driver nextDriver;
  private final int incrementDiameter;
  private Iterable<Driver> pool;
  private boolean check;
  private int counter;

  public ExpandingProximityIterator(Iterable<Driver> driverPool, Position clientPosition,
      int expansionStep) {
    if (driverPool == null || clientPosition == null || expansionStep <= 0) {
      throw new IllegalArgumentException();
    }
    driverCounter = driverPool.iterator();
    clientLocale = clientPosition;
    nextDriver = null;
    incrementDiameter = expansionStep;
    pool = driverPool;
    check = false;
    counter = 0;
  }

  @Override
  public boolean hasNext() {
    nextDriverUpdate();
    return this.driverCounter.next() != null;
  }

  @Override
  public Driver next() {
    if (this.hasNext()) {
      Driver hold = this.nextDriver;
      this.nextDriver = null;
      return hold;
    } else {
      throw new NoSuchElementException();
    }
  }

  private void nextDriverUpdate() {
    while (this.nextDriver == null) {
      while (this.nextDriver == null && this.driverCounter.hasNext()) {
        this.ringReturn(counter);
      }
      if (this.nextDriver != null) {
        return;
      }
      if (!this.driverCounter.hasNext() && !check) {
        return;
      }
      else {
        this.driverCounter = this.pool.iterator();
        counter++;
        check = false;
      }
    }
  }

  private void ringReturn(int ring) {
    Driver chauffeur = this.driverCounter.next();
    double distance = chauffeur.getVehicle().getPosition()
        .getManhattanDistanceTo(this.clientLocale);
    double previousStep = 1 + (ring - 1) * this.incrementDiameter;
    double nextStep = 1 + ring * this.incrementDiameter;
    if ((ring == 0) && (distance <= nextStep && 0 < distance)) {
      this.nextDriver = chauffeur;
    } else if (distance <= nextStep && previousStep < distance) {
      this.nextDriver = chauffeur;
    } else if (distance > nextStep) {
      check = true;
    }
  }
}
