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

             GameScene theScene = new GameScene(pane, 800, 400,true);
             primaryStage.setScene(theScene);
             pane.getChildren().add(theScene.hero.getImageView());

             AnimationTimer timer = new AnimationTimer()
             {public void handle(long time){
                 theScene.hero.update(time);
                 theScene.camera.update(time);
                 theScene.update(time);
             }
             };
             timer.start();
             theScene.hero.getImageView().relocate(0,250);
             primaryStage.show();
         }


         public static void main(String[] args) {
              launch(args);
 }
}
