package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProximityIterator implements Iterator<Driver> {

  private Iterator<Driver> driverCounter;
  private Driver nextDriver;
  private final Iterable<Driver> pool;
  private final Position clientLocal;
  private final int proxRange;

  public ProximityIterator(Iterable<Driver> driverPool, Position clientPosition,
      int proximityRange) {
    if (driverPool == null || clientPosition == null || proximityRange < 0) {
      throw new IllegalArgumentException();
    }
    driverCounter = driverPool.iterator();
    nextDriver = null;
    pool = driverPool;
    clientLocal = clientPosition;
    proxRange = proximityRange;
  }

  @Override
  public boolean hasNext() {
    nextDriverUpdate();
    return (this.nextDriver) != null;
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
    if(this.nextDriver == null) {
      boolean check = true;
      while (check && this.driverCounter.hasNext()) {
        Driver chauffeur = this.driverCounter.next();
        if (chauffeur.getVehicle().getPosition().getManhattanDistanceTo(this.clientLocal)
            <= this.proxRange) {
          this.nextDriver = chauffeur;
          check = false;
        }
      }
    }
  }
}
