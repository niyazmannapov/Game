package programs;

import sockets.GameServer;

public class ProgramGameServer {
    public static void main(String[] args) {
        GameServer gameServer = new GameServer();
        gameServer.start(1234);
    }

}
