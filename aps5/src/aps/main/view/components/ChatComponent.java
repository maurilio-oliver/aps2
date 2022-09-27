package aps.main.view.components;

import aps.main.controller.service.MessageService;
import aps.main.model.chat.MessageModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ChatComponent extends JPanel {
    private int y =0;
    private String from;
    private String to;
    private List<MessageModel> messageList = new ArrayList<>();
    private MessageService service = new MessageService();


    public ChatComponent(String from, String to){
        this.setPath(from, to);
        this.loadList();

        this.setLayout(null);
        this.setSize(400,800);

        loadComponent();
        this.setVisible(true);

    }

    public void setPath(String from, String to){
        this.from = from;
        this.to = to;
    }

    public void loadList(){
        this.messageList = service.getMessagens(this.from, this.to);
    }


    private void loadComponent(){
      this.messageList.forEach(message ->{
           this.add(filterMessage(message));
       } );
    }



    public JLabel filterMessage(MessageModel message){
        JLabel component = new JLabel(message.content());
        //if message direction == true is inBound
        if(message.direction(this.from)){
            component.setBounds(300, y,300,100);
        }else{
            component.setBounds(0, y,300,100);
        }
        this.y = y + 11;
        this.revalidate();
        System.out.println(message.from());
        this.repaint();
        return component;
    }


}
