package be.multimedi.jdbc;

import java.sql.*;

public class StartApp {
    public static void main(String[] args) {
        String getBeerInfoQuery = "select Name, Alcohol, Price from Beers";
        String updateStockQuery = "update Beers Set Price = 2.8 where Name = 'Jupiler'";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mariadb://noelvaes.eu/javaeewondelgemDB",
                        "javaeewondelgem",
                        "java€€wond€lg€m2019"
                );
                Statement statement = connection.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                );
        ) {

            int result = statement.executeUpdate(updateStockQuery);
            System.out.println(result);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public String getBeerNameById(int i) {
        String getBeerByIdQuery = "select * from Beers where Id = 1;";

        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mariadb://noelvaes.eu/javaeewondelgemDB",
                        "javaeewondelgem",
                        "java€€wond€lg€m2019"
                );
                Statement statement = connection.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                );
        ) {

            ResultSet result = statement.executeQuery(getBeerByIdQuery);
            result.next();
            return result.getString("Name");

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new RuntimeException(sqle);
        }
    }
}
