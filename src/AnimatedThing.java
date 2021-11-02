import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    public double x;
    public double y;
    public int attitude;
    public long a;
    public double duration;
    public int maxa;
    public  double sizex;
    public double sizey;
    public int offset;
    public String filename;
    public ImageView sprite;
    public AnimationTimer timer;


    public AnimatedThing(double x,double y , int attitude,long a,double duration, int maxa,double sizex ,double siezy,int offset,String filename){
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
        this.sprite = new ImageView(filename);
    }

    public ImageView getSprite() {
        return sprite;
    }

    public void update(long time){
        a = (int) ((time % (maxa * duration)) / duration);
        this.getSprite().setViewport(new Rectangle2D(a*(sizex+offset),0,sizex+offset,100));
    }

}
