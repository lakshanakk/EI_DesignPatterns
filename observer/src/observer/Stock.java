package observer;
import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject{
	private String symbol;
    private double price;
    private List<Observer> observers;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(symbol, price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}
