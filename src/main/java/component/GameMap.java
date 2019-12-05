package component;

import component.sprites.StaticSprite;

import java.util.ArrayList;

public class GameMap {
    private ArrayList<StaticSprite> mapObjects;
    private Physics physics;

    public void addObject(StaticSprite mapObject) {
        for (StaticSprite m : mapObjects) {
            if (m.getBoundary().intersects(mapObject.getBoundary())) {
                throw new IllegalStateException("Позиция занята");
            }
        }
        mapObjects.add(mapObject);

    }

    public boolean playerOnSprite(Player player) {
        for (StaticSprite m : mapObjects) {
            if (m.under(player)) {
                return true;
            }
        }
        return false;
    }

    public boolean playerUnderSprite(Player player) {
        for (StaticSprite m : mapObjects) {
            if (m.on(player)) {
                return true;
            }
        }
        return false;
    }

    public boolean playerLeft(Player player) {
        for (StaticSprite m : mapObjects) {
            if (m.playerLeft(player)) {
                return true;
            }
        }
        return false;
    }

    public boolean playerRight(Player player) {
        for (StaticSprite m : mapObjects) {
            if (m.playerRight(player)) {
                return true;
            }
        }
        return false;
    }


}
