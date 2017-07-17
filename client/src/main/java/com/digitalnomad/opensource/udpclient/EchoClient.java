package com.digitalnomad.opensource.udpclient;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.DatagramPacket;

public class EchoClient {
    private DatagramSocket socket;

    private InetAddress address;
 
    private byte[] buf;
 
    public EchoClient() throws SocketException, UnknownHostException{
        socket = new DatagramSocket();
        address = InetAddress.getByName("127.0.0.1");
    }
 
    public String sendEcho(String msg) {

        try {
            buf = msg.getBytes();
            DatagramPacket packet 
            = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(
            packet.getData(), 0, packet.getLength());
            return received;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
 
    public void close() {
        socket.close();
    }
}