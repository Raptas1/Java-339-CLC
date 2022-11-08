package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ListingsAccessInterface;
import com.gcu.model.ListingModel;

@Service
public class ListingService implements ListingServiceInterface{

    @Autowired
    ListingsAccessInterface<ListingModel> service;
    
    @Override
    /**
     * Return the list of listings
     */
    public List<ListingModel> getListings() {
     // return the list of listings
        return service.findAll();    
    }

    @Override
    /**
     * Create a listing
     */
    public boolean createListing(ListingModel listingModel) {
        // create a listing
        service.create(listingModel);
        return true;
    }
    
}
