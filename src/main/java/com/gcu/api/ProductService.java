package com.gcu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.data.ListingsDataService;
import com.gcu.model.ListingModel;

@RestController
@RequestMapping("/api")
public class ProductService {
	
	@Autowired
	ListingsDataService service;
	
	@GetMapping("/products")
	public ResponseEntity<?> getProducts() {
		List<ListingModel> listings = service.findAllNF();
		try {
			if(listings == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else 
				return new ResponseEntity<>(listings, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProduct(@PathVariable int id) {
		ListingModel listing = service.findById(id);
		try {
			if(listing == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<>(listing, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
