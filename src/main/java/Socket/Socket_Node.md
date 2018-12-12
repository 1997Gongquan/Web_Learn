# <center> Socket（管道）通信

    基于tcp协议，面向连接，安全可靠但效率较低
    客户端为输入端，服务器端就为输出端\服务器端为输出端，客户端就为输入端。
    即相当于一个管道将服务器端和客户端连接起来，共用一个管道
    一个客户端可以同时连接多个管道

* 一、面向连接：【请求----响应 | request---response】
* 二、Socket编程
    * 1、服务端\服务端
        * 1)、创建服务器\客户端，指定端口 ServerSocket(int port)\Socket(host,port)
        * 2)、接收客户端连接（阻塞式）
        * 3)、发送数据\接收数据
    * 2、多用户数据传输
        * 1)、为每一个用户创建一个线程