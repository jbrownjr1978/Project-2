package org.example.Service;

import org.example.Exception.ProductException;
import org.example.Model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    ManufacturerService manufacturerService;
    List<Product>productList;

    public ProductService(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product addProduct(Product p) throws ProductException {
        if (p.getPrice() <= 0 || p.getProductName() == null || p.getManufacturerName() == null){
            throw new ProductException("price, manufacturerName, and productName fields must not be empty");

        }

        long id = (long) (Math.random() * Long.MAX_VALUE);
        p.setId(id);
        productList.add(p);
        return p;

    }

        public Product getProductById (long id){
                for (int i = 0; i < productList.size(); i++) {
                Product currentProduct = productList.get(i);
                if (currentProduct.getId() == id) {
                    return currentProduct;
                }
            }
            return null;
        }

        public Product removeProductById (Long id){
            for (int i = 0; i < productList.size(); i++) {
                Product currentProduct = productList.get(i);
                if (currentProduct == productList.get(i)) {
                    productList.remove(i);
                    System.out.println("Product has been removed");
                    ;
                }

            }
            return null;

        }
    }


