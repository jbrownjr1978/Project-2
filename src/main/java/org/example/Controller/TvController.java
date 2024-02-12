package org.example.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import org.example.Exception.ProductException;
import org.example.Model.Manufacturer;
import org.example.Model.Product;
import org.example.Service.ManufacturerService;
import org.example.Service.ProductService;

import java.util.List;
public class TvController {
    ManufacturerService manufacturerService;
    ProductService productService;

    public TvController(ManufacturerService manufacturerService, ProductService productService){
        this.manufacturerService = manufacturerService;
        this.productService = productService;
    }
/*using method to create and configure Javalin api.
Define endpoints to a specific HTTp verb
Every endpoint will contain a URI (Uniform Resource Identifier)
 */
    public Javalin getAPI(){
        Javalin api = Javalin.create();

        api.get("health", context -> {context.result("Server is UP");});
//        a get for both manufacturer and television
//        a post for both manufacturer and television
//        I'll showcase an endpoint that requires usage of both the manufacturer and television service
//        I'll showcase exception handling within the controller
//        Test case/logging
        api.get("manufacturer", context -> {
            List<Manufacturer> manufacturerList = manufacturerService.getManufacturerList();
            context.json(manufacturerList);
        });
        api.get("product", context -> {
            List<Product> productList = productService.getProductList();
            context.json(productList);
        });
        api.post("manufacturer", context -> {
            try{
                ObjectMapper om = new ObjectMapper();
                Manufacturer m = om.readValue(context.body(), Manufacturer.class);
                manufacturerService.addManufacturer(m);
                context.status(201);
            }catch(JsonProcessingException e){
                context.status(400);
            }
        });
        api.post("product", context -> {
            try{
                ObjectMapper om = new ObjectMapper();
                Product p = om.readValue(context.body(), Product.class);
                Product newProduct = productService.addProduct(p);
                context.status(201);
                context.json(newProduct);
            }catch(JsonProcessingException e){
                context.status(400);
            }catch(ProductException e){
                context.result(e.getMessage());
                context.status(400);
            }
        });
        /**
         * case 1: the product id is found
         *  - respond with the product JSON status 200
         *  case 2: the product is not found
         *  - respond with no body status 404
         */
        api.get("product/{id}", context -> {
            long id = Long.parseLong(context.pathParam("id"));
            Product p = productService.getProductById(id);
            if(p == null){
                context.status(404);
            }else{
                context.json(p);
                context.status(200);
            }
        });

        api.delete("deleteproduct/{id}", context ->{
            long id = Long.parseLong(context.pathParam("id"));
            Product p = productService.getProductById(id);
            productService.removeProductById(id);
                context.status(200);


    });
        return api;
    }

    }


