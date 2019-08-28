package be.multimedi.jdbc.wrappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerWrapper {
    private static Connection con;

    public static Connection getConnection() {
        if (con != null) {
            return con;
        }

        try {
            con = DriverManager.getConnection(
                    "jdbc:mariadb://noelvaes.eu/javaeewondelgemDB",
                    "javaeewondelgem",
                    "java€€wond€lg€m2019"
            );

            return con;

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

        public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
        }

}
