
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    int rep = 1;
    public Camera camera ;
    private final int desertSizeX=800;
    private final int desertSizeY=400;
    public staticThing left;
    public staticThing right;
    public AnimationTimer timer;
    public Hero hero;
    public Pane pane;

    public GameScene(Pane pane, double v, double v1, boolean b) {
        super(pane, v, v1, b);
        this.hero = new Hero(100,250,0,0,100000000,6,75,100,10,"Image/heros.png");;
        this.camera = new Camera(100,0);

        this.left=new staticThing("Image/desert.png",0,0);
        left.getImageView().setViewport(new Rectangle2D(0,0,desertSizeX,desertSizeY));
        pane.getChildren().add(left.getImageView());

        this.right=new staticThing("Image/desert.png",desertSizeX,0);
        right.getImageView().setViewport(new Rectangle2D(0,0,desertSizeX,desertSizeY));
        pane.getChildren().add(right.getImageView());

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {

            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case D -> {
                        hero.addForce(10);
                        break;
                    }
                    case Q -> {

                        hero.addForce(-10);
                        break;
                    }
                    case SPACE -> {
                        hero.jump();
                        break;
                    }
                }
            }
        });
    }
        




    public staticThing getLeft() {
        return left;
    }

    public staticThing getRight() {
        return right;
    }

    public void update(long time){
        right.getImageView().setY(-camera.getY());
        left.getImageView().setY(-camera.getY());

        if(camera.getX()>desertSizeX*rep) {
            rep+=1;
        }
        if (rep % 2 == 1) {
            left.getImageView().setX(desertSizeX * (rep-1) - camera.getX());
            right.getImageView().setX(desertSizeX * (rep) - camera.getX());

        }
        else{
            right.getImageView().setX(desertSizeX * (rep-1) - camera.getX());
            left.getImageView().setX(desertSizeX * (rep) - camera.getX());
        }

        hero.getImageView().setX(hero.getX()-camera.getX());
        hero.getImageView().setY(hero.getY()-camera.getY());

    }


}
