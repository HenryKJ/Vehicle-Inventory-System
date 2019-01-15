import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VehicleDAO {
	
	public VehicleDAO() {}
	/**
	 * 
	 * @return
	 */
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String url = "jdbc:sqlite:D:/Documents/jave_eclipse/Vehicle Inventory System/VehicleInventoryData.sqlite";
			dbConnection = DriverManager.getConnection(url);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return dbConnection;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Vehicle> getAllVehicles() throws SQLException {
		System.out.println("Retrieving all Vehicles...");
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT * FROM Vehicle;";
		ArrayList<Vehicle> vehiclelist = new ArrayList<>();
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = " + query);
			result = statement.executeQuery(query);

			
			
			while(result.next()) {
				int vehicle_id = result.getInt("Vehicle_id");
				String make = result.getString("Make");
				String model = result.getString("Model");
				int year = result.getInt("Year");
				int price = result.getInt("Price");
				String license_number = result.getString("License_number");
				String colour = result.getString("Colour");
				int number_doors = result.getInt("Number_doors");
				String transmission = result.getString("Transmission");
				int mileage = result.getInt("Mileage");
				String fuel_type = result.getString("Fuel_type");
				int engine_size = result.getInt("Engine_size");
				String body_style = result.getString("Body_style");
				String condition = result.getString("Condition");
				String notes = result.getString("Notes");
				
				
				
				vehiclelist.add(new Vehicle(vehicle_id, make, model,
						year, price, license_number, colour, 
						number_doors,  transmission, mileage,  fuel_type,
						 engine_size,  body_style,  condition, 
						notes));
				
				
			}
		} catch(Exception e) {
			System.out.println("get all Vehicles: "+e);
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
		return vehiclelist;
	}
	/**
	 * 
	 * @param vehicle_id
	 * @return
	 * @throws SQLException
	 */
	
	public Vehicle getVehicle(int vehicle_id) throws SQLException {

		Vehicle temp = null;
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;

		String query = "SELECT * FROM Vehicle WHERE Vehicle_id =" + vehicle_id + ";";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery: " + query);
			// execute SQL query
			result = statement.executeQuery(query);

			while(result.next()) {
				vehicle_id = result.getInt("Vehicle_id");
				String make = result.getString("Make");
				String model = result.getString("Model");
				int year = result.getInt("Year");
				int price = result.getInt("Price");
				String license_number = result.getString("License_number");
				String colour = result.getString("Colour");
				int number_doors = result.getInt("Number_doors");
				String transmission = result.getString("Transmission");
				int mileage = result.getInt("Mileage");
				String fuel_type = result.getString("Fuel_type");
				int engine_size = result.getInt("Engine_size");
				String body_style = result.getString("Body_style");
				String condition = result.getString("Condition");
				String notes = result.getString("Notes");
				
				
				
				temp = new Vehicle(vehicle_id, make, model,
						year, price, license_number, colour, 
						number_doors,  transmission, mileage,  fuel_type,
						 engine_size,  body_style,  condition, 
						notes);
				
				
			}
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return temp;
	}
	/**
	 * 
	 * @param vehicle
	 * @return
	 * @throws SQLException
	 */
	public Boolean updateVehicle(Vehicle vehicle) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		String query = "UPDATE Vehicle " + "SET Vehicle_id = " + vehicle.getVehicle_id() + "," + "Make = '"
				+ vehicle.getMake() + "'," + "Model = '" + vehicle.getModel() + "'," + "Year= " + vehicle.getYear()
				+ "," + "Price= " + vehicle.getPrice() + "," + "License_number= '" + vehicle.getLicense_number() + "'," + "Colour= '" + vehicle.getColour()
				+ "'," + "Number_doors= " + vehicle.getNumber_doors() + "," + "Transmission= '" + vehicle.getTransmission() + "'," + "Mileage= " + vehicle.getMileage()
				+ "," + "Fuel_type= '" + vehicle.getFuel_type() + "'," + "Engine_size= " + vehicle.getEngine_size() + "," + "Body_style= '" + vehicle.getBody_style()
				+ "'," + "Condition= '" + vehicle.getCondition() + "'," + "Notes= '" + vehicle.getNotes() +"' WHERE Vehicle_id = " + vehicle.getVehicle_id()
				+ ";";

		
			try (Connection dbConn = VehicleDAO.getDBConnection()){
				
			PreparedStatement prep = dbConn.prepareStatement(query);
			System.out.println(query);
			prep.executeUpdate();

		} catch (SQLException e) {

			 
			return false;

		} finally {

			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return true;
	}
	/**
	 * 
	 * @param in
	 * @return
	 * @throws SQLException
	 */
	public boolean insertRecordIntoVehicleTable(Vehicle in) throws SQLException{
		Connection dbConnection = null;
		Statement statement = null;
		
		String update = "INSERT INTO Vehicle (Vehicle_id, Make, Model, Year, Price, License_number, Colour, Number_doors, "
				+ "Transmission, Mileage, Fuel_type, Engine_size, Body_style, Condition, Notes) VALUES ("+in.getVehicle_id()+",'"+in.getMake()+"','"+in.getModel()+"',"
		+in.getYear()+","+in.getPrice()+",'"+in.getLicense_number()+"','"+in.getColour()+"',"+in.getNumber_doors()+",'"+in.getTransmission()+"',"+in.getMileage()
		+",'"+in.getFuel_type()+"',"+in.getEngine_size()+",'"+in.getBody_style()+"','"+in.getCondition()+"','"+in.getNotes()+"');";
		boolean ok = false;
			try {
					dbConnection = getDBConnection();
					statement = dbConnection.createStatement();
					System.out.println(update);
					statement.executeUpdate(update);
					ok = true;
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					if (statement != null) {
						statement.close();
					}
					if (dbConnection != null) {
						dbConnection.close();
					}
					
				}
			return ok;
	}
	
	/**
	 * 
	 * @param vehicle_id
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteVehicle(int vehicle_id) throws SQLException {

		boolean temp = false;
		String query = "DELETE FROM Vehicle WHERE Vehicle_id =?" ;

		try (Connection dbConnection = VehicleDAO.getDBConnection()){
			
			PreparedStatement prep = dbConnection.prepareStatement(query);
			prep.setInt(1,vehicle_id);
			prep.executeUpdate();
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}

			
		return temp;
	}
	
}

		
		





