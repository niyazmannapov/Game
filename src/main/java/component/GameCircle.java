package component;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Circle;
import lombok.Data;

import java.util.ArrayList;

@Data
public class GameCircle extends Circle implements Runnable {
    private double speed = 5;
    private double velocityX;
    private double velocityY;
    private GameMap gameMap = GameMap.getInstance();

    ArrayList<String> input = new ArrayList<>();

    public GameCircle(double x, double y) {
        super(x, y, 5);
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
    public void run() {
        ArrayList<GameCircle> gameCircleArrayList = new ArrayList<>(gameMap.getGameCircleArrayList());
        for (GameCircle gc : gameCircleArrayList) {
            if ((this.intersects(gc.getLayoutBounds())) && gc != this && gc.getRadius() < this.getRadius()) {
                this.setRadius(this.getRadius() + gc.getRadius());
                gameMap.getGameCircleArrayList().remove(gc);
            }
        }
        ArrayList<Food> foodArrayList = new ArrayList<>(gameMap.getFoodArrayList());
        for (Food food : foodArrayList) {
            if ((this.intersects(food.getLayoutBounds()))) {
                this.setRadius(this.getRadius() + 1);
                gameMap.getFoodArrayList().remove(food);
            }
        }
    }


}
