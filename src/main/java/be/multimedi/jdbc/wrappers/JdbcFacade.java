package be.multimedi.jdbc.wrappers;

import java.io.Closeable;
import java.sql.*;
import java.util.Objects;

public class JdbcFacade implements Closeable, AutoCloseable {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private static JdbcFacade facade;

    private JdbcFacade() {
        connection = getConnection();
        statement = createStatement();

    }

    public static JdbcFacade createJdbcFacade() {
        if (facade != null) {
            return facade;
        } else {
            facade = new JdbcFacade();

            return facade;
        }
    }

    public Connection getConnection() {
        if (connection != null) {
            return connection;
        }

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://noelvaes.eu/javaeewondelgemDB",
                    "javaeewondelgem",
                    "java€€wond€lg€m2019"
            );

            return connection;

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public Statement createStatement() {
        try {
            statement = getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }

        return statement;
    }

    public Statement getStatement() {
        if (statement == null) {
            return createStatement();
        }
        return statement;
    }

    public void closeStatement() {
        try {
            statement.close();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public PreparedStatement createPreparedStatement(String sql) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }

        return preparedStatement;
    }

    public void closePreparedStatement() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public void close() {
        closePreparedStatement();
        closeStatement();
        closeConnection();
    }

    public boolean isClosed() {
        try {
            return isPreparedStatementClosed() && isStatementClosed() && isConnectionClosed();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    private boolean isPreparedStatementClosed() throws SQLException {
        if (preparedStatement != null) {
            return preparedStatement.isClosed();
        }
        return true;
    }

    private boolean isStatementClosed() throws SQLException {
        if (statement != null) {
            return statement.isClosed();
        }
        return true;
    }

    private boolean isConnectionClosed() throws SQLException {
        if (connection != null) {
            return connection.isClosed();
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JdbcFacade that = (JdbcFacade) o;
        return getConnection().equals(that.getConnection()) &&
                statement.equals(that.statement) &&
                Objects.equals(preparedStatement, that.preparedStatement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConnection(), statement, preparedStatement);
    }
}
