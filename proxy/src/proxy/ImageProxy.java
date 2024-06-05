package proxy;

public class ImageProxy implements Image {
	private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("Displaying placeholder image");
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
