import TCP.TCP_Server;
import UDP.UDP_Client;
import UDP.UDP_Server;

import java.io.IOException;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
//        launch_UDP_Server();
        launch_TCP_Server();
    }


    static void launch_UDP_Server() throws IOException {
        UDP_Server server=new UDP_Server();
        server.receiveFrClient();
    }

    static void launch_TCP_Server() throws IOException {
        TCP_Server server=new TCP_Server();
        server.launch();
    }

}
