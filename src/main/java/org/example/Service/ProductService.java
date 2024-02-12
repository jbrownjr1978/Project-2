package org.example.Service;

import org.example.Exception.TelevisionException;
import org.example.Model.Television;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TelevisionService {
    ManufacturerService manufacturerService;
    List<Television> televisionList;

    public TelevisionService(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
        televisionList = new ArrayList<>();
    }

    public List<Television> getTelevisionList() {
        return televisionList;
    }

    public Television addTelevision(Television t) throws TelevisionException {
        if (t.getPrice() <= 0 || t.getManufacturerName() == null) {
            throw new TelevisionException("price and manufacturer fields must not be empty");

        }

        long id = (long) (Math.random() * Long.MAX_VALUE);
        t.setId(id);
        televisionList.add(t);
        return t;

    }

        public Television getTelevisionById (long id){
                for (int i = 0; i < televisionList.size(); i++) {
                Television currentTelevision = televisionList.get(i);
                if (currentTelevision.getId() == id) {
                    return currentTelevision;
                }
            }
            return null;
        }

        public Television removeTelevisionById (Long id){
            for (int i = 0; i < televisionList.size(); i++) {
                Television currentTelevision = televisionList.get(i);
                if (currentTelevision == televisionList.get(i)) {
                    televisionList.remove(i);
                    System.out.println("Television has been removed");
                    ;
                }

            }
            return null;

        }
    }


