package org.example.Model;
import java.util.Objects;

public class Product {
    public long id;
    public double price;
    public String sellerName;
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
    public Product(String productName, Double price, String sellerName) {
        this.productName = productName;
        this.price = price;
        this.sellerName = sellerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && Objects.equals(sellerName, product.sellerName) && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, sellerName, productName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", sellerName='" + sellerName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}

