public class Camera {
    int x;
    int y;
    double vx,vy;
    /*final double ksurm = 1;
    final double fsurm=1.2;
    Hero hero;
    double dt;
    double xh = hero.x ;
    double yh = hero.y;

    double ax = ksurm*(xh-x)+fsurm*vx;
    double ay = ksurm*(yh-y)+fsurm*vy;

    double dvx = ax*dt;
    double dx = vx*dt;
    double dvy = ay*dt;
    double dy = vy*dt;*/


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







    public void update(long time){

    }
}
