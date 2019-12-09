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
            int i = directions.get(Direction.LEFT);
            directions.put(Direction.LEFT, i--);
            goLeft();
            if (i == 0) {
                directions.remove(Direction.LEFT);
            }
        }
        if (directions.containsKey(Direction.RIGHT)) {
            int i = directions.get(Direction.RIGHT);
            directions.put(Direction.RIGHT, i--);
            goRight();
            if (i == 0) {
                directions.remove(Direction.RIGHT);
            }
        }
        if (directions.containsKey(Direction.UP)) {
            int i = directions.get(Direction.UP);
            directions.put(Direction.UP, i--);
            up();
            if (i == 0 || gameMap.playerUnderSprite(this)) {
                directions.remove(Direction.UP);
                isJumped = false;
            }
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
