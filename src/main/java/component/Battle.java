package component;

import controllers.MapController;
import lombok.AllArgsConstructor;
import lombok.Data;
import sockets.ClientHandler;

import java.util.ArrayList;

@Data
public class Battle implements Runnable {
    private GameMap map;
    private ArrayList<ClientHandler> players;
    private ArrayList<Bullet> bullets;

    public Battle(ArrayList<ClientHandler> players) {
        MapController mapController = new MapController();
        this.map = mapController.loadMap();
        this.players = players;
    }

    public void run() {
        while (true) {

        }
    }

}
