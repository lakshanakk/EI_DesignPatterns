package cor;

public interface Handler {
    void setNextHandler(Handler handler);
    void handle(Order order);
}
