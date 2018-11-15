package com.tcs.vendor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.vendor.model.Vendor;
import com.tcs.vendor.repository.VendorRepository;

@Service
public class VendorService {
	
	@Autowired 
	private VendorRepository vendorRepository;
	
	public List<Vendor> getAllVendors(){
		List<Vendor> vendorList= new ArrayList<Vendor>();
		vendorRepository.findAll().forEach(vendorList::add);
		return vendorList;
	}
	public Vendor getVendor(long id){
	    List<Vendor> vendorList= new ArrayList<Vendor>();
	    Vendor vendor = null;
	    vendorRepository.findAll().forEach(vendorList::add);
		try {
			vendor = vendorList.stream().filter(c->c.getVendorId()==(id)).findFirst().get();
		}catch(Exception e)
		{
			System.out.println(e);
			vendor=null;
		}
		return vendor;
	}
	
	public Vendor addVendor(Vendor vendor){
		vendorRepository.save(vendor);
		return vendor;
	}
	public void deleteVendor(Vendor vendor) {
		vendorRepository.delete(vendor);
	}
	public void deleteAllVendors() {
		vendorRepository.deleteAll();
	}

}
