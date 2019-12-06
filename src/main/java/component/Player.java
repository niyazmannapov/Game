package component;

import component.sprites.DynamicSprite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@AllArgsConstructor
@Builder
public class Player {
    public Player() {
        sprite.setImage("");
    }

    private DynamicSprite sprite;
    private boolean isJumped;
    private Turn turn;
    private GameMap gameMap;
    private HashMap<Direction, Integer> directions;
    private int jumpTick = 100;


    private Bullet shoot() {
        return new Bullet(this.sprite.getPositionX(), this.sprite.getPositionY(), this.turn);
    }

    public void updatePosition() {
        if (!gameMap.playerOnSprite(this) && !isJumped) {
            fall();
        }
        if (directions.containsKey(Direction.LEFT)) {
            goLeft();
        }
        if (directions.containsKey(Direction.RIGHT)) {
            goRight();
        }
        if (directions.containsKey(Direction.UP)) {
            up();
        }
    }

    private void up() {
        sprite.updateY(-1);
    }

    private void fall() {
        sprite.updateY(1);
    }

    private void goLeft() {
        sprite.updateX(1);
    }

    private void goRight() {
        sprite.updateX(-1);
    }
}
