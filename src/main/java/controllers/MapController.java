package controllers;


import component.GameMap;
import component.sprites.StaticSprite;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class MapController {
    @FXML
    private AnchorPane mapObjects;

    public GameMap loadMap() {
        GameMap map = new GameMap();
        for (Node node : mapObjects.getChildren()) {
            ImageView iv = (ImageView) node;
            Image image = iv.getImage();
            StaticSprite ss = new StaticSprite();
            ss.setImage(image);
            ss.setPosition(iv.getX(), iv.getY());
            map.addObject(ss);
        }
        return map;
    }
}
