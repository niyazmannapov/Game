package component;

import javafx.scene.shape.Circle;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class GameCircle extends Circle {
    private double speed = 5;
    private double velocityX;
    private double velocityY;
    private long gameId;
    private GameMap gameMap = GameMap.getInstance();

    ArrayList<String> input = new ArrayList<>();

    public GameCircle(double x, double y) {
        super(x, y, 5);
    }

    public GameCircle(double x, double y, double radius) {
        super(x, y, radius);
    }

    public GameCircle(double x, double y, double radius, long gameId) {
        super(x, y, radius);
        setGameId(gameId);
    }

    public void setPosition(double x, double y) {
        this.setCenterX(x);
        this.setCenterY(y);
    }


    public void up() {
        addVelocity(0, -50);
    }

    public void down() {
        addVelocity(0, 50);
    }

    public void left() {
        addVelocity(-50, 0);
    }

    public void right() {
        addVelocity(50, 0);
    }

    public void update(double elapsedTime) {
        this.setCenterX(this.getCenterX() + elapsedTime * velocityX);
        this.setCenterY(this.getCenterY() + elapsedTime * velocityY);
    }

    public void update(double elapsedTime, double velocityX, double velocityY) {
        this.setCenterX(this.getCenterX() + elapsedTime * velocityX);
        this.setCenterY(this.getCenterY() + elapsedTime * velocityY);
    }

    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
    }

    public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
