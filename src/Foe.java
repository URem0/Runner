import javafx.geometry.Rectangle2D;

public class Foe extends AnimatedThing{

    public Foe(double x, double y, String filename) {
        super(x, y, Attitude.STILL, 0, 0, 0, 512, 512, 0, filename);
        getImageView().setFitHeight(100);
        getImageView().setFitWidth(100);
    }

    @Override
    public void updateAttitude() {
    }
}
