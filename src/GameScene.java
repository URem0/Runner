
import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {
    private Camera camera;
    public staticThing left = new staticThing(0,0,"Image/desert.png");
    public staticThing right= new staticThing(800,0,"Image/desert.png");
    public AnimationTimer timer;
    public Hero hero;

    public GameScene(Parent parent, double v, double v1, boolean b, Camera camera,Hero hero) {
        super(parent, v, v1, b);
        this.hero = hero;
        this.camera = camera;
    }

    public staticThing getLeft() {
        return left;
    }

    public staticThing getRight() {
        return right;
    }

    public static void update(long time){

    }







}
