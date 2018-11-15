package com.tcs.inventory;

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
import com.tcs.inventory.model.Inventory;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryTest {
	
private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext context;
    
    @Before
    public void setup() {
        //this.mockMvc = MockMvcBuilders.standaloneSetup(new WeatherApiController()).build();
    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
	public void AretrieveInventorytest_ok() throws Exception {
	    Inventory inventory=new Inventory(99L,"Vodka","Smirnoff 25",500,200,160);
		byte[] hospJson = toJson(inventory);
		mockMvc.perform(post("/item" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON));
		 mockMvc.perform(get("/item/99" )).andDo(print())
	                .andExpect(status().isOk());
	     mockMvc.perform(delete("/item/99" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON));
	}
    @Test
	public void BretrieveInventorytest_NotFound() throws Exception {
		 mockMvc.perform(get("/item/101" )).andDo(print())
	                .andExpect(status().isNotFound());
	}
    @Test
    public void CretrieveAllInventorytest_ok() throws Exception {
        Inventory inventory=new Inventory(99L,"Vodka","Smirnoff 25",500,200,160);
		byte[] hospJson = toJson(inventory);
		mockMvc.perform(post("/item" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON));
		 mockMvc.perform(get("/item" )).andDo(print())
	                .andExpect(status().isOk());
	     mockMvc.perform(delete("/item/99" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON));
	}
    @Test
	public void DAaddInventory_ok() throws Exception {
		Inventory inventory=new Inventory(10L,"Vodka","Smirnoff 50",500,200,160);
		byte[] hospJson = toJson(inventory);
		 mockMvc.perform(post("/item" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isCreated());
	}
    @Test
	public void DBaddInventory_Notok() throws Exception {
		Inventory inventory=new Inventory(10L,"Vodka","Smirnoff 50",500,200,160);
		byte[] hospJson = toJson(inventory);
		 mockMvc.perform(post("/item" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isBadRequest());
	}
    /*@Test
    public void addInventory_Duplicate() throws Exception {
		Inventory inventory=new Inventory(1030L,"Arya Stark",8970000000L,"Winterfell","Female");
		byte[] hospJson = toJson(inventory);
		 mockMvc.perform(post("/item" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isBadRequest());
	}*/
    @Test
	public void EupdateInventory_ok() throws Exception {
    	Inventory inventory=new Inventory(10L,"Vodka","Smirnoff 100",500,200,160);
		byte[] hospJson = toJson(inventory);
		 mockMvc.perform(put("/item/10" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	}
    @Test
	public void FdeleteInventory_ok() throws Exception {
    	Inventory inventory=new Inventory(10L,"Vodka","Smirnoff 100",500,200,160);
		byte[] hospJson = toJson(inventory);
		mockMvc.perform(delete("/item/10" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
		
	}
    @Test
	public void GdeleteInventory_NotFound() throws Exception {
    	Inventory inventory=new Inventory(10L,"Vodka","Smirnoff 100",500,200,160);
		byte[] hospJson = toJson(inventory);
		mockMvc.perform(delete("/item/10" )//.andDo(print())
	 			.content(hospJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
		
	}
    @Test
	public void HupdateInventory_NotFound() throws Exception {
    	Inventory inventory=new Inventory(10L,"Vodka","Smirnoff 100",500,200,160);
		byte[] hospJson = toJson(inventory);
		 mockMvc.perform(put("/item/10" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound());
	}
    @Test
	public void IdeleteAllInventory_ok() throws Exception {
	    Inventory inventory=new Inventory(99L,"Vodka","Smirnoff 25",500,200,160);
		byte[] hospJson = toJson(inventory);
		mockMvc.perform(post("/item" )//.andDo(print())
		 			.content(hospJson)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON));
		mockMvc.perform(delete("/item/" )//.andDo(print())
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
		
	}
    @Test
	public void JdeleteAllInventory_NotFound() throws Exception {
		mockMvc.perform(delete("/item/" )//.andDo(print())
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
		
	}
   @Test
	public void KretrieveAllInventorytest_NotFound() throws Exception {
		 mockMvc.perform(get("/item" )).andDo(print())
	                .andExpect(status().isNotFound());
	}
    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }
}
