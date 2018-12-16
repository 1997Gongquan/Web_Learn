package TCP;

import sun.rmi.transport.tcp.TCPChannel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TCP_Server {
    HashMap<String,TCP_Server_Channel> map;
    ServerSocket server;
    Socket socket;
    String name;
    public TCP_Server() throws IOException {
        server=new ServerSocket(8888);
        socket=new Socket();
        map=new HashMap<String, TCP_Server_Channel>();
    }

    public void launch() throws IOException {
        while(true){
            //服务器阻塞式等待建立连接
            socket=server.accept();
            TCP_Server_Channel channel=new TCP_Server_Channel(socket);
            map.put(name,channel);
            System.out.println("客户端"+name+"连接成功");
            new Thread(channel).start();
        }


//        new Thread(new TCP_Send_Runable(socket)).start();
//        new Thread(new TCP_Receive_Runable(socket)).start();


//        sendToClient();

    }
    public void sendToClient() throws IOException {
        Object obj="Test";
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(obj);
        System.out.println("服务端发送数据："+obj);
    }

    public void receiveFrClient() throws IOException {

    }

    class TCP_Server_Channel implements Runnable{
        private ObjectInputStream inputStream;
        private ObjectOutputStream outputStream;
        private boolean isRunning=true;
        TCP_Server_Channel(Socket socket) throws IOException {
            inputStream=new ObjectInputStream(socket.getInputStream());
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            name=(String)readFrClient();
        }

        private Object readFrClient(){
            Object obj=null;
            try {
                obj=inputStream.readObject();
            } catch (IOException e) {
                map.remove(name);
                isRunning=false;
            } catch (ClassNotFoundException e) {
                map.remove(name);
                isRunning=false;
            }
            return obj;
        }

        private void sendToOthers(Object obj){
            try {
                outputStream.writeObject(obj);
            } catch (IOException e) {
                map.remove(name);
                isRunning=false;
            }
        }


        public void run() {
            while(isRunning){
                Object obj=readFrClient();
                System.out.println("接收到"+name+"的数据："+obj);
                if(obj!=null){
                    for(String v:map.keySet())
                    {
                        map.get(v).sendToOthers(obj);
                    }
                }

            }
        }
    }

}
