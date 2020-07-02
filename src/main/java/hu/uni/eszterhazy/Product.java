package hu.uni.eszterhazy;

import java.util.UUID;

public class Product {
    private final UUID id;
    private String name;
    private int amount;
    private Supplier supplier;

    public Product(UUID id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
