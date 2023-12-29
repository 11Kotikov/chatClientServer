package org.homework.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        System.out.println("chat server");
        try {
            ServerSocket serverSocket = new ServerSocket(1400);
            Server server = new Server(serverSocket);
            server.startServer();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Error: UnknownHostException");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Output/Input exc");
            System.exit(1);
        }
    }
}