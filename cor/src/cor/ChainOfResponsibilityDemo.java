package cor;


public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Order order = new Order("Chicken Biryani", "Swiggy", "Meghna Foods");

        Handler swiggyHandler = new SwiggyHandler();
        Handler meghnaFoodsHandler = new MeghnaFoodsHandler();
        Handler cookHandler = new CookHandler();

        swiggyHandler.setNextHandler(meghnaFoodsHandler);
        meghnaFoodsHandler.setNextHandler(cookHandler);

        swiggyHandler.handle(order);
    }
}