package in.com.util;

import com.google.gson.Gson;

import in.com.bindings.Address;
import in.com.bindings.Passenger;

public class JavaToJson {

	public static void main(String[] args) throws Exception {

		Address addr = new Address();
		addr.setCity("Hyd");
		addr.setState("TG");
		addr.setCountry("India");

		Passenger passenger = new Passenger();
		passenger.setName("Raju");
		passenger.setFrom("Hyd");
		passenger.setTo("Delhi");
		passenger.setGender("Male");
		passenger.setAddr(addr);

		/*ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("passenger.json"), passenger);*/
		
		Gson gson = new Gson();
		String json = gson.toJson(passenger);
		
		System.out.println(json);
		
		System.out.println("Done....");
	}
}
