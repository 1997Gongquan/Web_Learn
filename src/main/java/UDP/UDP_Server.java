package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDP_Server {
    DatagramSocket socket;
    DatagramPacket packet;
    byte[] container;

    public UDP_Server() throws SocketException {
        socket=new DatagramSocket(8888);
        container=new byte[1024];
        packet=new DatagramPacket(container,container.length);
    }


    public void receiveFrClient() throws IOException {
        while(true){
            socket.receive(packet);
            container=packet.getData();
            System.out.println("服务器接收数据："+new String(container,0,container.length));
        }
    }

//    void sendToClient(){
//        while(true){
//
//        }
//    }
}
