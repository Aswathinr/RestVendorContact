package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.faith.model.VendorContact;

public class VendorContactDao implements IVendorContactDao {
	
	  
		JdbcTemplate template;
		public void setTemplate(JdbcTemplate template) {
		this.template = template;
		}
		
/*--------------------insert vendor contact -------------------------------------*/
		
		
		@Override
		public int insertVendorContact(VendorContact vendorContact)
		{
			
			
			String sqlOne="insert into Vendor(vName,vAddress,vLocation,vService, "
					+ "pincode,isActive) values('"+
					vendorContact.getvName()+"','"+
					vendorContact.getvAddress()+"','"+
					vendorContact.getvLocation()+"','"+
					vendorContact.getvService()+"',"+
					vendorContact.getPincode()+",'Y') ";
			template.update(sqlOne);
			
			
			Integer maxVId=getMaxOfVendorId();
			System.out.println(maxVId);
			
			String sqlTwo="insert into Contact(cName,department,email,phone,vId) "
					+ "values('"+vendorContact.getcName()+"','"+
					vendorContact.getDepartment()+"','"+
					vendorContact.getEmail()+"','"+
					vendorContact.getPhone()+"',? )";
			return template.update(sqlTwo,new Object[] {maxVId});		
		}
		
		
		private Integer getMaxOfVendorId() {
			
			String sql = "select MAX(vId)from Vendor";
			Integer seq = template.queryForObject(sql, new Object[] {}, Integer.class);
			return seq;
		}

/*--------------------------vendor+contact details---------------------------------*/
		
	   
	    @Override
		public List<VendorContact> getAllDetails()
	    {
	    	return template.query("select v.vId,v.vName,v.vLocation,v.vService,c.cName,"
	    			+ "c.department,c.phone from Vendor v join Contact c"
	    			+ " on(v.vId=c.vId) where isActive='Y' order by v.vId desc",
							new RowMapper<VendorContact>() {
								public VendorContact mapRow(ResultSet rs, int row)
										throws SQLException {
									VendorContact vendorContact = new VendorContact();
									vendorContact.setvId(rs.getInt(1));
									vendorContact.setvName(rs.getString(2));
									vendorContact.setvLocation(rs.getString(3));
									vendorContact.setvService(rs.getString(4));
									vendorContact.setcName(rs.getString(5));
									vendorContact.setDepartment(rs.getString(6));
									vendorContact.setPhone(rs.getString(7));
									return vendorContact;
								}
							});
	    }
	    
	   
	    public VendorContact getVendorById(int vId) {
			String sql = "select v.vId,v.vName,v.vLocation,v.vService,v.vAddress,v.pincode,c.cName,"
	    			+ "c.department,c.phone,c.email from Vendor v join Contact c"
	    			+ " on(v.vId=c.vId) where isActive='Y' and v.vId=?";
			return template.queryForObject(sql, new Object[] {vId},
					new BeanPropertyRowMapper<VendorContact>(VendorContact.class));
		}
	    
/*------------------------------Disable vendor----------------------------------*/
	    
        @Override
		public int disableVendor(int vId) {
			
			String sql = "update Vendor set isActive='no' where vId=?";
			return template.update(sql,new Object[] { vId });
		}

/*--------------------------update vendor + contact-----------------------*/
        
        @Override
		public int updateVendor(VendorContact vendorContact)
        {
        
        	String sqlOne="update Vendor set vName='"+vendorContact.getvName()
        			      +"',vAddress='"+vendorContact.getvAddress()+"',vLocation='"
        			      +vendorContact.getvLocation()+"',vService='"
        			      +vendorContact.getvService()+"',pincode="+
        			      vendorContact.getPincode()+" where vId=?";
        	template.update(sqlOne,new Object[] {vendorContact.getvId()});
        	
        	
        	String sqlTwo="update Contact set cName='"+vendorContact.getcName()
        			      +"',department='"+vendorContact.getDepartment()
        			      +"',email='"+vendorContact.getEmail()+"',phone='"
        			      +vendorContact.getPhone()+"' where vId=?";
        	
        	return template.update(sqlTwo,new Object[] {vendorContact.getvId()});

       }
        
 /*----------------Search Bar----------------------------------*/
 
    	@Override
		public List<VendorContact> searchVendor(String searchString) {
			return template.query("select v.vId,v.vName,v.vLocation,v.vService,c.cName,"
	    			+ "c.department,c.phone from Vendor v join Contact c"
	    			+ " on(v.vId=c.vId) where isActive='Y' and (v.vName LIKE '%"+searchString
	    			+"%' or v.vLocation LIKE '%"+searchString+"%' or v.vService LIKE '%"+searchString+"%')",
							new RowMapper<VendorContact>() {
								public VendorContact mapRow(ResultSet rs, int row)
										throws SQLException {
									VendorContact  vendorContact = new VendorContact();
									vendorContact.setvId(rs.getInt(1));
									vendorContact.setvName(rs.getString(2));
									vendorContact.setvLocation(rs.getString(3));
									vendorContact.setvService(rs.getString(4));
									vendorContact.setcName(rs.getString(5));
									vendorContact.setDepartment(rs.getString(6));
									vendorContact.setPhone(rs.getString(7));
									return vendorContact;
								}
							});
		}	
    	
    	
}
