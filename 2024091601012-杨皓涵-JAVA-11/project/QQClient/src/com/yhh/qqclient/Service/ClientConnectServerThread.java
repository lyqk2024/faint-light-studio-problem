package com.yhh.qqclient.Service;

import com.yhh.qqcommon.Message;
import com.yhh.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Arrays;

public class ClientConnectServerThread extends Thread {

    // 该线程需要持有Socket
    private Socket socket;

    @Override
    public void run() {
        //因为Thread需要在后台和服务器通信，因此我们while循环
        while (true) {

            try {
                System.out.println("客户端，等待读取从服务器端发来的消息...");
                ObjectInputStream ois = new ObjectInputStream(
                        socket.getInputStream());
                // 如果服务器没有发送Message对象，线程会阻塞在这里
                Message message = (Message) ois.readObject();
                // 接受到Message对象，根据不同的数据类型执行不同的代码逻辑
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINEUSER)) {
                    String[] OnlineUser = message.getContent().split(" ");
                    System.out.print("======当前在线用户列表======");
                    for (String s : OnlineUser) {
                        System.out.println(s);
                        //Arrays.stream(OnlineUser).forEach(System.out::println);
                    }
/// 跟着写的项目
                }

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
}
