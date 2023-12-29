package org.homework.chat.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put chat username here: ");
        String name = scanner.nextLine();

        try {
            InetAddress localhostAddress = InetAddress.getLocalHost();
            Socket socket = new Socket(localhostAddress, 1400);
            Client client = new Client(socket, name);

            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: " + inetAddress);
            String remoteIp = inetAddress.getHostAddress();
            System.out.println("Remote IP: " + remoteIp);
            System.out.println("LocalPort:" + socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();
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