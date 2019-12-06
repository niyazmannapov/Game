package sockets;

import component.Player;
import lombok.Data;

import java.io.InputStream;
import java.net.Socket;

@Data
public class ClientHandler extends Thread {
    private Socket clientSocket;
    private Player player;
    private InputStream is;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        this.player = new Player();
    }

    @Override
    public void run() {

    }
}
