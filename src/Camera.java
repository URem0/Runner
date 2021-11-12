public class Camera {
    private int x;
    private int y;

    private double vx,vy;
    private double ax,ay;

    private final double k=10;
    private final double m=70;
    private final double f=10;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Camera(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return "("+x+";"+y+")";
    }


    public void update(long time,Hero hero){
        double x_hero=hero.getX();
        double y_hero=hero.getY();

        double c1=k/m;
        double c2=f/m;

        ax=c1*(x_hero-x)-c2*vx;
        vx+=ax;
        x+=vx;

        ay=c1*(y_hero-250-y)-c2*vy;

        vy+=ay;
        y+=vy;
    }
}
