package builder;

public class Computer {

    // Required parameters
    private String CPU;
    private String RAM;

    // Optional parameters
    private String storage;
    private String graphicsCard;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", graphicsCard=" + graphicsCard + "]";
    }

    // Builder Class
    public static class Builder {

        // Required parameters
        private String CPU;
        private String RAM;

        // Optional parameters
        private String storage;
        private String graphicsCard;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public static void main(String[] args) {
        Computer computer1 = new Computer.Builder("Intel i5", "16GB")
                            .setStorage("512GB SSD")
                            .setGraphicsCard("NVIDIA GTX 1650")
                            .build();

        Computer computer2 = new Computer.Builder("AMD Ryzen 7", "32GB")
                            .setStorage("1TB SSD")
                            .build();

        System.out.println(computer1);
        System.out.println(computer2);
    }
}