package com.comp301.a08shopping.events;

import com.comp301.a08shopping.Product;
import com.comp301.a08shopping.Store;

public class OutOfStockEvent implements StoreEvent {

  private final Product shoppingItem;
  private final Store department;

  public OutOfStockEvent(Product product, Store store) {
    if (product == null || store == null) {
      throw new IllegalArgumentException();
    }
    shoppingItem = product;
    department = store;
  }

  @Override
  public Product getProduct() {
    return shoppingItem;
  }

  @Override
  public Store getStore() {
    return department;
  }
}
