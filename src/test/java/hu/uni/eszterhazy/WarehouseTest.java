package hu.uni.eszterhazy;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WarehouseTest {
    @Test
    public void WarehouseManagerSingletonTest() {
        WarehouseManager warehouseManager = WarehouseManager.getInstance();
        WarehouseManager warehouseManager2 = WarehouseManager.getInstance();
        Assert.assertEquals(warehouseManager, warehouseManager2);
    }

    @Test
    public void addToWarehouseTest() {
        LaptopWarehouse warehouse = new LaptopWarehouse();
        Product product = new Product(
                UUID.randomUUID(),
                "HP laptop",
                11
        );
        warehouse.AddToStock(product);
        assertTrue(warehouse.getStock().contains(product));
    }

    @Test
    public void addToWarehouseSameProductTest() {
        LaptopWarehouse warehouse = new LaptopWarehouse();
        Product product = new Product(
                UUID.randomUUID(),
                "HP laptop",
                11
        );
        warehouse.AddToStock(product);
        warehouse.AddToStock(product);
        assertEquals(22, warehouse.getStock().iterator().next().getAmount());
    }

    @Test
    public void ObserverBehaviourTest() {
        ArrayList<Product> products = new ArrayList<Product>();
        Customer customer = new Customer(UUID.randomUUID(), "John Smith", LocalDate.of(1975, 12, 12), "Eger, Leányka Street 2");
        Order order = new Order(UUID.randomUUID(), products, customer);
        order.attach(new SmsMessanger(order));
        order.attach(new EmailMessenger(order));
        order.setDeliveryStatus(DeliveryStatus.DELIVERING);
    }

    @Test
    public void homeSupplierStrategyTest(){
        UUID testUUID = UUID.randomUUID();
        String testName = "homeTest";
        double price = 1000;
        Supplier s1 = new Supplier(testUUID,testName, new HomeSupplier()) ;
        double actual = s1.customsValue(price);
        double expected = price + price * 0.0;
        double delta = 1;
        Assert.assertEquals(expected,actual, delta);
    }

    @Test
    public void foreignSupplierStrategyTest() {
        UUID testUUID = UUID.randomUUID();
        String testName = "foreignTest";
        double price = 1000;
        Supplier s1 = new Supplier(testUUID,testName, new ForeignSupplier()) ;
        double actual = s1.customsValue(price);
        double expected = price + price * 0.27;
        double delta = 1;
        Assert.assertEquals(expected,actual, delta);
    }

    @Test
    public void warehouseMangerTest() {
        LaptopWarehouse laptopWarehouse = new LaptopWarehouse();
        Product laptop = new Product(
                UUID.randomUUID(),
                "HP laptop",
                11
        );
        laptopWarehouse.AddToStock(laptop);

        PhoneWarehouse phoneWarehouse = new PhoneWarehouse();
        Product phone = new Product(
                UUID.randomUUID(),
                "HP laptop",
                11
        );
        phoneWarehouse.AddToStock(phone);

        WarehouseManager warehouseManager = WarehouseManager.getInstance();
        warehouseManager.addWarehouse(laptopWarehouse);
        warehouseManager.addWarehouse(phoneWarehouse);
        Assert.assertEquals(2, warehouseManager.listAllProducts().size());
    }
}
