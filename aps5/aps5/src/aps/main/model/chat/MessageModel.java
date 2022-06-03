package aps.main.model.chat;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;

import static aps.main.model.chat.enuns.MessageState.*;

public class MessageModel {


    private Long id;
    private String username;
    private String content;
    private MessageState state;
    private LocalDateTime sendedAt;
    private LocalDateTime receivedAt;
    private LocalDateTime cancellatedAt;
    private LocalDateTime deletedAt;
    private LocalDateTime viewedAt;

    private boolean direction;

    public Long id() {
        return id;
    }

    public MessageModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String username() {
        return username;
    }

    public MessageModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String content() {
        return content;
    }

    public MessageModel setContent(String content) {
        this.content = content;
        return this;
    }

    public MessageState state() {
        return state;
    }

    public MessageModel setState(MessageState state) {
        this.state = state;
        return this;
    }

    public LocalDateTime sendedAt() {
        return sendedAt;
    }

    public MessageModel setSendedAt(LocalDateTime sendedAt) {
        this.sendedAt = sendedAt;
        return this;
    }

    public LocalDateTime receivedAt() {
        return receivedAt;
    }

    public MessageModel setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
        return this;
    }

    public LocalDateTime cancellatedAt() {
        return cancellatedAt;
    }

    public MessageModel setCancellatedAt(LocalDateTime cancellatedAt) {
        this.cancellatedAt = cancellatedAt;
        return this;
    }

    public LocalDateTime deletedAt() {
        return deletedAt;
    }

    public MessageModel setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    public LocalDateTime viewedAt() {
        return viewedAt;
    }

    public MessageModel setViewedAt(LocalDateTime viewedAt) {
        this.viewedAt = viewedAt;
        return this;
    }

    public boolean direction() {
        return direction;
    }

    public MessageModel setDirection(boolean direction) {
        this.direction = direction;
        return this;
    }

    //process state
    public void procesState(){
       MessageState state = this.state;

       //se enviada
            if (this.sendedAt != null){
                state = SENDED;
            }
            // serecebido
            else if(this.receivedAt != null){
                state = RECEIVED;
            }
            // se visualizado
            else if(this.viewedAt != null){
                state = VIEWED;
            } else if(this.cancellatedAt != null){
                state = CANCELLED;
            }else if(this.deletedAt != null){
                state = DELETED;
            }
        }

        public void prosseMessagem(){
            procesState();
        }
}
