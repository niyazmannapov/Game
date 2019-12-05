package component;

import component.sprites.DynamicSprite;

public class Bullet {
    private DynamicSprite sprite;
    private double speed;
    private Direction direction;

    public Bullet(double x, double y, Direction direction) {
        sprite = new DynamicSprite();
        sprite.setImage("bullet.jpg");
        sprite.setPosition(x, y);
        this.direction = direction;
    }

}
