package sockets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.security.ntlm.Client;
import component.Food;
import component.GameCircle;
import component.GameMap;
import dto.CircleMoveDto;
import dto.MapInfoDto;
import javafx.scene.shape.Circle;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameServer {
    private List<ClientHandler> players;
    private GameMap gameMap;

    public GameServer() {
        players = new CopyOnWriteArrayList<>();
        gameMap = GameMap.getInstance();
    }

    public void start(int port) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        new Thread(new Runnable() {
            Random random = new Random();

            @Override
            public void run() {
                while (true) {
                    gameMap.addFood(new Food(random.nextInt(900), random.nextInt(1600)));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        while (true) {
            try {
                new ClientHandler(serverSocket.accept()).start();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }


    @Data
    @NoArgsConstructor
    public class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private GameCircle circle;
        private PrintWriter pw;


        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            players.add(this);
            Random random = new Random();
            circle = new GameCircle(random.nextInt(900), random.nextInt(1600));
            gameMap.addGameCircle(circle);
            Thread circleThread = new Thread(circle);
            circleThread.start();
        }

        @Override
        public void run() {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            try {
                // получем входной поток для конкретного клиента
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    pw.println(gson.toJson(MapInfoDto.from(gameMap)));
                    CircleMoveDto dto = gson.fromJson(inputLine, CircleMoveDto.class);
                    circle.update(dto.getElapsedTime(), dto.getVelocityX(), dto.getVelocityY());
                }
                in.close();
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
