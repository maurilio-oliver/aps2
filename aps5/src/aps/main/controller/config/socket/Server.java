package aps.main.controller.config.socket;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Server extends Thread {

    private static ArrayList<OutputStream> clientes;
    static ServerSocket serverSocket;
    private String name;
    private Socket client;
    private ObjectInputStream objectInputStream;
    private Scanner scan;

    public void createServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
        }catch (Exception e){

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        while (true){
            server.createServer(12345);
            Socket client = Server.serverSocket.accept();
            System.out.println(client.getInputStream());
        }
    }
}