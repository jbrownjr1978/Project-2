package org.example.Service;

import org.example.Exception.SellerException;

import org.example.Model.Seller;


import java.util.ArrayList;

import java.util.List;


public class SellerService {
    List<Seller> sellerList;

    public SellerService() {
        this.sellerList = new ArrayList<>();
    }

    public List<Seller> getSellerList() {
        return sellerList;
    }

    public Seller addSeller(Seller s) throws SellerException {
        if (s.getName() == null) {
            throw new SellerException("Seller cannot be null");
        }
        for (int i = 0; i < sellerList.size(); i++) {
            Seller currentSeller = sellerList.get(i);
            if (currentSeller.equals(s)) {
                throw new SellerException("Seller already exists");

            }

        }sellerList.add(s);
        return s;


    }
}

