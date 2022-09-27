package aps.main.view.components;

import javax.swing.*;
import java.awt.*;

public class ContactsComponent extends JPanel {
    TextField textArea = new TextField();
    int i =0;

    public ContactsComponent(){
        this.textArea.setBounds(this.getWidth()/2,700, this.getWidth()/2, 50);
        this.add(textArea);
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void contactsModal(Runnable function, String contactName){
            JButton contactModal = new JButton(contactName);
            contactModal.setLayout(null);
            contactModal.addActionListener(l -> {
               function.run();
            });
        contactModal.setBounds(0, i,400,80);
        this.i = i + 80;
        this.add(contactModal);

    }


}
