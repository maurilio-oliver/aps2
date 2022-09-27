package aps.main.controller.repository;

import aps.main.controller.config.db.ConnectionDb;
import aps.main.model.user.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private ConnectionDb repository = new ConnectionDb();
    public static List<UserModel> USERREPOSITORY = new ArrayList();


    public UserModel getByID(Long id) throws SQLException {
    String query = "select * from users where id = ? ";

        PreparedStatement result = repository.getPrepareStatement(query);
        result.setInt(1, id.intValue());

       return select(result.executeQuery());
    }

    public UserModel getByEmail(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email LIKE ?";
        PreparedStatement statement = this.repository.getPrepareStatement(query);
        statement.setString(1, email);
        return this.select(statement.executeQuery());
    }

    public void create(UserModel user) throws SQLException {
    String query =  " INSERT INTO users " +
            "(\"name\", email, \"password\", org, charge, createat, deletedat) " +
            "VALUES(?,?, ?, ?, ?, ?, ?, ?, ?)";

    PreparedStatement statement = repository.getPrepareStatement(query);
    statement.setString(1, user.name());
        statement.setString(2, user.email());
        statement.setString(3, user.password());
        statement.setString(4,user.org());
        statement.setString(5,null);
        statement.setDate(6,null);
        statement.setDate(7,null);
        statement.setString(8,user.contacts().toString()
                .replace("[","")
                .replace("]",""));


        statement.executeUpdate();
        repository.close();
    }

    public void deleteById(final Long id) throws SQLException {
        PreparedStatement result = repository.getPrepareStatement("DELETE FROM users WHERE id = ?");
        result.setInt(1,id.intValue());
        result.executeUpdate();
        result.close();
    }

    private UserModel select(ResultSet result) throws SQLException {
        UserModel obj = new UserModel();
        while (result.next()){

            obj.setId(result.getLong("id"));
            obj.setName(result.getString("name"));
            obj.setPassword(result.getString("password"));
            obj.setEmail(result.getString("email"));
            obj.setPermission(null);
            obj.setCreateAt(null);
            obj.setDeletedAt(null);
            obj.setOrg(result.getString("org"));
            obj.setContacts(
                    Arrays.stream(result.getString("contacts").split(",")).toList());

            USERREPOSITORY.add(obj);

        }
        result.close();
        return obj;
    }

}
