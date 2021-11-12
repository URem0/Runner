
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

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
    public ArrayList<Foe> enemy;

    public GameScene(Pane pane, double v, double v1, boolean b) {
        super(pane, v, v1, b);
        this.hero = new Hero(100,250, AnimatedThing.Attitude.STILL,0,100000000,6,75,100,10,"heros.png");;
        this.camera = new Camera(100,0);
        this.enemy = new ArrayList<Foe>(100);


        this.left=new staticThing("desert.png",0,0);
        left.getImageView().setViewport(new Rectangle2D(0,0,desertSizeX,desertSizeY));
        pane.getChildren().add(left.getImageView());

        this.right=new staticThing("desert.png",desertSizeX,0);
        right.getImageView().setViewport(new Rectangle2D(0,0,desertSizeX,desertSizeY));
        pane.getChildren().add(right.getImageView());


        for (int i=1; i<100 ;i++){
            Foe foe1 = new Foe(i*800,250, "cactus.png");
            enemy.add(foe1);
            pane.getChildren().add(enemy.get(i-1).getImageView());
        }
        pane.getChildren().add(hero.getImageView());

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
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

        for (int i =1; i<100;i++){
            enemy.get(i-1).getImageView().setX(enemy.get(i-1).getX()-camera.getX());
            enemy.get(i-1).getImageView().setY(enemy.get(i-1).getY()-camera.getY());
        }

    }


}
