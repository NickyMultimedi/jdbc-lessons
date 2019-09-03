package be.multimedi.jdbc.beers;

public interface BeerDao {
    Beer getBeerById(int id) throws BeerException;
    void updateBeer(Beer beer) throws BeerException;
}
