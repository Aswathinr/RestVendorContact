package com.faith.dao;

import java.util.List;

import com.faith.model.VendorContact;

public interface IVendorContactDao {

	public abstract int insertVendorContact(VendorContact vendorContact);

	public abstract List<VendorContact> getAllDetails();

	public abstract int disableVendor(int vId);

	public abstract int updateVendor(VendorContact vendorContact);

	public abstract List<VendorContact> searchVendor(String searchString);

	public abstract VendorContact getVendorById(int vId);
	
//	public abstract VendorContact duplication(String phone, String email);
}