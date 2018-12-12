package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 *服务端
 */
public class Server {

    DatagramSocket socket;

    byte[] container;
    byte[] data;
    Object obj;
    public Server(int port) throws SocketException {
        //创建服务器并指定端口8888
        socket=new DatagramSocket(port);
        //准备容器
        container=new byte[1024];
    }

    public void loadServer() throws IOException, ClassNotFoundException {
        //将容器和服务器打包
        DatagramPacket packet=new DatagramPacket(container,container.length);

        //接收数据【阻塞式】
        socket.receive(packet);
        data=packet.getData();
        convertToObject();
        //分析数据
    }

    private void convertToObject() throws IOException, ClassNotFoundException {
        ByteArrayInputStream streamBos=new ByteArrayInputStream(data);
        ObjectInputStream streamDos=new ObjectInputStream(streamBos);

        obj=streamDos.readObject();
        System.out.println(obj.toString());
        socket.close();
    }
}
