package aps.main.view;

import aps.main.model.user.enuns.UserModel;
import aps.main.view.components.ChatComponent;
import aps.main.view.components.ContactsComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsView extends JFrame {
    ScrollPane scrollContacts = new ScrollPane();
    ScrollPane scrollPaneChat = new ScrollPane();


//configuraçoes da janela
ContactsView(){
    this.setLayout(null);
    this.setSize(800,800);

    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setTitle("aps V");
    this.loadComponents();
    this.setVisible(true);
}
//variaveis para teste todo: apagaet ate o comentario end
List<UserModel> users = new ArrayList<>();
UserModel usermodelo = new UserModel();
    UserModel usermodelo2 = new UserModel();
    int y=0;
    //end

void loadComponents(){
    this.loadContactsComponent();
    this.loadChatComponent();

    this.add(scrollPaneChat);
    this.add(scrollContacts);

}

void loadContactsComponent(){
    //janela de contatos
    ContactsComponent contacts = new ContactsComponent();
    usermodelo.setEmail("maurilio@gmail.com");
    usermodelo.setId(1L);
    usermodelo.setPassword("59323387");
    usermodelo.setName("maurilio");
    users.add(usermodelo);
    usermodelo2.setName("teste 2");
    users.add(usermodelo2);
    this.scrollContacts.setSize((this.getWidth()/2), this.getHeight()-50);

    users.forEach(contact ->{
        contacts.contactsModal(contact);
        System.out.println(users.size());
    });

    this.scrollContacts.add(contacts);

}
private void loadFrameComponents(){
   // this.scrollContacts.setSize((this.getWidth()/2), this.getHeight()-50);

}
private void loadChatComponent(){
    this.scrollPaneChat.setBounds(400,0,400,800);
    ChatComponent chat = new ChatComponent();
    JButton send = new JButton("enviar");
    send.setBounds(690,720,100,40);
    send.addActionListener(l->{
        chat.sendMessagem("envia");
        //chat.add(new JLabel("click"));
this.scrollPaneChat.revalidate();


    });
    this.add(send);

    this.scrollPaneChat.add(chat);
    this.add(scrollPaneChat);
}



}
