package aps.main.controller.repository;

import aps.main.controller.config.db.ConnectionDb;
import aps.main.model.chat.MessageModel;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageRepository {
    public static List<MessageModel> MESSAGEREPOSYTORY = new ArrayList();
    private ConnectionDb repository = new ConnectionDb();
    private PreparedStatement prepare;
    private ResultSet result;

    public List<MessageModel> getFromTo(String userEmail, String contactEmail) throws SQLException {
        String query = "select * from messages where " +
                "(\"from\" = ? and \"to\" = ?) " +
                "or (\"from\" = ? and \"to\" = ?)  ;";
        List<MessageModel> smsList = new ArrayList();

        this.prepare = this.repository.getPrepareStatement(query);
        this.prepare.setString(1, userEmail);
        this.prepare.setString(2, contactEmail);
        this.prepare.setString(4, userEmail);
        this.prepare.setString(3, contactEmail);

        this.result = this.prepare.executeQuery();



        while (result.next()){
            MessageModel message = new MessageModel();
               message.setId(result.getInt(1));
               message.setFrom(result.getString(2));
               message.setTo(result.getString(3));
               message.setContent(result.getString(4));
               message.setSendAt(result.getTimestamp("sendat").toLocalDateTime());
               smsList.add(message);
        }
        prepare.close();
        result.close();
        repository.close();
        return smsList;
    }


    public void create(MessageModel message) throws SQLException {
        String query = "INSERT INTO public.messages\n" +
                "(\"from\", \"to\", \"content\", sendat)" +
                "VALUES(?,?,?,?)";
        this.prepare = this.repository.getPrepareStatement(query);
        prepare.setString(1, message.from());
        prepare.setString(2, message.to());
        prepare.setString(3 ,message.content());
        prepare.setTimestamp(4, Timestamp.valueOf(message.sendAt()));

        prepare.executeQuery();

        prepare.close();
        repository.close();
    }


    public static void main(String[] args) throws SQLException {
        MessageRepository m = new MessageRepository();
//        MessageModel ms = new MessageModel();
//        ms.setFrom("fluxo@teste.com");
//        ms.setTo("fluxo1@teste.com");
//        ms.setContent("basico");
//        ms.setSendAt(LocalDateTime.now());

       // m.create(ms);
        System.out.println(m.getFromTo("fluxo@teste.com", "fluxo1@teste.com"));



    }
}
