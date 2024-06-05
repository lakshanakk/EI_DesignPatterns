package cor;

public class Order {
    private String item;
    private String from;
    private String to;

    public Order(String item, String from, String to) {
        this.item = item;
        this.from = from;
        this.to = to;
    }

    public String getItem() {
        return item;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
