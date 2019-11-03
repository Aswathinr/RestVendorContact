package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IVendorContactDao;
import com.faith.model.VendorContact;

@RestController
public class VendorContactController {
	
	    @Autowired
	    IVendorContactDao vdao;
	    
	/*----------------------  insert vendor contact-----------------*/
		@RequestMapping(value = "/api/insertvendordetails", method = RequestMethod.POST)
		public void insertDetails(@RequestBody VendorContact vendorContact)
		{
				vdao.insertVendorContact(vendorContact);
		}
		
		/*----------------------  update vendor contact-----------------*/
		@RequestMapping(value = "/api/updatevendor/{vId}", method = RequestMethod.PUT)
		public void updateDetails(@RequestBody VendorContact vendorContact)
		{
		
				vdao.updateVendor(vendorContact);
		}
		
		
		/*----------------------  disable vendor -----------------*/
		@RequestMapping(value = "/api/disablevendor/{vId}", method = RequestMethod.PUT)
		void deleteVendor(@PathVariable("vId") int vId) {
			vdao.disableVendor(vId);
		}
		
		
		/*---------------------- get vendor details-----------------*/
		@SuppressWarnings("rawtypes")
		@RequestMapping(value = "/api/vendordetails/{searchString}", method = RequestMethod.GET)
		public List getVendors( @PathVariable("searchString") String searchString) {
			List list;
			if (searchString.equals("null")) {
				list = vdao.getAllDetails();
			} else {
				list = vdao.searchVendor(searchString);
			}
			return list;
		}
		
		
		/*----------------------  get vendor byId----------------*/
		@RequestMapping(value = "/api/vendorbyid/{vId}", method = RequestMethod.GET)
		public VendorContact getVendorById(@PathVariable("vId") int vId) {
			VendorContact vendorContact =vdao.getVendorById(vId);
			return vendorContact;
		}

	    
	    

}
