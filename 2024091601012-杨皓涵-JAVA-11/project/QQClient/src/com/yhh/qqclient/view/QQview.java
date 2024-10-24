package com.yhh.qqclient.view;

import com.yhh.qqclient.Service.ClientConnectServerThread;
import com.yhh.qqclient.Service.ManageClientConnectServerThread;
import com.yhh.qqclient.Service.UserClientService;
import com.yhh.qqclient.utils.Utility;

import java.io.IOException;

public class QQview {

    private boolean loop = true; //控制是否显示菜单
    private String key = ""; //接受用户的键盘输入
    private UserClientService userClientService = new UserClientService();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new QQview().mainMenu();

    }

    // 显示主菜单
    public void mainMenu() throws IOException, ClassNotFoundException {

        while(loop) {

            System.out.println("=========欢迎登录信息通讯系统=========");
            System.out.println("\t\t 1 登陆系统");
            System.out.println("\t\t 9 退出系统");

            // 接受用户的选择
            System.out.println("输入你的选择...");
            key = Utility.readString(1);

            // 根据用户的选择来处理不同的逻辑
            switch (key) {
                case "1" :
                    System.out.println("请输入你的用户名：");
                    String userId = Utility.readString(30);
                    System.out.println("输入你的密码：");
                    String passwd = Utility.readString(30);

                    if (userClientService.checkUser(userId,passwd)) {
                        System.out.println("======身份准入！登陆成功( 用户 " + userId + " )======");
                        //
                        //ManageClientConnectServerThread.getClientConnectServerThread(userId).run();

                        while (true){
                            System.out.println("======网络信息通讯二级系统=======");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");

                            System.out.println("请输入你的选择：");
                            String key2 = Utility.readString(1);

                            switch (key2) {
                                case "1" :
                                    userClientService.onlineFriendList();
                                    //ManageClientConnectServerThread.getClientConnectServerThread(userId).run();

                                    //System.out.println("在线用户列表：");
                                    break;
                                case "2" :
                                    System.out.println("群发消息：");
                                    break;
                                case "3" :
                                    System.out.println("私聊消息：");
                                    break;
                                case "4" :
                                    System.out.println("发送文件");
                                    break;
                                case "9" :
                                    System.out.println("退出二级系统...");
                                    loop = false;
                                    break;

                            }

                        }
                    } else {  // 登录服务器失败
                        System.out.println("登录失败！");
                    }
                    break;
                case "9" :
                    System.out.println("退出系统...");
                    loop = false;
                    break;
            }


        }
    }
}
