package TCP;

import java.io.*;
import java.net.Socket;

/*
 *用于发送数据的线程
 */
public class TCP_Send_Runable implements Runnable{

    private BufferedReader reader;
    private ObjectOutputStream outPutStreamFrClient;
    private boolean isRunning=true;
    private String name;
    TCP_Send_Runable() throws IOException {
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    TCP_Send_Runable(Socket socket,String name) throws IOException {
        this();
        outPutStreamFrClient=new ObjectOutputStream(socket.getOutputStream());
        this.name=name;
        sendMsg(name);
    }

    private Object readMsgFrConsole(){
        try {
            return name+":"+reader.readLine();
        } catch (IOException e) {
            TCP_CloseUtil.closeAll(reader,outPutStreamFrClient);
            isRunning=false;

        }
        return "";
    }

    private void sendMsg(Object obj){
        try {
            outPutStreamFrClient.writeObject(obj);
        } catch (IOException e) {
            TCP_CloseUtil.closeAll(reader,outPutStreamFrClient);
            isRunning=false;
        }
    }
    public void run() {
        while(isRunning){
            //阻塞式读取
            Object obj=readMsgFrConsole();
            if(obj!=null){
                sendMsg(obj);
            }
        }
    }
}
