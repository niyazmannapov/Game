package sockets;

import component.Player;

import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket clientSocket;
    private Player player;

    public ClientHandler(Socket socket){
        this.player = new Player();
    }

}
