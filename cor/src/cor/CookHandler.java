package cor;
public class CookHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handle(Order order) {
        System.out.println("Cook is preparing the " + order.getItem());
        // No next handler in the chain
    }
}