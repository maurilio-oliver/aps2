package aps.test;

import aps.test.service.UserServiceTest;

import java.sql.SQLException;

public class ApsTestApplication {
    private static UserServiceTest serviceTest = new UserServiceTest();
    public static void main(String[] args) throws SQLException {
      serviceTest.test();
    }
}
