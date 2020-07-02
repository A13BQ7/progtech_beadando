package hu.uni.eszterhazy;

public class ForeignSupplier implements SupplierStrategy {
    @Override
    public double customsValue(double price) {
        return price + price * 0.27;
    }
}
