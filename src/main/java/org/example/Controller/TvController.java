package org.example.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import org.example.Exception.TelevisionException;
import org.example.Model.Manufacturer;
import org.example.Model.Television;
import org.example.Service.ManufacturerService;
import org.example.Service.TelevisionService;

import java.util.List;
public class TvController {
    ManufacturerService manufacturerService;
    TelevisionService televisionService;

    public TvController(ManufacturerService manufacturerService, TelevisionService televisionService){
        this.manufacturerService = manufacturerService;
        this.televisionService = televisionService;
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
        api.get("television", context -> {
            List<Television> televisionList = televisionService.getTelevisionList();
            context.json(televisionList);
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
        api.post("television", context -> {
            try{
                ObjectMapper om = new ObjectMapper();
                Television t = om.readValue(context.body(), Television.class);
                Television newTelevision = televisionService.addTelevision(t);
                context.status(201);
                context.json(newTelevision);
            }catch(JsonProcessingException e){
                context.status(400);
            }catch(TelevisionException e){
                context.result(e.getMessage());
                context.status(400);
            }
        });
        /**
         * case 1: the television id is found
         *  - respond with the television JSON status 200
         *  case 2: the television is not found
         *  - respond with no body status 404
         */
        api.get("television/{id}", context -> {
            long id = Long.parseLong(context.pathParam("id"));
            Television t = televisionService.getTelevisionById(id);
            if(t == null){
                context.status(404);
            }else{
                context.json(t);
                context.status(200);
            }
        });

        api.delete("deletetelevision/{id}", context ->{
            long id = Long.parseLong(context.pathParam("id"));
            Television t = televisionService.getTelevisionById(id);
            televisionService.removeTelevisionById(id);
                context.status(200);


    });
        return api;
    }

    }


