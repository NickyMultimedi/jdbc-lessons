package be.multimedi.jdbc.brewers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrewerDaoImplTest {
    BrewerDao brewerDao = new BrewerDaoImpl();
    Brewer brewer = new Brewer();

    {
        brewer.setId(1);
        brewer.setName("Achouffe");
        brewer.setAddress("Route du Village 32");
        brewer.setZipCode("6666");
        brewer.setCity("Achouffe-Wibrin");
        brewer.setTurnover(10_000);
    }

    @Test
    void getBrewerById() {
        assertEquals(this.brewer, brewerDao.getBrewerById(1));
    }

    @Test
    void updateBrewer() {
        Brewer brewer = brewerDao.getBrewerById(2);
        brewer.setTurnover(10_001);
        brewerDao.updateBrewer(brewer);
        assertEquals(brewer,brewerDao.getBrewerById(2));
    }

    @Test
    void getBeersBrewedByBrewer() {

        assertEquals(0,1);
    }
}