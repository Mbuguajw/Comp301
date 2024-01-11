package com.comp301.a08shopping;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    Store department = new StoreImpl("department");
    Customer me = new CustomerImpl("player", 10.00);
    department.createProduct("test item", 3.00, 4);
    department.addObserver(me);
    Product thing = department.getProducts().get(0);
    department.startSale(thing, 0.33);
    me.purchaseProduct(thing, department);
    System.out.println(me.getPurchaseHistory());
    assertTrue(department.getSalePrice(thing) == 2.00);
  }

  @Test
  public void answerWithTrue() {
    Store department = new StoreImpl("department");
    Customer me = new CustomerImpl("player", 10.00);
    department.createProduct("test item", 3.00, 4);
    department.addObserver(me);
    Product thing = department.getProducts().get(0);
    department.startSale(thing, 0.33);
    me.purchaseProduct(thing, department);
    assertTrue(department.getSalePrice(thing) == 2.00 );
    department.endSale(thing);
    me.purchaseProduct(thing, department);
    assertTrue(department.getSalePrice(thing) == thing.getBasePrice());
  }
}
