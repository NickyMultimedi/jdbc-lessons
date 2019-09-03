package be.multimedi.jdbc;

import be.multimedi.jdbc.wrappers.DriverManagerWrapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StartAppTest {
    private static Connection con;

@BeforeAll
    public static void mainInit() {
    con = DriverManagerWrapper.getConnection();
}

@AfterAll
    public static void mainDestroy() throws SQLException {
    DriverManagerWrapper.closeConnection();
}
}