package be.multimedi.jdbc.wrappers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class JdbcFacadeTest {
    static final String PREPARED_QUERY = "select * from table where Id = ?";

    JdbcFacade connect = JdbcFacade.createJdbcFacade();

    @Test
    void isSingletonCreated() {
        assertNotNull(connect);
    }

    @Test
    void isJdbcOpen() {
        assertFalse(connect.isClosed());
    }

    @Test
    void isSingletonUnique() {
        assertSame(connect, JdbcFacade.createJdbcFacade());
    }

    @Test
    void isConnectionOpened() throws SQLException {
        assertFalse(connect.getConnection().isClosed());
    }

    @Test
    void isConnectionUnique() {
        assertSame(connect.getConnection(), connect.getConnection());
    }

    @Test
    void isStatementOpened() throws SQLException {

        assertFalse(connect.createStatement().isClosed());
    }

    @Test
    void getStatement() throws SQLException {
        Statement statement = connect.createStatement();
        assertSame(connect.getStatement(),statement);
    }

    @Test
    void isPreparedStatementOpened() throws SQLException {
        assertFalse(connect.createPreparedStatement(PREPARED_QUERY).isClosed());
    }

    @Test
    void isFacadeClosed() {
        connect.close();
        assertTrue(connect.isClosed());
    }

    @Test
    void isFacadeAutoClosed() {
        connect.close();
        connect = null;
        try (JdbcFacade con = JdbcFacade.createJdbcFacade()) {
            connect = con;
        }

        assertTrue(connect.isClosed());

    }

}