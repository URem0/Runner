import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    enum Attitude{JUMPING_UP,JUMPING_DOWN,RUNNING,STILL,DEAD}
    public Attitude attitude;
    public double x;
    public double y;
    public long a;
    public double duration;
    public int maxa;
    public  double sizex;
    public double sizey;
    public int offset;
    public String filename;
    public ImageView imageView;
    public AnimationTimer timer;


    public AnimatedThing(double x,double y , Attitude attitude,long a,double duration, int maxa,double sizex ,double siezy,int offset,String filename){
        this.x =x;
        this.y=y;
        this.attitude=attitude;
        this.a=a;
        this.duration=duration;
        this.maxa=maxa;
        this.sizex=sizex;
        this.sizey=siezy;
        this.offset=offset;
        this.filename=filename;
        this.imageView = new ImageView(filename);
    }
    public ImageView getImageView() {
        return imageView;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void update(long t){
        a=(int) ((t%(maxa*duration))/duration);

        if(attitude==Attitude.RUNNING){

            this.imageView.setViewport(new Rectangle2D(a*(sizex+offset),0, sizex+offset,sizey));

        }else if (attitude==Attitude.JUMPING_UP){

            this.imageView.setViewport(new Rectangle2D(offset,160,sizex+offset,sizey));

        }else if(attitude==Attitude.JUMPING_DOWN){

            this.imageView.setViewport(new Rectangle2D(95,160,sizex+offset,sizey));

        }else if(attitude==Attitude.STILL){

            this.imageView.setViewport(new Rectangle2D(0,0,sizex+offset,sizey));
        }
    }
    public abstract void updateAttitude();

}
