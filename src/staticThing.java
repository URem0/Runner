import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {
    private double x;
    private double y;
    ImageView imageView;

    public staticThing(double x,double y, String fileName){
        this.x=x;
        this.y=y;
        Image image = new Image(fileName);
        imageView = new ImageView(image);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
