import Socket.Server;

import java.io.IOException;
import java.net.SocketException;

public class MainServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server=new Server();
//        server.convertToSocket("asdasd");
        server.convertSocket();
    }
}
