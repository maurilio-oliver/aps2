package aps.main.view;

import aps.main.controller.config.socket.SocketClient;
import aps.main.controller.service.ArchService;
import aps.main.controller.service.MessageService;
import aps.main.controller.service.UserService;
import aps.main.model.archiv.ArchiverModel;
import aps.main.model.user.UserModel;
import aps.main.view.components.ChatComponent;
import aps.main.view.components.ContactsComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ContactsView extends JFrame {

    ScrollPane scrollContacts = new ScrollPane();
    ScrollPane scrollPaneChat = new ScrollPane();
    ContactsComponent contacts;
    ChatComponent chatComponent;
    TextArea emailArea;
    private MessageService messageService = new MessageService();
    TextField textArea = new TextField();
    String to;
    UserModel user;
    SocketClient socket =new SocketClient();



//configuraçoes da janela
public ContactsView(UserModel o) throws IOException {
    this.user = o;
    this.setLayout(null);
    this.setSize(800,800);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setTitle("aps V");
    this.loadComponents();
    this.textArea.setBounds(this.getWidth()/2,700, this.getWidth()/2, 50);
    this.add(textArea);
    this.enterKey();
    this.setVisible(true);

}
public void setSession(UserModel user){
    this.user = user;
}

void loadComponents(){
    this.loadContactsComponent();
    this.add(scrollContacts);
}
public ScrollPane scrollPanelChatConfiguration(){
    this.scrollContacts.setSize((this.getWidth()/2), this.getHeight()-50);
    this.scrollPaneChat.setBounds(400,0,400,800);
    return this.scrollPaneChat;

}
void loadContactsComponent(){
    this.contacts = new ContactsComponent();
    this.scrollPanelChatConfiguration();

    //contact modal
    this.user.contacts().forEach(contact ->{
        contacts.contactsModal(() -> {
            this.to = contact;
            this.chatComponent =new ChatComponent(this.user.email(),contact);
            this.chatComponent.setPath(this.user.email(),contact);
            this.scrollPaneChat.add(chatComponent);
            this.add(this.scrollPaneChat);
        },contact);
    });
    this.scrollContacts.add(contacts);
}

    void enterKey(){
        this.textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n' && to != null) {
                    if(textArea.getText().contains("[arquivo]")){
                        ArchService archService = new ArchService();
                        try {

                            Map<String, Object> map = new HashMap<>();
                            map.put("content_type","archv");
                            map.put("arch",archService.getArchive(textArea.getText().replace("[arquivo]","").replace(" ","")));
                            socket.connect("localhost",12345);
                            socket.writeObject(map);


                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    }else {
                        messageService.send(translate(textArea.getText()), user.email(), to);
                        chatComponent = new ChatComponent(user.email(), to);
                        chatComponent.setPath(user.email(), to);
                        scrollPaneChat.remove(chatComponent);
                        scrollPaneChat.add(chatComponent);
                        reload();
                    }
                }
            }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    });
}

    private void reload(){
        scrollPaneChat.revalidate();
        scrollPaneChat.repaint();
        this.chatComponent.revalidate();
        this.chatComponent.repaint();
        this.repaint();
        this.revalidate();
    }

    private String translate(String content){
    return content.replace("::>","\uD83D\uDE00").replace("::<","\uD83D\uDE2D").replace(":<3","❤");
    }
//todo:remover
    public static void main(String[] args) throws SQLException, IOException {
        new Thread(() ->{
            try {
                while (true) {
                    SocketClient socket = new SocketClient();
                    socket.createServer(12345);

                    Map<String, Object> response = (Map<String, Object>) socket.readObject();
                    if (response.get("content_type") == "archv") {
                        ArchiverModel achr =  (ArchiverModel) response.get("archv");
                        achr.setLocalpath("/home/oliver/Downloads/"+achr.name());
                        File file = new File(achr.localpath());
                        file.createNewFile();
                        FileWriter fileWriter = new FileWriter(achr.localpath());
                        fileWriter.write(achr.content());
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
}
