package be.multimedi.jdbc.beers;

import java.io.Serializable;
import java.util.Objects;

public class Beer implements Serializable {
    private int id;
    private String name;
    private float price;
    private int stock;
    private float alcohol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", alcohol=" + alcohol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return getId() == beer.getId() &&
                Float.compare(beer.getPrice(), getPrice()) == 0 &&
                getStock() == beer.getStock() &&
                Float.compare(beer.getAlcohol(), getAlcohol()) == 0 &&
                Objects.equals(getName(), beer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getStock(), getAlcohol());
    }
}
