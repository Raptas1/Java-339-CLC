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
    public List<ListingModel> getListings(Long user_Id) {
     // return the list of listings
        return service.findByUser_Id(user_Id);    
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

	@Override
	public int findProcessor(ListingModel listingModel) {
		String processorName = listingModel.getName().toLowerCase();
		
		String[] arrayProcessor = processorName.split(" ");
		
		for(String processor : arrayProcessor) {
			if(processor.equals("intel")) {
				return 0;
			} else if(processor.equals("amd")) {
				return 1;
			}
		}
		return 2;
	}
    
}
