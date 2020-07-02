package hu.uni.eszterhazy;

public class SmsMessanger extends Messenger {
    public SmsMessanger(Subject order) {
        super(order);
    }

    @Override
    protected String display() {
        return ("SMS message is sent: " + this.deliveryStatusMessage);
    }
}
