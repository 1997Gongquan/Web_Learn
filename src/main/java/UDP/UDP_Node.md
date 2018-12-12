# <center> UDP通信

    非面向连接，服务器并没有打开。客户端依旧会发送出数据，造成数据丢失
    当传输对象时，需要自定义对象-->byte的转换方法
* 一、类DatagramSocket、Datagrampacket
    * 1、客户端：
        * 1）、创建客户端，DatagramSocket类
        * 2）、准备数据、字节数组
        * 3）、打包DatagramPacket +服务器地址及端口
        * 4）、发送、释放资源
    * 2、服务端
        * 1）、创建服务器 DatagramSocket 类+指定端口
        * 2）、准备容器接收字节数据，封装 DatagramPacket
        * 3) 、接收数据
        * 4）、分析、释放资源·
