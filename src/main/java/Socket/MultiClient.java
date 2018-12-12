package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *多用户客户端
 */
public class MultiClient extends Client{

    public MultiClient() throws IOException {
        super();
    }

    public void launch(){
        Thread thread_send=new Thread(new Send());
        Thread thread_receive=new Thread(new Receive());
        thread_send.start();
        thread_receive.start();
    }

    private class Send implements Runnable{
        BufferedReader reader;
        public Send(){
            reader=new BufferedReader(new InputStreamReader(System.in));
        }
        //每一次发出请求都是线程
        public void run() {
            while(true){
                try {
                    sendMsgToServer();
                } catch (IOException e) {
                    CloseUtil.closeAll(reader);
                    e.printStackTrace();
                }
            }

        }

        private String receiveMsgFromConsole() throws IOException {
            return reader.readLine();
        }

        private void sendMsgToServer() throws IOException{
            convertToSocket(receiveMsgFromConsole());
        }
    }

    private class Receive implements Runnable{

        public void run() {
            try {
                receiveFromServer();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void receiveFromServer() throws IOException, ClassNotFoundException {
            convertSocket();
        }
    }
}
