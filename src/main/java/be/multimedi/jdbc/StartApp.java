package be.multimedi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class StartApp {
    public static void main(String[] args) {
        try (
                Connection con = DriverManager.getConnection(
                        "jdbc:mariadb://noelvaes.eu/javaeewondelgemDB",
                        "javaeewondelgem",
                        "java€€wond€lg€m2019"
                )
            ) {
            System.out.println("Connection OK");
        } catch (Exception e) {
            System.out.println("Oeps, Something went wrong!");
            e.printStackTrace();
        }
    }
}
