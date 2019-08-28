package be.multimedi.jdbc;

import be.multimedi.jdbc.wrappers.DriverManagerWrapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StartApp {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManagerWrapper.getConnection()
        ) {

            System.out.println("Connection A-OK");

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
