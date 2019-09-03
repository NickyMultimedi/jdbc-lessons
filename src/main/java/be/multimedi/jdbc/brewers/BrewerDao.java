package be.multimedi.jdbc.brewers;

import be.multimedi.jdbc.beers.Beer;

import java.util.List;

public interface BrewerDao {
    Brewer getBrewerById(int id);
    void updateBrewer(Brewer brewer);
    List<Beer> getBeersBrewedByBrewer(Brewer brewer);
}
