package com.yhh.qqcommon;

public interface MessageType {

    // 表示成功登录
    public static final String MESSAGE_LOGIN_SUCCEED = "1";
    // 表示登录失败
    public static final String MESSAGE_LOGIN_FAIL = "2";
    // 普通信息包
    public static final String MESSAGE_COMM_MES = "3";
    // 客户端请求获取在线用户列表
    public static final String MESSAGE_GET_ONLINEUSER = "4";
    // 服务器传回在线用户列表
    public static final String MESSAGE_RET_ONLINEUSER = "5";
    // 客户端请求退出
    public static final String MESSAGE_CLIENT_EXIT = "6";
}
