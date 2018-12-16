package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 *用于接收数据的线程
 */
public class TCP_Receive_Runable implements Runnable{
    private ObjectInputStream inputStreamFrClient;
    private boolean isRunning=true;
    TCP_Receive_Runable(Socket socket) throws IOException {
        inputStreamFrClient=new ObjectInputStream(socket.getInputStream());
    }

    public Object readMsg(){
        Object obj=null;
        try {
            obj=inputStreamFrClient.readObject();
        } catch (IOException e) {
            TCP_CloseUtil.closeAll(inputStreamFrClient);
            isRunning=false;
        } catch (ClassNotFoundException e) {
            TCP_CloseUtil.closeAll(inputStreamFrClient);
            isRunning=false;
        }
        return obj;
    }

    public void run() {
        while(isRunning){
            System.out.println(readMsg());
        }
    }
}
