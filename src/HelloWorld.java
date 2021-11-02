import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

         @Override
 public void start(Stage primaryStage) throws Exception{
             primaryStage.setTitle("Hello world");
             Group root = new Group();

             Pane pane = new Pane(root);
             Camera camera = new Camera(600,400);
             Hero hero = new Hero(20,0,0,0,100000000,6,75,100,10,"Image/heros.png");
             GameScene theScene = new GameScene(pane, 800, 400,true,camera,hero);
             primaryStage.setScene(theScene);

             ImageView right =theScene.getRight().getImageView();
             ImageView left = theScene.getLeft().getImageView();

             right.setX(theScene.getRight().getX());

             pane.getChildren().add(left);
             pane.getChildren().add(right);
             pane.getChildren().add(theScene.hero.getSprite());
             AnimationTimer timer = new AnimationTimer()
             {public void handle(long time){
                 theScene.hero.update(time);
                 camera.update(time);
                 theScene.update(time);
             }
             };
             timer.start();
             theScene.hero.getSprite().relocate(0,250);
             primaryStage.show();
         }


         public static void main(String[] args) {
              launch(args);
 }
}
