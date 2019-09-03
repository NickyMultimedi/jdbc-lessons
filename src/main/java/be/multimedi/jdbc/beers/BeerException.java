package be.multimedi.jdbc.beers;

public class BeerException extends RuntimeException {
    public BeerException() {
    }

    public BeerException(String message) {
        super(message);
    }

    public BeerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeerException(Throwable cause) {
        super(cause);
    }
}
