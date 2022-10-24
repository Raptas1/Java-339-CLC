package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ListingModel {
	
	@NotNull(message="Name is a required field")
    @Size(min=1, max=25, message="Name has to be in range of 1 to 25 characters")
	private String name;

	@NotNull(message="Description is a required field")
    @Size(min=1, max=100, message="Description has to be in range of 1 to 10 characters")
	private String description;

	@Min(value=1, message="0 is not a suitable number")
	private int category;

	@Min(value=1, message="0 is not a suitable number")
	private int price;

	@Min(value = 0, message="Cannot accept a negative copy")
	private int copy;
	
	public ListingModel(String name, String description, int category, int price)
	{
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
	}
	public ListingModel()
	{

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCopy()
	{
		return copy;
	}
	public void setCopy(int copy)
	{
		this.copy = copy;
	}
	public List<ListingModel> generateListings(ListingModel listingModel)
	{
		List<ListingModel> listings = new ArrayList<ListingModel>();
		for (int i = 0; i < listingModel.copy; i++)
		{
			listings.add(new ListingModel(listingModel.name, listingModel.description, listingModel.category, listingModel.price));
		}	
		return listings;
	}
	

}
