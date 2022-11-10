package com.gcu.business;

import java.util.List;

import com.gcu.model.ListingModel;

public interface ListingServiceInterface {
    public List<ListingModel> getListings(Long user_Id);
    public boolean createListing(ListingModel listingModel);
    
    public int findProcessor(ListingModel listingModel);
}
