package com.comp301.a08shopping.events;

import com.comp301.a08shopping.Product;
import com.comp301.a08shopping.Store;

public interface StoreEvent {

  Product getProduct();

  Store getStore();
}
