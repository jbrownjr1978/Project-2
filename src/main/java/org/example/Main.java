package org.example;

import io.javalin.Javalin;
import org.example.Controller.TvController;
import org.example.Service.ProductService;
import org.example.Service.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        //        instantiate & inject all dependencies of our project

        SellerService sellerService = new SellerService();
        ProductService productService = new ProductService(sellerService);
        TvController tvController = new TvController(sellerService, productService);

        Javalin api = tvController.getAPI();
        api.start(9007);
    }
}