package com.comp301.a08shopping;

import com.comp301.a08shopping.events.BackInStockEvent;
import com.comp301.a08shopping.events.OutOfStockEvent;
import com.comp301.a08shopping.events.PurchaseEvent;
import com.comp301.a08shopping.events.SaleEndEvent;
import com.comp301.a08shopping.events.SaleStartEvent;
import com.comp301.a08shopping.events.StoreEvent;
import com.comp301.a08shopping.exceptions.ProductNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Customer {

  private final String playerName;
  private double budgetTab;
  private final ArrayList<ReceiptItem> orderReceipts;

  public CustomerImpl(String name, double budget) {
    if (budget <= 0.0 || name == null) {
      throw new IllegalArgumentException();
    }
    playerName = name;
    budgetTab = budget;
    orderReceipts = new ArrayList<>();
  }

  @Override
  public String getName() {
    return playerName;
  }

  @Override
  public double getBudget() {
    return budgetTab;
  }

  @Override
  public void purchaseProduct(Product product, Store store) {
    if (store == null || product == null) {
      throw new IllegalArgumentException();
    }
    if (!store.getIsInStock(product)) {
      throw new ProductNotFoundException();
    }
    double storeResalePrice = store.getSalePrice(product);
    if (storeResalePrice > budgetTab) {
      throw new IllegalStateException();
    }
    budgetTab = budgetTab - storeResalePrice;
    ReceiptItem paperReceipt = store.purchaseProduct(product);
    orderReceipts.add(paperReceipt);
  }

  @Override
  public List<ReceiptItem> getPurchaseHistory() { return orderReceipts.clone(); }

  @Override
  public void update(StoreEvent event) {
    String item = event.getProduct().getName();
    String store = event.getStore().getName();
    if (event instanceof BackInStockEvent) {
      System.out.println(item + " is back in stock at " + store);
    } else if (event instanceof OutOfStockEvent) {
      System.out.println(item + " is now out of stock at " + store);
    } else if (event instanceof PurchaseEvent) {
      System.out.println("Someone purchased " + item + " at " + store);
    } else if (event instanceof SaleEndEvent) {
      System.out.println("The sale for " + item + " at " + store + " has ended");
    } else if (event instanceof SaleStartEvent) {
      System.out.println("New sale for " + item + " at " + store + "!");
    }
  }
}
