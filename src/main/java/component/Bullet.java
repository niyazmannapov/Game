package component;

import component.sprites.DynamicSprite;

public class Bullet {
    private DynamicSprite sprite;
    private double speed;
    private Turn turn;

    public Bullet(double x, double y, Turn turn) {
        sprite = new DynamicSprite();
        sprite.setImage("bullet.jpg");
        sprite.setPosition(x, y);
        this.turn = turn;
    }

}
