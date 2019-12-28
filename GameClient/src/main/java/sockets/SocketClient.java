package sockets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import component.Food;
import component.GameCircle;
import component.GameMap;
import dto.CircleDto;
import dto.CircleMoveDto;
import dto.FoodDto;
import dto.MapInfoDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;


public class SocketClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            new Thread(receiverMessagesTask).start();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void sendMessage(CircleMoveDto message) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        out.println(gson.toJson(message));
    }

    private Runnable receiverMessagesTask = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {

                    String response = in.readLine();
                    if (response != null) {
                        GameMap.clear();
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        MapInfoDto gameMap = gson.fromJson(response, MapInfoDto.class);
                        GameMap gm = GameMap.getInstance();
                        for (FoodDto food : gameMap.getFoodArrayList()) {
                            gm.addFood(new Food(food.getPositionX(), food.getPositionY()));
                        }
                        for (CircleDto circleDto : gameMap.getCircleDtoArrayList()) {
                            gm.addGameCircle(new GameCircle(circleDto.getPositionX(), circleDto.getPositionY(), circleDto.getRadius(), new Random().nextLong()));
                        }
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    };

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
