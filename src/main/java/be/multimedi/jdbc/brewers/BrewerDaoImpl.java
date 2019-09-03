package be.multimedi.jdbc.brewers;

import be.multimedi.jdbc.beers.Beer;
import be.multimedi.jdbc.wrappers.JdbcFacade;

import java.sql.PreparedStatement;
import java.util.List;

public class BrewerDaoImpl implements BrewerDao {
    static final String BREWER_BY_ID = "select * from Brewers where Id = ?";
    JdbcFacade connect;

    BrewerDaoImpl() {
        connect = JdbcFacade.createJdbcFacade();
    }

    @Override
    public Brewer getBrewerById(int id) {
        PreparedStatement prepared = connect.createPreparedStatement(BREWER_BY_ID);



        return null;
    }

    @Override
    public void updateBrewer(Brewer brewer) {

    }

    @Override
    public List<Beer> getBeersBrewedByBrewer(Brewer brewer) {
        return null;
    }
}
