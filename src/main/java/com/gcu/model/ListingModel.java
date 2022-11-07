package com.gcu.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ListingModel {
	
    private Long id;
    
	@NotNull(message="Name is a required field")
    @Size(min=1, max=25, message="Name has to be in range of 1 to 25 characters")
	private String name;

	@NotNull(message="Description is a required field")
    @Size(min=1, max=100, message="Description has to be in range of 1 to 10 characters")
	private String description;

	@Min(value=1, message="0 is not a suitable number")
	private int category;

	@Min(value=1, message="0 is not a suitable number")
	private float price;
	
	public ListingModel(Long id, String name, String description, int category, float price)
	{
	    this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
	}
	public ListingModel()
	{

	}
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
