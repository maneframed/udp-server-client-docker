package com.digitalnomad.opensource.udpclient;

import java.net.SocketException;
import java.net.UnknownHostException;

public class LaunchClient{
    public static void main(String[] args) throws SocketException, UnknownHostException, InterruptedException {
        EchoClient echoClient = new EchoClient();
        while(true) {
            echoClient.sendEcho("test test");
            Thread.sleep(2000);
        }
        
    }
}