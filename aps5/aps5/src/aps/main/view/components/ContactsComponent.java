package aps.main.view.components;

import aps.main.model.user.enuns.UserModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDateTime;
import java.util.List;

public class ContactsComponent extends JPanel {
    private String content;
    int i =0;


    public ContactsComponent(){
        this.setLayout(null);
       this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void contactsModal(UserModel contactName){
        this.content = contactName.name();
        JButton contactModal =new JButton(contactName.name());
        contactModal.setLayout(null);
        contactModal.addActionListener(l->{
            this.onClickContact();
        });
        contactModal.setBounds(0,i,400,80);
        this.i = i + 80;
        this.add(contactModal);

    }


    public void onClickContact(){
        System.out.println(this.content);
    }




}
