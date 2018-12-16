package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Client {
    Socket client;
    public TCP_Client() throws IOException {
        client=new Socket("localhost",8888);
    }

    public void launch() throws IOException, ClassNotFoundException {
//        receiveFrServer();
        String name=getName();
        new Thread(new TCP_Send_Runable(client,name)).start();
        new Thread(new TCP_Receive_Runable(client)).start();
    }

    private String getName(){
        System.out.println("请输入名称：");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String name=null;
        try {
            name=br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    public void receiveFrServer() throws IOException, ClassNotFoundException {
        Object msg=null;
        ObjectInputStream in=new ObjectInputStream(client.getInputStream());
        //阻塞式
        msg=in.readObject();
        System.out.println("客户端接收数据："+msg);
    }
}
