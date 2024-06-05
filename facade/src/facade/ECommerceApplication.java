package facade;

public class ECommerceApplication {
	 public static void main(String[] args) {
	        OrderFacade orderFacade = new OrderFacade();
	        String result = orderFacade.placeOrder("PRODUCT123", "PAYMENT_DETAILS", "customer@example.com");
	        System.out.println(result);
	    }
}
