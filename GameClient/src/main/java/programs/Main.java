package programs;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import component.GameCircle;
import component.GameMap;
import dto.CircleMoveDto;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sockets.SocketClient;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String... argv) {
        System.out.println(argv.length);
        System.out.println(argv[0]);
        Application.launch(argv);
    }

    @Override
    public void start(Stage theStage) throws Exception {

        String ip = getParameters().getUnnamed().get(0);
        System.out.println(ip);
        SocketClient socketClient = new SocketClient();
        socketClient.startConnection(ip, 1234);
        theStage.setTitle("Canvas Example");
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);
        Canvas canvas = new Canvas(1600, 900);
        root.getChildren().add(canvas);
        ArrayList<String> input = new ArrayList<String>();
        theStage.show();

        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        if (!input.contains(code))
                            input.add(code);
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        input.remove(code);
                    }
                });

        final double[] lastNanoTime = {System.nanoTime()};


        CircleMoveDto circleMoveDto = new CircleMoveDto();
        Pane pane = new Pane();
        root.getChildren().add(pane);
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                pane.getChildren().clear();
                double elapsedTime = (currentNanoTime - lastNanoTime[0]) / 1000000000.0;
                lastNanoTime[0] = currentNanoTime;
                circleMoveDto.setVelocityX(0);
                circleMoveDto.setVelocityY(0);

                if (input.contains("LEFT")) {
                    circleMoveDto.setVelocityX(-10);
                }
                if (input.contains("RIGHT"))
                    circleMoveDto.setVelocityX(10);
                if (input.contains("UP"))
                    circleMoveDto.setVelocityY(-10);
                if (input.contains("DOWN"))
                    circleMoveDto.setVelocityY(10);
                circleMoveDto.setElapsedTime(elapsedTime);
                socketClient.sendMessage(circleMoveDto);
                pane.getChildren().addAll(GameMap.getInstance().getGameCircleArrayList());
                pane.getChildren().addAll(GameMap.getInstance().getFoodArrayList());
            }
        }.start();
    }

}
