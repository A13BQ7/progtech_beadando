package hu.uni.eszterhazy;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
    DeliveryStatus getState();
}
