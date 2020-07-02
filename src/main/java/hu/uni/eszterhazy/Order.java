package hu.uni.eszterhazy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Order implements Subject {
    private final UUID id;
    private ArrayList<Observer> observers;
    private Collection<Product> products;
    private Customer customer;
    private DeliveryStatus deliveryStatus;

    public Order(UUID id, Collection<Product> products, Customer customer) {
        this.id = id;
        this.products = products;
        this.customer = customer;
        this.deliveryStatus = DeliveryStatus.ORDER_RECIEVED;
        this.observers = new ArrayList<>();
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            System.out.println(observer.Update());
        }
    }

    @Override
    public DeliveryStatus getState() {
        return deliveryStatus;
    }
}
