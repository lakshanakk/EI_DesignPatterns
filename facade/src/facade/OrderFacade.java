package facade;

public class OrderFacade {
	 private InventoryManager inventoryManager;
	    private PaymentProcessor paymentProcessor;
	    private ShippingService shippingService;
	    private NotificationService notificationService;

	    public OrderFacade() {
	        this.inventoryManager = new InventoryManager();
	        this.paymentProcessor = new PaymentProcessor();
	        this.shippingService = new ShippingService();
	        this.notificationService = new NotificationService();
	    }

	    public String placeOrder(String productId, String paymentDetails, String customerEmail) {
	        if (!inventoryManager.checkStock(productId)) {
	            return "Product is out of stock";
	        }

	        if (!paymentProcessor.processPayment(paymentDetails)) {
	            return "Payment failed";
	        }

	        String orderId = "ORDER123"; // This would be generated dynamically
	        if (!shippingService.arrangeShipping(orderId)) {
	            return "Shipping arrangement failed";
	        }

	        if (!notificationService.sendOrderConfirmation(customerEmail)) {
	            return "Failed to send order confirmation";
	        }

	        return "Order placed successfully";
	    }

}
