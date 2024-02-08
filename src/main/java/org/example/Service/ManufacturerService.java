package org.example.Service;

import org.example.Main;
import org.example.Model.Manufacturer;

import java.util.ArrayList;

import java.util.List;


public class ManufacturerService {
    List<Manufacturer> manufacturerList;

    public ManufacturerService(){
        this.manufacturerList = new ArrayList<>();
    }

    public List<Manufacturer> getManufacturerList(){
        return manufacturerList;
    }

    public void addManufacturer(Manufacturer m){
        manufacturerList.add(m);
    }

}
