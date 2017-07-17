package com.digitalnomad.opensource.udpserver;

import java.net.SocketException;

public class LaunchServer{
    public static void main(String[] args) throws SocketException, InterruptedException{
        EchoServer echoServer = new EchoServer();
        echoServer.start();
    }
}