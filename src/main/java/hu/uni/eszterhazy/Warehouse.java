package hu.uni.eszterhazy;

import java.util.ArrayList;
import java.util.Collection;

public class Warehouse {
    private Collection<Product> stock;

    public Warehouse() {
        this.stock = new ArrayList<Product>();
    }

    public Collection<Product> getStock() {
        return stock;
    }

    public void AddToStock(Product newProduct) {
        boolean isNew = true;
        for (Product product : stock) {
            if (product.getName().equals(newProduct.getName())) {
                product.setAmount(product.getAmount() + product.getAmount());
                isNew = false;
            }
        }
        if (isNew) {
            stock.add(newProduct);
        }
    }

    public void RemoveStock(Product removeProduct) throws Exception {
        boolean isOut = false;
        for (Product product : stock) {
            if (product.getAmount() < removeProduct.getAmount()) {
                throw new Exception("Not enough produck available");
            } else if (product.getAmount() == removeProduct.getAmount()) {
                stock.remove(product);
            } else {
                product.setAmount(product.getAmount() - removeProduct.getAmount());
            }
        }
    }
}
