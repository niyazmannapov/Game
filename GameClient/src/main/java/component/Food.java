package component;

import javafx.scene.shape.Circle;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Food extends Circle {

    public Food(double x, double y) {
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(2);
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
