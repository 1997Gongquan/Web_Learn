package Socket;

import java.io.Closeable;
import java.io.IOException;

/*
 *帮助关闭输入输出流
 */
public class CloseUtil {
    public static void closeAll(Closeable... io){
        for(Closeable temp : io){
            if(null!=temp) {
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
