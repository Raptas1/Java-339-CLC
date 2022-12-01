package com.gcu.business;

import java.util.List;

import com.gcu.model.ListingModel;

public interface ListingServiceInterface {
    public List<ListingModel> getListings(Long user_Id);
    public List<ListingModel> getActiveListings(Long user_Id);
    public boolean createListing(ListingModel listingModel);
    
    public int editListing(ListingModel listingModel);
    public int deleteListing(ListingModel listingModel);
    
    public int buyListing(ListingModel listingModel);
}
