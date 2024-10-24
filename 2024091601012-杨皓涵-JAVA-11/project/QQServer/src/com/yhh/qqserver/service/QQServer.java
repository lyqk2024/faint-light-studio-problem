package com.yhh.qqserver.service;

import com.yhh.qqcommon.Message;
import com.yhh.qqcommon.MessageType;
import com.yhh.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class QQServer {

    // 注意：端口可以写在配置文件中
    ServerSocket ss = new ServerSocket(9999);
    // 创造一个集合用来存放多个用户，如果是这些用户登录，确认时是合法
    private static HashMap<String, User> validUsers = new HashMap<>();

    static { // 在静态代码块，初始化 validUsers
        validUsers.put("qq", new User("qq", "qq"));
        validUsers.put("lyqk114514", new User("lyqk114514", "123456"));
        validUsers.put("lyqk3", new User("lyqk3", "qwert"));
        validUsers.put("lyqk2024", new User("lyqk2024", "12345"));
    }

    private boolean checkUser(String userId, String passwd) {

        // 采用过关的验证方式
        if (validUsers.get(userId) == null) { // 说明UserId没有存在validUsers 的key中
            return false;
        }
        if (!passwd.equals(validUsers.get(userId).getPasswd())) { //UserId正确，但是密码错误
            return false;
        }
        return true;
    }

    public QQServer() throws IOException, ClassNotFoundException {

        try {
            while (true) { // 当和某个客户端连接后，会持续监听 9999 端口，所以while
                Socket socket = ss.accept(); // 没有客户端连接时，服务器阻塞在这里

                // 得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(
                        socket.getInputStream());

                // 得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(
                        socket.getOutputStream());

                // 接受客户端传来的User对象
                User u = (User) ois.readObject();

                // 创建一个Message对象，准备回复客户端
                Message message = new Message();

                // 验证用户是否可以登入
                if (checkUser(u.getUserId(), u.getPasswd())) { // 登陆成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    // 将message对象回复给客户端
                    oos.writeObject(message);
                    // 创建一个线程，和客户端保持通信，该类需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, u.getUserId());
                    // 启动该线程
                    serverConnectClientThread.start();
                    // 把该线程对象放入一个集合中进行管理
                    ManageServerConnectClientThread.addManageServerConnectClientThread
                            (u.getUserId(), serverConnectClientThread);
                    // 显示登陆成功信息
                    System.out.println("[userId = " + u.getUserId() + "] 登陆成功！");
                    //serverConnectClientThread.run();

                } else { // 登陆失败
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    // 显示登录失败信息
                    System.out.println("[userId = " + u.getUserId() +
                            "   passwd = " + u.getPasswd() + "] 登陆失败！");
                    // 关闭socket
                    socket.close();
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 如果服务器推出了循环，说明服务器端口不在监听，因此关闭ServerSocket
            ss.close();
        }

    }

}
