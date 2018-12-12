package UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/*
 *客户端
 */
public class Client {
    DatagramSocket socket;

    byte[] data;

    public Client() throws IOException {
        socket=new DatagramSocket();
    }

    public void sendPacket(Object obj,int port) throws IOException {
        convertToByte(obj);
        socket.send(new DatagramPacket(data,data.length, new InetSocketAddress("localhost",port)));
        socket.close();
    }

    private void convertToByte(Object obj) throws IOException {
        ByteArrayOutputStream streamDos=new ByteArrayOutputStream();
        ObjectOutputStream streamBos= new ObjectOutputStream(streamDos);
        streamBos.writeObject(obj);
        data=streamDos.toByteArray();
        streamBos.close();
        streamDos.close();

    }
}
