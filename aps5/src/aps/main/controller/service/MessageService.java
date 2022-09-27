package aps.main.controller.service;

import aps.main.model.chat.MessageModel;
import aps.main.controller.repository.MessageRepository;
import aps.main.model.user.UserModel;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageService {
    MessageRepository repository = new MessageRepository();
    public void send(String content, String from, String to)  {

        MessageModel sms = new MessageModel();

        sms.setId(this.getMessagens(from, to).size() + 1);
        sms.setContent(content);
        sms.setTo(to);
        sms.setFrom(from);
        sms.setSendAt(LocalDateTime.now());

        try{
            repository.create(sms);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public List<MessageModel> getMessagens(String from, String to){
        System.out.println("getMessans");
        try {
        return this.repository.getFromTo(from, to);
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "lula 22");
            return new ArrayList<>();
        }
    }

}
