package com.yhh.qqclient.Service;

import com.yhh.qqcommon.Message;
import com.yhh.qqcommon.MessageType;
import com.yhh.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class UserClientService {

    // 因为我们可能在其它地方用到user信息，所以作出成员变量
    private User u = new User();
    // 因为Socket在其它地方也可以用到，所以也作为~
    private Socket socket;

    // 传输 userId 和 passwd 到服务器检验
    public boolean checkUser(String userId, String passwd) throws IOException, ClassNotFoundException {

        boolean b = false;

        // 创建use对象
        u.setUserId(userId);
        u.setPasswd(passwd);

        // 将user对象发送到服务器

        socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
        // 创建新的对象流
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(u);
        oos.flush();

        // 读取从服务器发回来的Message对象
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message message = (Message) ois.readObject();

        if (message.getMesType().equals("1")) { // 登录成功

            // 创建一个和服务器保持通信的线程 -> 即创建一个类Client~~~的对象
            ClientConnectServerThread clientConnectServerThread =
                    new ClientConnectServerThread(socket);
            // 启动线程
            clientConnectServerThread.start();
            //为了方便以后服务器的拓展，将线程加入到集合
            ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
            b = true;

        } else { // 如果登录失败，不会创建线程和集合，关闭socket
            socket.close();
        }
        return b;
    }

    public void onlineFriendList () {


        try {
            // 发送一个 Message 对象，其 MesType 为 4
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_GET_ONLINEUSER);
            message.setSender(u.getUserId());
            message.setGetter("服务器");
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
