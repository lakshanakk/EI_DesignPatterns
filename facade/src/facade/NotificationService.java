package facade;

public class NotificationService {
	public boolean sendOrderConfirmation(String customerEmail) {
        // Logic to send order confirmation
        System.out.println("Sending order confirmation to " + customerEmail);
        return true;
    }

}
