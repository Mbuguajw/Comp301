package com.comp301.a08shopping;

import com.comp301.a08shopping.events.BackInStockEvent;
import com.comp301.a08shopping.events.OutOfStockEvent;
import com.comp301.a08shopping.events.PurchaseEvent;
import com.comp301.a08shopping.events.SaleEndEvent;
import com.comp301.a08shopping.events.SaleStartEvent;
import com.comp301.a08shopping.events.StoreEvent;
import com.comp301.a08shopping.exceptions.OutOfStockException;
import com.comp301.a08shopping.exceptions.ProductNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StoreImpl implements Store {

  private final String departmentName;
  private ArrayList<StoreObserver> activeObservers;
  private ArrayList<Product> productWatchList;
  private ArrayList<Integer> inventoryLeft;
  private ArrayList<Double> discountSale;

  public StoreImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    departmentName = name;
    activeObservers = new ArrayList<>();
    productWatchList = new ArrayList<>();
    inventoryLeft = new ArrayList<>();
    discountSale = new ArrayList<>();
  }

  private void notify(StoreEvent event) {
    for (StoreObserver observer : activeObservers) {
      observer.update(event);
    }
  }

  @Override
  public String getName() {
    return departmentName;
  }

  @Override
  public void addObserver(StoreObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    }
    activeObservers.add(observer);
  }

  @Override
  public void removeObserver(StoreObserver observer) {
    activeObservers.remove(observer);
  }

  @Override
  public List<Product> getProducts() {
    return (List<Product>) productWatchList.clone();
  }

  @Override
  public Product createProduct(String name, double basePrice, int inventory) {
    if (name == null || basePrice <= 0.00 || inventory < 0) {
      throw new IllegalArgumentException();
    }
    Product newProduct = new ProductImpl(name, basePrice);
    inventoryLeft.add(inventory);
    productWatchList.add(newProduct);
    discountSale.add(1.0);
    return newProduct;
  }

  @Override
  public ReceiptItem purchaseProduct(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    int idx = productWatchList.indexOf(product);
    if (idx == -1) {
      throw new ProductNotFoundException();
    }
    if (!getIsInStock(product)) {
      throw new OutOfStockException();
    } else {
      int updateStock = inventoryLeft.get(idx) - 1;
      inventoryLeft.set(idx, updateStock);
      if (!getIsInStock(product)) {
        StoreEvent outOfStock = new OutOfStockEvent(product, this);
        notify(outOfStock);
      }
      notify(new PurchaseEvent(product, this));
      inventoryLeft.set(idx, updateStock);
      return new ReceiptItemImpl(product.getName(), getSalePrice(product), departmentName);
    }
  }

  @Override
  public void restockProduct(Product product, int numItems) {
    if (product == null || numItems < 0) {
      throw new IllegalArgumentException();
    }
    int idx = productWatchList.indexOf(product);
    if (idx == -1) {
      throw new ProductNotFoundException();
    }
    if (inventoryLeft.get(idx) == 0) {
      StoreEvent backInStock = new BackInStockEvent(product, this);
      notify(backInStock);
    }
    inventoryLeft.set(idx, getProductInventory(product) + numItems);
  }

  @Override
  public void startSale(Product product, double percentOff) {
    if (product == null || percentOff < 0.0 || percentOff > 1.0) {
      throw new IllegalArgumentException();
    }
    int idx = productWatchList.indexOf(product);
    if (idx == -1) {
      throw new ProductNotFoundException();
    }
    notify(new SaleStartEvent(product, this));
    discountSale.set(idx, percentOff);
  }

  @Override
  public void endSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    int idx = productWatchList.indexOf(product);
    if (idx == -1) {
      throw new ProductNotFoundException();
    }
    notify(new SaleEndEvent(product, this));
    discountSale.set(idx, 1.0);
  }

  @Override
  public int getProductInventory(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    int idx = productWatchList.indexOf(product);
    if (idx == -1) {
      throw new ProductNotFoundException();
    }
    return inventoryLeft.get(idx);
  }

  @Override
  public boolean getIsInStock(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    int idx = productWatchList.indexOf(product);
    if (idx == -1) {
      throw new ProductNotFoundException();
    }
    return !(getProductInventory(product) <= 0);
  }

  @Override
  public double getSalePrice(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    int idx = productWatchList.indexOf(product);
    if (idx == -1) {
      throw new ProductNotFoundException();
    }
    if (getIsOnSale(product)) {
      return (product.getBasePrice() * (1.0 - discountSale.get(idx)) * 100) / 100;
    } else {
      return product.getBasePrice();
    }
  }

  @Override
  public boolean getIsOnSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    int idx = productWatchList.indexOf(product);
    if (idx == -1) {
      throw new ProductNotFoundException();
    }
    return 1.0 > discountSale.get(idx);
  }
}
