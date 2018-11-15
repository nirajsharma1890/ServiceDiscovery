package com.tcs.customer;

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
import com.tcs.customer.model.Customer;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest {
	
private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext context;
    
    @Before
    public void setup() {
        //this.mockMvc = MockMvcBuilders.standaloneSetup(new WeatherApiController()).build();
    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
	public void AretrieveCustomertest_ok() throws Exception {
	    Customer customer=new Customer(101L,"Sansa Stark",8970000000L,"Winterfell","Female");
		byte[] hospJson = toJson(customer);
		 mockMvc.perform(post("/customer" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON));
		 mockMvc.perform(get("/customer/101" )).andDo(print())
	                .andExpect(status().isOk());
	     mockMvc.perform(delete("/customer/101" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON));
	}
    @Test
	public void BretrieveCustomertest_NotFound() throws Exception {
		 mockMvc.perform(get("/customer/1010" )).andDo(print())
	                .andExpect(status().isNotFound());
	}
    @Test
    public void CretrieveAllCustomertest_ok() throws Exception {
        Customer customer=new Customer(101L,"Sansa Stark",8970000000L,"Winterfell","Female");
		byte[] hospJson = toJson(customer);
		 mockMvc.perform(post("/customer" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON));
		 mockMvc.perform(get("/customer" )).andDo(print())
	                .andExpect(status().isOk());
	     mockMvc.perform(delete("/customer/101" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON));
	}
    @Test
	public void DAaddCustomer_ok() throws Exception {
		Customer customer=new Customer(1030L,"Arya Stark",8970000000L,"Winterfell","Female");
		byte[] hospJson = toJson(customer);
		 mockMvc.perform(post("/customer" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isCreated());
	}
    @Test
    public void DBaddCustomer_Notok() throws Exception {
		Customer customer=new Customer(1030L,"Arya Stark",8970000000L,"Winterfell","Female");
		byte[] hospJson = toJson(customer);
		 mockMvc.perform(post("/customer" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isBadRequest());
    }
    /*@Test
    public void addCustomer_Duplicate() throws Exception {
		Customer customer=new Customer(1030L,"Arya Stark",8970000000L,"Winterfell","Female");
		byte[] hospJson = toJson(customer);
		 mockMvc.perform(post("/customer" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isBadRequest());
	}*/
    @Test
	public void EupdateCustomer_ok() throws Exception {
		Customer customer=new Customer(1030L,"Arya Stark",8970000002L,"Winterfell","Female");
		byte[] hospJson = toJson(customer);
		 mockMvc.perform(put("/customer/1030" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	}
    @Test
	public void FdeleteCustomer_ok() throws Exception {
    	Customer customer=new Customer(1030L,"Arya Stark",8970000002L,"Winterfell","Female");
		byte[] hospJson = toJson(customer);
		mockMvc.perform(delete("/customer/1030" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
		
	}
    @Test
	public void GdeleteCustomer_NotFound() throws Exception {
    	Customer customer=new Customer(1030L,"Arya Stark",8970000002L,"Winterfell","Female");
		byte[] hospJson = toJson(customer);
		mockMvc.perform(delete("/customer/1030" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
		
	}
    @Test
	public void HupdateCustomer_NotFound() throws Exception {
		Customer customer=new Customer(1030L,"Arya Stark",8970000002L,"Winterfell","Female");
		byte[] hospJson = toJson(customer);
		 mockMvc.perform(put("/customer/1030" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound());
	}
    @Test
	public void IdeleteAllCustomer_ok() throws Exception {
	    Customer customer=new Customer(101L,"Sansa Stark",8970000000L,"Winterfell","Female");
		byte[] hospJson = toJson(customer);
		 mockMvc.perform(post("/customer" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON));
		mockMvc.perform(delete("/customer/" )//.andDo(print())
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
		
	}
    @Test
	public void JdeleteAllCustomer_NotFound() throws Exception {
		mockMvc.perform(delete("/customer/" )//.andDo(print())
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
		
	}
   @Test
	public void KretrieveAllCustomertest_NotFound() throws Exception {
		 mockMvc.perform(get("/customer" )).andDo(print())
	                .andExpect(status().isNotFound());
	}
    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }
}
