package hu.uni.eszterhazy;

public abstract class Messenger implements Observer {
    private Subject order;
    private DeliveryStatus deliveryStatus;
    protected String deliveryStatusMessage;

    public Messenger(Subject order) {
        this.order = order;
    }

    @Override
    public String Update() {
        this.deliveryStatus = order.getState();
        switch (deliveryStatus) {
            case RECIEVED:
               deliveryStatusMessage = "We received your order";
               break;
            case PACKAGING:
                deliveryStatusMessage = "We are packaging your order";
                break;
            case DELIVERING:
                deliveryStatusMessage = "Your order is under delivery";
                break;
            case ORDER_RECIEVED:
                deliveryStatusMessage = "You received your order";
                break;
        }
        return display();
    }

    abstract String display();
}
