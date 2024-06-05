package cor;



public class MeghnaFoodsHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
        System.out.println("Handler set to "+ handler);
    }

    @Override
    public void handle(Order order) {
        if ("Meghna Foods".equals(order.getTo())) {
            System.out.println("Order received by Meghna Foods. Forwarding to the cook...");
            if (nextHandler != null) {
                nextHandler.handle(order);
            }
        }
    }
}