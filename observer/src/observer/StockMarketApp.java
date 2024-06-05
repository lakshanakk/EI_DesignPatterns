package observer;

public class StockMarketApp {
	public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.00);
        Stock googleStock = new Stock("GOOGL", 2800.00);

        StockDisplay display1 = new StockDisplay("Display1");
        StockDisplay display2 = new StockDisplay("Display2");
        StockLogger logger = new StockLogger();

        appleStock.attach(display1);
        appleStock.attach(display2);
        appleStock.attach(logger);

        googleStock.attach(display1);
        googleStock.attach(logger);

        // Simulate price changes
        appleStock.setPrice(152.50);
        googleStock.setPrice(2820.00);

        // Detach a display and simulate another price change
        appleStock.detach(display2);
        appleStock.setPrice(155.00);
    }

}
