package com.tcs.vendor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.vendor.model.Vendor;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendorTest {
	
private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext context;
    
    @Before
    public void setup() {
        //this.mockMvc = MockMvcBuilders.standaloneSetup(new WeatherApiController()).build();
    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
	public void AretrieveVendortest_ok() throws Exception {
	    Vendor vendor=new Vendor(999,"ADITYA BIRLA MORE",1234567890,"MORE@EMAIL.COM","MORE","CC2");
		byte[] hospJson = toJson(vendor);
		 mockMvc.perform(post("/vendor" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON));
		 mockMvc.perform(get("/vendor/999" )).andDo(print())
	                .andExpect(status().isOk());
	     mockMvc.perform(delete("/vendor/999" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON));
	}
    @Test
	public void BretrieveVendortest_NotFound() throws Exception {
		 mockMvc.perform(get("/vendor/110" )).andDo(print())
	                .andExpect(status().isNotFound());
	}
    @Test
    public void CretrieveAllVendortest_ok() throws Exception {
        Vendor vendor=new Vendor(999,"ADITYA BIRLA MORE",1234567890,"MORE@EMAIL.COM","MORE","CC2");
		byte[] hospJson = toJson(vendor);
		 mockMvc.perform(post("/vendor" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON));
		 mockMvc.perform(get("/vendor" )).andDo(print())
	                .andExpect(status().isOk());
	     mockMvc.perform(delete("/vendor/999" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON));
	}
    @Test
	public void DAaddVendor_ok() throws Exception {
		Vendor vendor=new Vendor(103,"ADITYA BIRLA MORE",1234567890,"MORE@EMAIL.COM","MORE","CC2");
		byte[] hospJson = toJson(vendor);
		 mockMvc.perform(post("/vendor" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isCreated());
	}
    @Test
	public void DBaddVendor_Notok() throws Exception {
		Vendor vendor=new Vendor(103,"ADITYA BIRLA MORE",1234567890,"MORE@EMAIL.COM","MORE","CC2");
		byte[] hospJson = toJson(vendor);
		 mockMvc.perform(post("/vendor" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isBadRequest());
	}
    /*@Test
    public void addVendor_Duplicate() throws Exception {
		Vendor vendor=new Vendor(1030L,"Arya Stark",8970000000L,"Winterfell","Female");
		byte[] hospJson = toJson(vendor);
		 mockMvc.perform(post("/vendor" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isBadRequest());
	}*/
    @Test
	public void EupdateVendor_ok() throws Exception {
		Vendor vendor=new Vendor(103L,"ADITYA BIRLA MORE",1234567890L,"MORE@EMAIL.COM","MORE","CITY CENTER 2");
		byte[] hospJson = toJson(vendor);
		 mockMvc.perform(put("/vendor/103" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	}
    @Test
	public void FdeleteVendor_ok() throws Exception {
    	Vendor vendor=new Vendor(103L,"ADITYA BIRLA MORE",1234567890L,"MORE@EMAIL.COM","MORE","CITY CENTER 2");
		byte[] hospJson = toJson(vendor);
		mockMvc.perform(delete("/vendor/103" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
		
	}
    @Test
	public void GdeleteVendor_NotFound() throws Exception {
    	Vendor vendor=new Vendor(103L,"ADITYA BIRLA MORE",1234567890L,"MORE@EMAIL.COM","MORE","CITY CENTER 2");
		byte[] hospJson = toJson(vendor);
		mockMvc.perform(delete("/vendor/103" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
		
	}
    @Test
	public void HupdateVendor_NotFound() throws Exception {
    	Vendor vendor=new Vendor(103L,"ADITYA BIRLA MORE",1234567890L,"MORE@EMAIL.COM","MORE","CITY CENTER 2");
		byte[] hospJson = toJson(vendor);
		 mockMvc.perform(put("/vendor/103" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound());
	}
    @Test
	public void IdeleteAllVendor_ok() throws Exception {
	    Vendor vendor=new Vendor(999,"ADITYA BIRLA MORE",1234567890,"MORE@EMAIL.COM","MORE","CC2");
		byte[] hospJson = toJson(vendor);
		 mockMvc.perform(post("/vendor" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON));
		mockMvc.perform(delete("/vendor/" )//.andDo(print())
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
		
	}
    @Test
	public void JdeleteAllVendor_NotFound() throws Exception {
		mockMvc.perform(delete("/vendor/" )//.andDo(print())
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
		
	}
   @Test
	public void KretrieveAllVendortest_NotFound() throws Exception {
		 mockMvc.perform(get("/vendor" )).andDo(print())
	                .andExpect(status().isNotFound());
	}
    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }
}
