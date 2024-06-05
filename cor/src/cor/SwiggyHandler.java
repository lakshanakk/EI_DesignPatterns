package cor;

public class SwiggyHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handle(Order order) {
        if ("Swiggy".equals(order.getFrom())) {
            System.out.println("Order received by Swiggy. Forwarding to Meghna Foods...");
            if (nextHandler != null) {
                nextHandler.handle(order);
            }
        }
    }
}



