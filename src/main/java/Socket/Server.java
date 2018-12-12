package Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket socket;
    Object obj;
    public Server() throws IOException {
        //创建服务器
        serverSocket=new ServerSocket(8888);
        //接收客户端连接【阻塞式】
        socket=serverSocket.accept();
    }

    public void convertSocket() throws IOException, ClassNotFoundException {
        ObjectInputStream stream=new ObjectInputStream(socket.getInputStream());
        obj=stream.readObject();
        System.out.println(obj);
    }

    public void convertToSocket(Object obj) throws IOException {
        ObjectOutputStream stream=new ObjectOutputStream(socket.getOutputStream());
        stream.writeObject(obj);
    }

}
