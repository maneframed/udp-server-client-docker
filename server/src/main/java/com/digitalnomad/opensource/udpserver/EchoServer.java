package com.digitalnomad.opensource.udpserver;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class EchoServer extends Thread {
 
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];
 
    public EchoServer() throws SocketException{
        socket = new DatagramSocket(4445);
    }
 
    public void run() {
        running = true;
        try {
            while (running) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                String received 
                = new String(packet.getData(), 0, packet.getLength());
                System.out.println(received);
                if (received.equals("end")) {
                    running = false;
                    continue;
                }
                socket.send(packet);
             }
        } catch (IOException e) {
            System.out.println(e);
        }

        socket.close();
    }
}