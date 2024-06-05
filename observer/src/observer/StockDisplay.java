package observer;

public class StockDisplay implements Observer {
	private String displayId;

    public StockDisplay(String displayId) {
        this.displayId = displayId;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Display " + displayId + " - Stock: " + stockSymbol + " Price: " + price);
    }
}
