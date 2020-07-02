package hu.uni.eszterhazy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class WarehouseManager {
    private static WarehouseManager warehouseManager;
    private Collection<Warehouse> warehouses;

    public static WarehouseManager getInstance() {
        if (warehouseManager == null) {
            warehouseManager = new WarehouseManager();
        }
        return warehouseManager;
    }

    private WarehouseManager() {
        this.warehouses = new ArrayList<>();
    }

    public void addWarehouse(Warehouse warehouse) {
        this.warehouses.add(warehouse);
    }

    public Collection<Product> listAllProducts() {
        Collection<Product> products = new ArrayList<>();
        Iterator<Warehouse> warehouseIterator = warehouses.iterator();
        while (warehouseIterator.hasNext()) {
            Collection<Product> productList = warehouseIterator.next().getStock();
            Iterator<Product> productIterator = productList.iterator();
            while (productIterator.hasNext()) {
                products.add(productIterator.next());
            }
        }
        return products;
    }
}
