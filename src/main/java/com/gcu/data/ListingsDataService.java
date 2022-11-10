package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import com.gcu.model.ListingModel;
import com.gcu.model.UserModel;

@Service
public class ListingsDataService implements ListingsAccessInterface<ListingModel>{
    
    @SuppressWarnings("unused")
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    @Autowired
    UserModel userModel;
    
    /**
     * Non-Default constructor for constructor injection.
     * @param dataSource dataSource
     */
    public ListingsDataService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    @Override
    /**
     * Finds every listing in the database
     */
    public List<ListingModel> findAll() {
        String sql = "SELECT * FROM LISTINGS";
        List<ListingModel> listings = new ArrayList<ListingModel>();
        try
        {
            // Execute SQL Query and loop over result set
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while(srs.next())
            {
                listings.add(new ListingModel(srs.getLong("ID"),
                        srs.getString("NAME"),
                        srs.getString("DESCRIPTION"),
                        srs.getInt("CATEGORY"),
                        srs.getFloat("PRICE"),
                        srs.getLong("USER_ID")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return listings;
    }

    @Override
    /**
     * find listing by ID
     */
    public ListingModel findById(int id) {
        return null;
    }

    @Override
    /**
     * create listing and add to Database
     */
    public boolean create(ListingModel listing) {
        String sql = "INSERT INTO LISTINGS(NAME, DESCRIPTION, CATEGORY, PRICE, USER_ID) VALUES(?, ?, ?, ?, ?)";
        try
        {
        	listing.setUser_id(userModel.getId());
            // Execute SQL Insert
            int rows = jdbcTemplateObject.update(sql, 
                    listing.getName(),
                    listing.getDescription(),
                    listing.getCategory(),
                    listing.getPrice(),
            		listing.getUser_id());
            // Return result of Insert
            return rows == 1 ? true: false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * update the listings
     */
    public boolean update(ListingModel listing) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    /**
     * delete the listings
     */
    public boolean delete(ListingModel listing) {
        // TODO Auto-generated method stub
        return true;
    }

	@Override
	/**
	 * Find the listings by UserID
	 */
	public List<ListingModel> findByUser_Id(Long id) {
		String sql = String.format("SELECT * FROM LISTINGS WHERE USER_ID = %d", userModel.getId());
		 List<ListingModel> listings = new ArrayList<ListingModel>();
	        try
	        {
	            // Execute SQL Query and loop over result set
	            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
	            while(srs.next())
	            {
	                listings.add(new ListingModel(srs.getLong("ID"),
	                        srs.getString("NAME"),
	                        srs.getString("DESCRIPTION"),
	                        srs.getInt("CATEGORY"),
	                        srs.getFloat("PRICE"),
	                        srs.getLong("USER_ID")));
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        return listings;
	}

   

}
