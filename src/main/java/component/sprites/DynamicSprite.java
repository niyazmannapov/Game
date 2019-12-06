package component.sprites;

import javafx.scene.image.Image;
import lombok.Data;

@Data
public class DynamicSprite extends Sprite {
    public DynamicSprite() {
        super();
    }

    public DynamicSprite(Image image, double positionX, double positionY, double velocityX, double velocityY, double width, double height) {
        super(image, positionX, positionY, velocityX, velocityY, width, height);
    }

    public void updateX(double x) {
        this.positionX += x;
    }

    public void updateY(double y) {
        this.positionY += y;
    }

    public void update(double x, double y) {
        this.positionX += x;
        this.positionY += y;
    }
}
