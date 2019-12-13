package component;

import javafx.scene.shape.Circle;
import lombok.Data;

@Data
public class Food extends Circle {

    public Food(int x, int y) {
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(1);
    }
}
