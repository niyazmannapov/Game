package component;

import component.sprites.DynamicSprite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class Player {
    public Player() {
        sprite.setImage("");
    }

    private DynamicSprite sprite;
    private boolean inJump;
    private boolean inFall;
    private Direction direction;

    private Bullet shoot() {
        return new Bullet(this.sprite.positionX, this.sprite.positionY, this.direction);
    }

    private void jump() {
    }

    private void goLeft() {
    }

    private void goRight() {
    }
}
