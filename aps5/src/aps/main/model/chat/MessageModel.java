package aps.main.model.chat;


import java.time.LocalDateTime;
import java.util.Objects;
public class MessageModel {

    private int id;
    private String from;
    private String to;
    private String content;
    private LocalDateTime sendAt;

    public int id() {
        return id;
    }

    public MessageModel setId(int id) {
        this.id = id;
        return this;
    }

    public String from() {
        return from;
    }

    public MessageModel setFrom(String from) {
        this.from = from;
        return this;
    }

    public String to() {
        return to;
    }

    public MessageModel setTo(String to) {
        this.to = to;
        return this;
    }

    public String content() {
        return content;
    }

    public MessageModel setContent(String content) {
        this.content = content;
        return this;
    }

    public LocalDateTime sendAt() {
        return sendAt;
    }

    public MessageModel setSendAt(LocalDateTime sendAt) {
        this.sendAt = sendAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageModel)) return false;
        MessageModel that = (MessageModel) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setSendedAt(LocalDateTime now) {
        this.sendAt = now;
    }


    public boolean direction(String email) {
    return Objects.equals(this.from, email);
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                ", sendAt=" + sendAt +
                '}';
    }
}
