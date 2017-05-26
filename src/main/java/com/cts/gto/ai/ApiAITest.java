package com.cts.gto.ai;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.cts.gto.ai.util.ObjectToJson;




@Path(value = "/flight")
public class ApiAITest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String printPlainText() {


		String jsonInString = ObjectToJson.getJsonString("Flight booked");

		return jsonInString;
	}
	
	@POST
	@Path("/bookFlight")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED,
			MediaType.APPLICATION_JSON })
	public Response authenticate(@FormParam("geo-city") String city1,
			@FormParam("geo-city") String city2) {
		
		System.out.println("city1" + city1);
		System.out.println("cty2" + city2);
		
		

		String jsonInString = ObjectToJson.getJsonString("Flight booked from"+city1+"to"+city2);
		return Response
				.ok()
				.entity(jsonInString)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}

	

}
