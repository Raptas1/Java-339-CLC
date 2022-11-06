package com.gcu.business;

import java.util.List;

import com.gcu.model.ListingModel;

public interface ListingServiceInterface {
    public List<ListingModel> getListings();
    public boolean createListing(ListingModel listingModel);
}
