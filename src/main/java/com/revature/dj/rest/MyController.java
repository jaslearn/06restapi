package com.revature.dj.rest;




import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Path("controller")
public class MyController {

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
		return "Hello From Controller";
	}
	@GET
	@Path("/hello/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHelloParam(@PathParam("id") int num) {
		return "Hello From Controller " + num;
	}
	@POST
	@Path("/form")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String PostForm(@FormParam("accept") String accept) {
		return "Accept was " + accept + ".";
	}
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetJson() {
		ObjectMapper mapper = new ObjectMapper();
		MyClass my = new MyClass("Name1");
		MyClass my1=new MyClass("Name2");
		List<MyClass> clsObj=new ArrayList<MyClass>();
		clsObj.add(my);
		clsObj.add(my1);
		
		try {
			return mapper.writeValueAsString(clsObj);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}
