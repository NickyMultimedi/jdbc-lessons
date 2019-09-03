package be.multimedi.jdbc.beers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeerDaoImplTest {
    BeerDaoImpl beerDao = new BeerDaoImpl();
    Beer beer = new Beer();

    {
        beer.setId(7);
        beer.setName("Aardbeien witbier");
        beer.setAlcohol(2);
        beer.setPrice(2.24f);
        beer.setStock(150);
    }

    @Test
    void getBeerById() {
        Beer beer = beerDao.getBeerById(7);
        assertEquals(this.beer, beer);
    }

    @Test
    void getBeerByIdThrowsBeerException() {
        assertThrows(
                BeerException.class,
                () -> beerDao.getBeerById(0)
        );
    }

    @Test
    void updateBeer() {
        Beer beer = beerDao.getBeerById(8);
        beer.setStock(150);
        beerDao.updateBeer(beer);
        assertEquals(beer, beerDao.getBeerById(8));
    }
}