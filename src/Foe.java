import javafx.geometry.Rectangle2D;

public class Foe extends AnimatedThing{
    private double v_x,v_y;
    private double a_x,a_y;
    private double f_x,f_y;

    protected final int yGround=150; //=150 pour le enemy =inverse hero
    private final double g=0.2;
    private final double m=20;
    public Foe(double x, double y, String filename) {
        super(x, y, Attitude.IDLE, 0, 0, 0, 75, 100, 0, filename);

    }

    @Override
    public void updateAttitude() {
    }
    @Override
    public void update(long t) {
        super.update(t);


    }
}
