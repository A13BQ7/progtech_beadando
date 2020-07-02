package hu.uni.eszterhazy;

import java.util.UUID;

public class Supplier {
    SupplierStrategy sr;
    private UUID id;
    private String name;

    public Supplier(UUID id, String name, SupplierStrategy sr) {
        this.id = id;
        this.name = name;
        this.sr = sr;
    }

    public double customsValue(double price){
            return sr.customsValue(price);
    }
}
