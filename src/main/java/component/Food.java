package component;

import javafx.scene.shape.Circle;
import lombok.Data;

@Data
public class Food extends Circle {

    @Override
    public String toString() {
        return "Food{" +
                "Position_x=" + this.getCenterX() + " Position_y =" + this.getCenterY() +
                '}';
    }

    public Food(int x, int y) {
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(2);
    }

}
