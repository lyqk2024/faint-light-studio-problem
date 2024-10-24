package com.yhh.qqserver.service;

import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ManageServerConnectClientThread {

    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    // 添加线程对象到 hm 集合
    public static void addManageServerConnectClientThread
                (String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);

    }

    // 根据userId 返回ServerConnectClientThread 线程
    public static ServerConnectClientThread getManageServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    public static String getOnlineUser() {
        String onlineUser = "";
        for (String s : hm.keySet()) {
            onlineUser += s + " ";
        }
        return onlineUser;
    }

}
