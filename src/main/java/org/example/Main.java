package org.example;

import io.javalin.Javalin;
import org.example.Controller.TvController;
import org.example.Service.ManufacturerService;
import org.example.Service.ProductService;

public class Main {
    public static void main(String[] args) {
        //        instantiate & inject all dependencies of our project

        ManufacturerService manufacturerService = new ManufacturerService();
        ProductService televisionService = new ProductService(manufacturerService);
        TvController tvController = new TvController(manufacturerService, televisionService);

        Javalin api = tvController.getAPI();
        api.start(9007);
    }
}