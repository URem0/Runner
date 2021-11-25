public class Hero extends  AnimatedThing{
    private final double g=0.2;
    private final double m=20;
    private double v_x,v_y;
    private double a_y;
    private double f_y;
    protected final int yGround=150;
    protected long timeInvincible = 500000000  ;
    protected long count = 0;
    public boolean invincibility = false;

    public Hero(double x, double y, Attitude attitude, int a, double duration, int maxa, double sizex, double siezy, int offset, String filename) {
        super(x, y, attitude, a, duration, maxa, sizex, siezy, offset, filename);
    }

    public void jump(){
        if (y>=yGround + sizey){
            f_y +=150;
        }
    }

    public void setForce(double f_y){
        this.f_y=f_y;
    }


    @Override
    public void updateAttitude() {
        if (v_y>0){
            attitude=Attitude.JUMPING_DOWN;
        }
        else if (v_y<0){
            attitude=Attitude.JUMPING_UP;
        }
        else{
            attitude=Attitude.RUNNING;
        }
        if (v_x==0){
            attitude=Attitude.IDLE;
        }
    }
    @Override
    public void update(long t) {
        super.update(t);
        updateAttitude();
        double time = t / 100000000;
        v_x=5;
        x += v_x;

        a_y =(g-f_y /m);
        v_y += a_y;
        y += v_y;

        if (y > yGround + sizey) {
            if (v_y > 0) {
                v_y = 0;
            }
            y = yGround + sizey;
        }
        setForce(0);


        if (invincibility){
                timeInvincible -=time;
                System.out.println("timeinvincibilité =" + timeInvincible);
        }
        if(timeInvincible < 0){
                invincibility = false;
                System.out.println("je fais qqchdddddddddddddddddddddddd");
                timeInvincible = 500000000;


        }

    }

}
