package org.example.Model;
import java.util.Objects;

public class Product {
    public long id;
    public double price;
    public String manufacturerName;
    public String productName;

    public String getProductName() {
        return productName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product(){

    }
    public Product(String productName, Double price, String manufacturerName) {
        this.productName = productName;
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
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && Objects.equals(manufacturerName, product.manufacturerName) && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, manufacturerName, productName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}

