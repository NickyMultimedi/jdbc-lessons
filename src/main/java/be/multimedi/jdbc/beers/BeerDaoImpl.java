package be.multimedi.jdbc.beers;

import be.multimedi.jdbc.wrappers.JdbcFacade;

import java.sql.*;

public class BeerDaoImpl implements BeerDao {
    static final String BEER_BY_ID = "SELECT * FROM Beers WHERE Id = ?";
    static final String UPDATE_BEER = "UPDATE Beers SET Name = ?, Price = ?, Alcohol = ?, Stock = ? WHERE ID = ?";

    private String url;
    private String user;
    private String password;
    private JdbcFacade connection;

    public BeerDaoImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        connection = JdbcFacade.createJdbcFacade();
    }

    public BeerDaoImpl() {
        connection = JdbcFacade.createJdbcFacade();
    }

    @Override
    public Beer getBeerById(int id) throws BeerException {

        try (PreparedStatement prepared = connection.createPreparedStatement(BEER_BY_ID);) {
            prepared.setInt(1, id);

            try (ResultSet result = prepared.executeQuery()) {

                return fillBeerObject(result);

            }

        } catch (SQLException sqle) {
            throw new BeerException(sqle);
        }
    }

    private Beer fillBeerObject(ResultSet result) throws SQLException, BeerException {
        if (result.next()) {
            Beer beer = new Beer();
            beer.setId(result.getInt("Id"));
            beer.setName(result.getString("Name"));
            beer.setPrice(result.getFloat("Price"));
            beer.setAlcohol(result.getFloat("Alcohol"));
            beer.setStock(result.getInt("Stock"));
            return beer;
        } else {
            throw new BeerException("There was no entity with this Primary Key");
        }
    }

    @Override
    public void updateBeer(Beer beer) throws BeerException {


        try (PreparedStatement prepared = connection.createPreparedStatement(UPDATE_BEER);) {
            prepared.setString(1, beer.getName());
            prepared.setFloat(2, beer.getPrice());
            prepared.setFloat(3, beer.getAlcohol());
            prepared.setInt(4, beer.getStock());
            prepared.setInt(5, beer.getId());

            prepared.executeUpdate();

        } catch (SQLException sqle) {
            throw new BeerException(sqle);
        }
    }
}
