import TCP.TCP_Client;
import UDP.UDP_Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;

public class Clinet {
    //从控制台读取数据
    BufferedReader readFrConsole;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        launch_UDP_Client();
        launch_TCP_Client();
    }

    static void launch_UDP_Client() throws IOException {
        UDP_Client client=new UDP_Client();
        client.sendToServer();
    }
    static void launch_TCP_Client() throws IOException, ClassNotFoundException {
        TCP_Client client=new TCP_Client();
        client.launch();
    }
}
