package aps.main.view.components;

import aps.main.model.chat.MessageModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatComponent extends JPanel {
    private int y =0;

    //variaveis de teste
   private  List<MessageModel> listaDeMessagens = new ArrayList<>();
    //fim
    public ChatComponent(){
        this.setLayout(null);
        this.setSize(400,800);
        loadComponent();
        this.setVisible(true);

    }

    private void loadComponent(){
       listaDeMessagens.forEach(message ->{
           filterMessage(message);
       } );
    }

    public List<MessageModel> getMessagem(){
        return this.listaDeMessagens;
    }

    public void sendMessagem(String content){
        MessageModel message = new MessageModel();
        message.setContent(content);
        message.setSendedAt(LocalDateTime.now());
        message.setDirection(true);
        this.listaDeMessagens.add(message);

        System.out.println(this.listaDeMessagens.size());

    }



    public JLabel filterMessage(MessageModel message){
        JLabel component = new JLabel(message.content());
        //if message direction == true is inBound
        if(message.direction()){
            component.setBounds(300, y,300,100);
        }else{
            component.setBounds(0, y,300,100);
        }
        this.y = y + 11;
        return component;
    }


}
