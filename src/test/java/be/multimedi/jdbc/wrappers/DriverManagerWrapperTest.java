package be.multimedi.jdbc.wrappers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DriverManagerWrapperTest {
    private Connection connection;

    @BeforeEach
    public void init() {
        connection = DriverManagerWrapper.getConnection();
    }

    @Test
    public void getConnection() throws SQLException {
        assertNotNull(connection);
        assertFalse(connection.isClosed());
    }

    @Test
    public void closeConnection() throws SQLException {
        DriverManagerWrapper.closeConnection();

        assertTrue(connection.isClosed());
    }

    @AfterEach
    public void destroy() {
        DriverManagerWrapper.closeConnection();
    }
}