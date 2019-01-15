import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HandlerHome implements HttpHandler {

	@Override
	public void handle(HttpExchange he) throws IOException {
		VehicleDAO dao = new VehicleDAO();

		String head = "<html><head></head><body><button onclick=\"window.location.href = '/post';\">Edit</button><table><tr><th>Vehicle ID</th><th>Make</th>"
				+ "<th>Model</th><th>Year</th><th>Price</th><th>License Number</th><th>Colour</th>"
				+ "<th>Number of Doors</th><th>Transmission</th><th>Mileage</th><th>Fuel Type</th>"
				+ "<th>Engine Size</th><th>Body Style</th><th>Condition</th><th>Notes</th></tr>";
		String foot = "</table></body></html>";
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));

		ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();
		try {
			Vehicles = dao.getAllVehicles();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		he.sendResponseHeaders(200, 0); // Must send Http response, other will not work
		out.write(head);

		for (Vehicle c : Vehicles) {
			out.write("<tr><td>" + c.getVehicle_id() + "</td><td>" + c.getMake() + "</td><td>" 
		+ c.getModel() + "</td><td>" + c.getYear() + "</td><td>" + c.getPrice() + "</td><td>" 
					+ c.getLicense_number() + "</td><td>" + c.getColour() + "</td><td>" 
		+ c.getNumber_doors() + "</td><td>" + c.getTransmission() + "</td><td>" + c.getMileage() 
		+ "</td><td>" + c.getFuel_type() + "</td><td>" + c.getEngine_size() + "</td><td>" 
		+ c.getBody_style() + "</td><td>" + c.getCondition() + "</td><td>" + c.getNotes());
		}

		out.write(foot);

		out.close();
	}
}