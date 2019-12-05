package component;

public class Physics {
    private double gravityCoef;

    private void fall(Player player) {
        player.getSprite().setPositionY(player.getSprite().getPositionY() - gravityCoef);
    }
}
