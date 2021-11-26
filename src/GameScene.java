
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.Random;


import java.util.ArrayList;

public class GameScene extends Scene {
    int rep = 1;
    int numberOfLives = 3;
    public Camera camera ;
    private final int desertSizeX=800;
    private final int desertSizeY=400;
    public staticThing left;
    public staticThing right;
    public staticThing over;
    public Hero hero;
    public ArrayList<staticThing> lives;
    public ArrayList<Foe> enemy;
    public int score;
    public Text dedans;
    public Text restart;
    public StackPane stack2;





    public GameScene(Pane pane, double v, double v1, boolean b) {
        super(pane, v, v1, b);
        this.hero = new Hero(0,250, AnimatedThing.Attitude.IDLE,0,100000000,6,75,100,10,"heros.png");;
        this.camera = new Camera(0,0);
        this.enemy = new ArrayList<Foe>(300);
        this.lives = new ArrayList<staticThing>(numberOfLives);
        this.score=0;

        staticThing life1  = new staticThing("life.png",5,0);
        life1.getImageView().setFitWidth(55);
        life1.getImageView().setFitHeight(80);
        life1.getImageView().setViewport(new Rectangle2D(0,0,200,320));
        lives.add(life1);

        staticThing life2  = new staticThing("life.png",60,0);
        life2.getImageView().setFitWidth(55);
        life2.getImageView().setFitHeight(80);
        life2.getImageView().setViewport(new Rectangle2D(0,0,200,320));
                           lives.add(life2);

        staticThing life3  = new staticThing("life.png",115,0);
        life3.getImageView().setFitWidth(55);
        life3.getImageView().setFitHeight(80);
        life3.getImageView().setViewport(new Rectangle2D(0,0,200,320));
        lives.add(life3);

        this.left=new staticThing("desert.png",0,0);
        left.getImageView().setViewport(new Rectangle2D(0,0,desertSizeX,desertSizeY));
        pane.getChildren().add(left.getImageView());

        this.right=new staticThing("desert.png",desertSizeX,0);
        right.getImageView().setViewport(new Rectangle2D(0,0,desertSizeX,desertSizeY));
        pane.getChildren().add(right.getImageView());
        this.over = new staticThing("over.png",-5000,-500);


        Rectangle text = new Rectangle(0,0,50,50);
        text.setFill(Color.TRANSPARENT);
        this.dedans = new Text();
        dedans.setFont(Font.font ("Verdana", 20));
        StackPane stack = new StackPane();
        stack.getChildren().addAll(text,dedans);
        stack.relocate(350,10);

        Rectangle reset = new Rectangle(0,0,50,50);
        reset.setFill(Color.TRANSPARENT);
        this.restart = new Text();
        restart.setFont(Font.font ("Verdana", 25));
        restart.setFill(Color.WHITE);
        this.stack2 = new StackPane();
        stack2.getChildren().addAll(reset,restart);
        stack2.relocate(-6000,300);

        for (int i=1; i<300 ;i++){
            Foe foe1 = new Foe(i*800 ,250, "cactus.png");
            enemy.add(foe1);
            pane.getChildren().add(enemy.get(i-1).getImageView());
        }

        pane.getChildren().add(life1.getImageView());
        pane.getChildren().add(life2.getImageView());
        pane.getChildren().add(life3.getImageView());
        pane.getChildren().add(hero.getImageView());
        pane.getChildren().add(stack);
        pane.getChildren().add(over.getImageView());
        pane.getChildren().add(stack2);

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case SPACE -> {
                        hero.jump();
                        break;
                    }
                    case R -> {
                        if (hero.attitude== AnimatedThing.Attitude.DEAD){
                        numberOfLives = 3;
                        life1.getImageView().setViewport(new Rectangle2D(0,0,200,320));
                        life2.getImageView().setViewport(new Rectangle2D(0,0,200,320));
                        life3.getImageView().setViewport(new Rectangle2D(0,0,200,320));
                        stack2.relocate(-6000,300);
                        score=0;}
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

        dedans.setText("Score : "+getScore());
        restart.setText("PRESS R TO RESTART");
        if (numberOfLives!=0){
            over.getImageView().setX(-5000);
            over.getImageView().setY(-90);
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

            for (int i =1; i<300;i++){
                if (hero.getX()==i*800 ){
                    score++;
                }


                enemy.get(i-1).update(time);
                enemy.get(i-1).getImageView().setX(enemy.get(i-1).getX()-camera.getX());
                enemy.get(i-1).getImageView().setY(enemy.get(i-1).getY()-camera.getY());

                    if (hero.getHitbox().intersects(enemy.get(i-1).getHitbox())){
                        if (hero.invincibility==false){
                            hero.invincibility = true;
                            System.out.println("AIE");
                            numberOfLives--;
                            System.out.println(numberOfLives);

                    }
            }}
            hero.update(time);

            switch (numberOfLives){
                case 3:
                    break;
                case 2:
                    lives.get(2).getImageView().setViewport(new Rectangle2D(460,0,200,320));
                    break;
                case 1:
                    lives.get(1).getImageView().setViewport(new Rectangle2D(460,0,200,320));
                    break;
                case 0:
                    lives.get(0).getImageView().setViewport(new Rectangle2D(460,0,200,320));

                    break;
        }

    }else{
            hero.attitude = AnimatedThing.Attitude.DEAD;
            over.getImageView().setX(305);
            over.getImageView().setY(70);
            stack2.relocate(250,175);
            }
    }
    public int getScore(){
         return score;
    }


}
