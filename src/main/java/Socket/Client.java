package Socket;

import java.io.*;
import java.net.Socket;

public class Client {
    Socket socket;
    Object obj;
    public Client() throws IOException {
        //创建客户端
        socket=new Socket("localHost",8888);
    }

    public void convertSocket() throws IOException, ClassNotFoundException {
        ObjectInputStream stream=new ObjectInputStream(socket.getInputStream());
        obj=stream.readObject();
        System.out.println("用户"+Thread.currentThread().getName()+"收到数据："+obj);
//        stream.close();
    }

    public void convertToSocket(Object obj) throws IOException {
        ObjectOutputStream stream=new ObjectOutputStream(socket.getOutputStream());
        stream.writeObject(obj);
        System.out.println("用户"+Thread.currentThread().getName()+"发出数据："+obj);
//        stream.close();
    }

}
