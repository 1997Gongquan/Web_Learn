package TCP;

import java.io.Closeable;
import java.io.IOException;

/*
 *关闭数据流
 */
public class TCP_CloseUtil {
    public static void closeAll(Closeable... io){
        for(Closeable temp:io){
            while(temp!=null){
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
