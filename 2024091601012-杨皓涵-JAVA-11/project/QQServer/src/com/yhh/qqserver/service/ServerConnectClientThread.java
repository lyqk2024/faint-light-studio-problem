package com.yhh.qqserver.service;

import com.yhh.qqcommon.Message;
import com.yhh.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// 该类的一个对象和某个客户端保持通信
public class ServerConnectClientThread extends Thread {

     private Socket socket;
     private String userId; //连接到服务器的用户id

     public ServerConnectClientThread(Socket socket, String userId) {
         this.socket = socket;
         this.userId = userId;
     }

     @Override
    public void run() {
         while (true) {
             try {
                 System.out.println("服务器和客户端保持通信，读取数据...");
                 ObjectInputStream ois =
                         new ObjectInputStream(socket.getInputStream());
                 Message message = (Message) ois.readObject();
                 // message 在后续功能中使用...
                 if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINEUSER)) {
                 // 客户端请求获取在线用户列表

                     // 返回格式： 123 茄子 3277
                     System.out.println( userId + " 请求获取在线用户列表"); // 打印日志信息
                     // 调用获取在线用户方法
                     String onlineUser = ManageServerConnectClientThread.getOnlineUser();
                     // 再创建一个Message对象并返回
                     Message message1 = new Message();
                     message1.setMesType(MessageType.MESSAGE_RET_ONLINEUSER); // 设置 MesType
                     message1.setContent(onlineUser); // 将在线用户列表传入 Message 对象的内容
                     message1.setSender("服务器");
                     message1.setGetter(userId);

                     ObjectOutputStream oos = new ObjectOutputStream(
                             socket.getOutputStream());
                     oos.writeObject(message1);


                 }
             } catch (IOException | ClassNotFoundException e) {
                 throw new RuntimeException(e);
             }
         }
     }
}
