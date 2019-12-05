package component;

import controllers.MapController;
import lombok.AllArgsConstructor;
import lombok.Data;
import sockets.ClientHandler;

import java.util.ArrayList;

@Data
public class Battle implements Runnable {
    private GameMap map;
    private Physics physics;
    private ArrayList<ClientHandler> players;

    public Battle(ArrayList<ClientHandler> players) {
        MapController mapController = new MapController();
        physics = new Physics();
        this.map = mapController.loadMap();
        this.players = players;
    }

    public void run() {
        while (true) {

        }
    }

}
