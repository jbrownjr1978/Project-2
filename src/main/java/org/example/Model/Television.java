package org.example.Model;
import java.util.Objects;

public class Television {
    public long id;
    public double price;
    public String manufacturerName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Television(){

    }
    public Television(Double price, String manufacturerName) {
        this.price = price;
        this.manufacturerName = manufacturerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television television = (Television) o;
        return Objects.equals(price, television.price) && Objects.equals(manufacturerName, television.manufacturerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, manufacturerName);
    }

    @Override
    public String toString() {
        return "Television{" +
                "title='" + price + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                '}';
    }
}
}
