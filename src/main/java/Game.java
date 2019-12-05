import component.GameMap;
import component.Player;
import component.Sprite;
import component.sprites.DynamicSprite;
import component.sprites.StaticSprite;
import controllers.MapController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Game extends Application {
    public void start(Stage primaryStage) throws Exception {
        MapController mapController = new MapController();
        GameMap gameMap = mapController.loadMap();

        ArrayList<Player> players = new ArrayList<Player>();
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas( 1600, 900 );
        primaryStage.setScene(scene);
        root.getChildren().add( canvas );
        GraphicsContext gc = canvas.getGraphicsContext2D();
        primaryStage.show();

    }
}
