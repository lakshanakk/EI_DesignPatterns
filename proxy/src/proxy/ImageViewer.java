package proxy;

public class ImageViewer {
	public static void main(String[] args) {
        Image image1 =  new ImageProxy("image1.jpg");
        Image image2 =  new ImageProxy("image2.jpg");

        // Display images
        image1.display();  // Displays placeholder and starts loading the real image
        System.out.println();
        image1.display();  // Displays the real image, which is already loaded

        System.out.println();

        image2.display();  // Displays placeholder and starts loading the real image
        System.out.println();
        image2.display();  // Displays the real image, which is already loaded
    }
}
