package Week1_DesignPrinciplesAndPatterns.Exercise6_ProxyPattern.Code;

interface Image {
    void display();
}

class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        System.out.println("Displaying the image: " + filename);
    }
}

class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        } else {
            System.out.println("The image is already loaded.");
        }
        realImage.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("img.jpg");

        System.out.println("\nFirst Attempt");
        img1.display();


        System.out.println("\nSecond Attempt");
        img1.display();
    }
}

