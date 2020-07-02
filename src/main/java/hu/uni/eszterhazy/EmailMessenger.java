package hu.uni.eszterhazy;

public class EmailMessenger extends Messenger {
    public EmailMessenger(Subject order) {
        super(order);
    }

    @Override
    String display() {
        return ("Email message is sent: " + this.deliveryStatusMessage);
    }
}
