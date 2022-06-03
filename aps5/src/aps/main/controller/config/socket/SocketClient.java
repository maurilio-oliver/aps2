package aps.main.controller.config.socket;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SocketClient extends Thread{
    private static Socket client;
    private ObjectInputStream objInput;
    private ObjectOutputStream objeOut;
    private Scanner scan;
    public SocketClient(){

    }

    public void connect(Socket client){
        this.client=client;
    }

    public void connect(String host, int port){
        try {
            this.client = new Socket(host, port);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Object readObject(){
        try {
            this.objInput = new ObjectInputStream(this.client.getInputStream());
            return objInput.readObject();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void writeObject(Object obj){
        try {
            this.objeOut = new ObjectOutputStream(this.client.getOutputStream());
            this.objeOut.writeObject(obj);
            this.objeOut.flush();
            this.objeOut.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    Socket getClient(){
        return this.client;
    }

    public Socket createServer(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        try {
                this.client = server.accept();
            return this.client;
        }catch (Exception e){
            return null;
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var socket = new SocketClient();

        JFrame frame = new JFrame();
        JButton send = new JButton("send");
        frame.setSize(800,800);

        send.addActionListener(l->{
            new Thread(() -> {
                var client = new SocketClient();
                client.connect("localhost", 12345);
                System.out.println( client.readObject());
                send.setText(""+Math.random());
                frame.doLayout();

                try {
                    client.getClient().close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }).run();
        }

        );
        frame.add(send);
        frame.setVisible(true);
        //thread server
        new Thread(() ->{
            try {
                while (true) {
                    ServerSocket server = new ServerSocket(12345);
                    socket.connect(server.accept());
                    Map<String, String> test = new HashMap<>();
                    test.put("maurilio", "user");
                    socket.writeObject(test);

                    socket.client.close();
                    server.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

}
