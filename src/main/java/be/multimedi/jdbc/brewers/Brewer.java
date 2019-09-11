package be.multimedi.jdbc.brewers;

import be.multimedi.jdbc.beers.Beer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Brewer implements Serializable {
    private int id;
    private String name;
    private String address;
    private String zipCode;
    private String city;
    private int turnover;
    private List<Beer> beers = new ArrayList<>();

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brewer brewer = (Brewer) o;
        return getTurnover() == brewer.getTurnover() &&
                Objects.equals(getName(), brewer.getName()) &&
                Objects.equals(getAddress(), brewer.getAddress()) &&
                Objects.equals(getZipCode(), brewer.getZipCode()) &&
                Objects.equals(getCity(), brewer.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), getZipCode(), getCity(), getTurnover());
    }

    @Override
    public String toString() {
        return "Brewer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", turnover=" + turnover +
                '}';
    }
}
