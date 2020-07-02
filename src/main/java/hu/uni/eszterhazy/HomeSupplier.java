package hu.uni.eszterhazy;

public class HomeSupplier implements SupplierStrategy{
    @Override
    public double customsValue(double price) {
        return price + price * 0.0;
    }
}
