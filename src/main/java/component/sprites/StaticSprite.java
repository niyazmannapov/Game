package component.sprites;

import component.Player;
import component.Sprite;
import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class StaticSprite extends Sprite {
    public StaticSprite(){
        super();
    };

    public StaticSprite(Image image, double positionX, double positionY, double velocityX, double velocityY, double width, double height) {
        super(image, positionX, positionY, velocityX, velocityY, width, height);
    }

    public boolean under(Player player) {
        return this.getBoundary().getMaxY() == player.getSprite().getBoundary().getMinY() &&
                player.getSprite().getPositionX() <= this.getBoundary().getMaxX() &&
                player.getSprite().getPositionX() >= this.getBoundary().getMinX();
    }

    public boolean on(Player player) {
        return this.getBoundary().getMinY() == player.getSprite().getBoundary().getMaxY() &&
                player.getSprite().getPositionX() <= this.getBoundary().getMaxX() &&
                player.getSprite().getPositionX() >= this.getBoundary().getMinX();
    }

    public boolean playerLeft(Player player) {
        return player.getSprite().getBoundary().getMaxX() == this.getBoundary().getMinX() &&
                player.getSprite().getBoundary().intersects(this.getBoundary());
    }

    public boolean playerRight(Player player) {
        return player.getSprite().getBoundary().getMinX() == this.getBoundary().getMaxX() &&
                player.getSprite().getBoundary().intersects(this.getBoundary());
    }
}
