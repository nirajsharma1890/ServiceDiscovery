package com.tcs.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.vendor.model.Vendor;
import com.tcs.vendor.service.VendorService;

@RestController
@RequestMapping("/")
public class VendorContoller {
	
	@Autowired
	private VendorService vendorService;
	/*Begin of Vendor Endpoints*/
	@GetMapping(value = "/vendor")
	public ResponseEntity<List<Vendor>> getAllVendors() throws Exception {
		List<Vendor> vendorList = this.vendorService.getAllVendors();
		if(vendorList.size()==0)
			return new ResponseEntity<List<Vendor>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Vendor>>(vendorList,HttpStatus.OK);
		
    }
	
	@GetMapping(value = "/vendor/{id}")
	public ResponseEntity<Vendor> getVendor(@PathVariable("id") long id ) throws Exception {
		Vendor vendor = this.vendorService.getVendor(id);
		if(vendor==null)
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Vendor>(vendor,HttpStatus.OK);
	}
	
	@PostMapping("/vendor")
	public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
		Vendor checkVendor=this.vendorService.getVendor(vendor.getVendorId());
		if(checkVendor==null) {
			Vendor createdVendor = this.vendorService.addVendor(vendor);
			return new ResponseEntity<Vendor>(createdVendor,HttpStatus.CREATED);
		}else
			return new ResponseEntity<Vendor>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/vendor/{id}")
	public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor vendor, @PathVariable("id") long id){
		Vendor checkVendor = this.vendorService.getVendor(id);
		if(checkVendor!=null)
		{
			this.vendorService.deleteVendor(checkVendor);
			return new ResponseEntity<Vendor>(this.vendorService.addVendor(vendor),HttpStatus.OK);
		}
		else
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/vendor/{id}")
	public ResponseEntity<Vendor> deleteVendor(@PathVariable("id") long id) {
		Vendor checkVendor = this.vendorService.getVendor(id);
	    if(checkVendor!=null) {
	    	this.vendorService.deleteVendor(checkVendor);
	    	return new ResponseEntity<Vendor>(HttpStatus.OK);
	    }
	    else
	    	return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/vendor/")
	public ResponseEntity<Vendor> deleteAllVendors() {
		if(this.vendorService.getAllVendors().size()!=0){
			this.vendorService.deleteAllVendors();
			return new ResponseEntity<Vendor>(HttpStatus.OK);
		}else
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		
	}
	/*End of Vendor Endpoints*/
	}
