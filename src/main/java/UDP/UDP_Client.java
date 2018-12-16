package UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDP_Client {
    DatagramSocket socket;
    DatagramPacket packet;
    BufferedReader reader;

    byte[] data;
    public UDP_Client() throws SocketException {
        socket=new DatagramSocket();
        data=new byte[1024];
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    public void sendToServer() throws IOException {
        while (true){
            String msg=reader.readLine();
            data=msg.getBytes();
            packet=new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
            socket.send(packet);
            System.out.println("客户端发送数据："+msg);
        }
    }
}
