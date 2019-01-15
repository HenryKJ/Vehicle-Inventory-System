import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HandlerProcessNewVehicle implements HttpHandler {

	@Override
	public void handle(HttpExchange he) throws IOException {
		
		VehicleDAO dao = new VehicleDAO();
		HashMap<String,String> post = new HashMap<String,String>();
		//read the request body
		BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
		String line = "";
		String request = "";
		while((line = in.readLine()) != null) {
			request = request + line;
		}
		//individual key=value pairs are delimited by ampersands. Tokenize.
		String[] pairs = request.split("&");					
		for(int i=0;i<pairs.length;i++) {
			//each key=value pair is separated by an equals, and both halves require URL decoding.
			String pair = pairs[i];
			post.put(URLDecoder.decode(pair.split("=")[0],"UTF-8"),URLDecoder.decode(pair.split("=")[1],"UTF-8"));
		}					
		//Should have a HashMap of posted data in our "post" variable. Now to add a Vehicle
		Vehicle c = new Vehicle(4, "BMW", "One Series", 2007 , 2500 , "P9JLO", "Blue", 3 , "Manual", 110000 , "Diesel", 2 , "Hatchback", "used", "none");
		c.setModel(post.get("Model"));
		c.setMake(post.get("Make"));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));					
		try { 
			dao.insertRecordIntoVehicleTable(c); 
			he.sendResponseHeaders(200, 0); //HTTP 200 (OK)
			out.write("<p>Success!</p> <a href=\"./\">Back to all Vehicles</a>");
		}
		catch(SQLException se) {
			 he.sendResponseHeaders(500, 0); //HTTP 500 (Internal Server Error)
			 out.write("Error Adding Vehicle");
		} finally {
			out.close();
		}
	}

}
