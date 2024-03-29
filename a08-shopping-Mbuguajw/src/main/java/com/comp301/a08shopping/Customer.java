package com.comp301.a08shopping;

import java.util.List;

public interface Customer extends StoreObserver {

  String getName();

  double getBudget();

  /**
   * Purchases a particular product from a store by performing the following actions, in order:
   *
   * <p>1. If the sale price of the product costs more money then the customer has, throw an
   * IllegalStateException exception
   *
   * <p>2. Decrease the customer's money by the sale price of the product
   *
   * <p>3. Purchase the object from the store by calling store.purchaseProduct()
   *
   * <p>4. Add the returned ReceiptItem from the store to the customer's purchase history
   */
  void purchaseProduct(Product product, Store store);

  List<ReceiptItem> getPurchaseHistory();
}
