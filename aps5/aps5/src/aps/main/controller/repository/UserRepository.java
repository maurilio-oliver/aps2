package aps.main.controller.repository;

import aps.main.controller.config.db.ConnectionDb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    ConnectionDb db = new ConnectionDb();

    public void findById(Long id) throws SQLException {
       String action = "select * from ta where id = {p1} "
               .replace("{p1}",id.toString());

       ResultSet response = db.query(action);

    }
    public void findByPhone(){}
    public void findByNumber(){}
    public void create(){}
    public void delete(){}
    public void update(){}
    public void findAllBy(){}

}
