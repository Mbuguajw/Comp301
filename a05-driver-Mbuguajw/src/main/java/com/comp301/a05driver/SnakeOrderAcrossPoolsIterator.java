package com.comp301.a05driver;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SnakeOrderAcrossPoolsIterator implements Iterator<Driver> {

  private List<Iterable<Driver>> driverList;
  private Driver nextDriver;
  private Iterator<Iterable<Driver>> driverCounter;

  public SnakeOrderAcrossPoolsIterator(List<Iterable<Driver>> driverPools) {
    this.driverList = driverPools;
    this.nextDriver = null;
    this.driverCounter = driverPools.iterator();
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
    if(this.nextDriver == null) {
      boolean check = true;
      while (check && this.driverCounter.hasNext()) {
        Driver chauffeur = (Driver) this.driverCounter.next();
        if (chauffeur.getVehicle().getPosition().getManhattanDistanceTo(chauffeur.getVehicle()
            .getPosition())
            <= 3) {
          this.nextDriver = chauffeur;
          check = false;
        }
      }
    }
  }
}
