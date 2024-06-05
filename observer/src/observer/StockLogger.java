package observer;

public class StockLogger implements Observer {
	 @Override
	    public void update(String stockSymbol, double price) {
	        System.out.println("Logging - Stock: " + stockSymbol + " Price: " + price);
	    }

}
