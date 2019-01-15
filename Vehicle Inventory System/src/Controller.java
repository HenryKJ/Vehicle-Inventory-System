import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.net.httpserver.HttpServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * 
 * @author Henry Kubik-Jones
 *
 */

public class Controller {

	public static void main(String[] args) throws Exception{
		try {
			Server server = new Server(8005); //listen on port 8005
			ServletHandler handler = new ServletHandler();
			server.setHandler(handler);
			handler.addServletWithMapping(LoginServlet.class, "/Login");
			handler.addServletWithMapping(HomeServlet.class, "/*");
			server.start();
			

		}
		catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage() + "  " + ioe.getStackTrace());
		}
		
		VehicleDAO dao = new VehicleDAO();
		ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();

//		TESTING
		
//		dao.deleteVehicle(4);

//	    Vehicle in = new Vehicle(4, "BMW", "One Series", 2007 , 2500 , "P9JLO", "Blue", 3 , "Manual", 110000 , "Diesel", 2 , "Hatchback", "used", "none");
//		dao.insertRecordIntoVehicleTable(in);
//		
//		allVehicles = dao.getAllVehicles();
//		for (Vehicle v : allVehicles)
//		{
//			System.out.println("--------------------------------");
//			System.out.println(v);
//		}
//		
////		dao.deleteVehicle(4);
//		allVehicles = dao.getAllVehicles();
//		for (Vehicle v : allVehicles)
//		{
//			System.out.println("--------------------------------");
//			System.out.println(v);
//		}
//		Vehicle in1 = new Vehicle(4, "BMW", "One Series", 2010 , 4000 , "P9JLO", "Blue", 3 , "Manual", 70000 , "Diesel", 2 , "Hatchback", "used", "none");
//		dao.updateVehicle(in1);
//		System.out.println(dao.getVehicle(4));
		
		System.out.println("-------------------------");
		System.out.println("Vehicle Inventory System");
		System.out.println("Choose from these options");
		System.out.println("-------------------------");
		System.out.println("1 - Retrieve all vehicles");
		System.out.println("2 - Search for vehicle");
		System.out.println("3 - Insert new vehicle into database");
		System.out.println("4 - Update existing vehicle details");
		System.out.println("5 - Delete vehicle from database");
		System.out.println("6 - Exit");
		System.out.println("Enter choice >");
		Scanner input = new Scanner(System.in);
		int t1 = input.nextInt();
		switch (t1) {
		case 1:
			allVehicles = dao.getAllVehicles();
			for (Vehicle v : allVehicles)
			{
				System.out.println("--------------------------------");
				System.out.println(v);
			}
			break;
		case 2:
			System.out.println("input Vehicle ID: ");
			int t2 = input.nextInt();
			dao.getVehicle(t2);
			break;
		case 3:
			System.out.println("input Vehicle ID: ");
			int a1 = input.nextInt();
			input.nextLine();
			System.out.println("input Make: ");
			String a2 = input.nextLine();
			System.out.println("input Model: ");
			String a3 = input.nextLine();
			System.out.println("input Year: ");
			int a4 = input.nextInt();
			input.nextLine();
			System.out.println("input Price: ");
			int a5 = input.nextInt();
			input.nextLine();
			System.out.println("input License Number: ");
			String a6 = input.nextLine();
			System.out.println("input Colour: ");
			String a7 = input.nextLine();
			System.out.println("input Number of doors: ");
			int a8 = input.nextInt();
			input.nextLine();
			System.out.println("input Transmission: ");
			String a9 = input.nextLine();
			System.out.println("input Mileage: ");
			int a10 = input.nextInt();
			input.nextLine();
			System.out.println("input Fule type: ");
			String a11 = input.nextLine();
			System.out.println("input Engine size: ");
			int a12 = input.nextInt();
			input.nextLine();
			System.out.println("input Body style: ");
			String a13 = input.nextLine();
			System.out.println("input Condition: ");
			String a14 = input.nextLine();
			System.out.println("input Notes: ");
			String a15 = input.nextLine();
			
			
			Vehicle in1 = new Vehicle(a1, a2, a3, a4 , a5 , a6 , a7 , a8 , a9, a10 , a11, a12 , a13, a14, a15);
			dao.insertRecordIntoVehicleTable(in1);
			break;
			
		case 4:
			System.out.println("input Vehicle ID to update: ");
			int b1 = input.nextInt();
			input.nextLine();
			System.out.println("input Make: ");
			String b2 = input.nextLine();
			System.out.println("input Model: ");
			String b3 = input.nextLine();
			System.out.println("input Year: ");
			int b4 = input.nextInt();
			input.nextLine();
			System.out.println("input Price: ");
			int b5 = input.nextInt();
			input.nextLine();
			System.out.println("input License Number: ");
			String b6 = input.nextLine();
			System.out.println("input Colour: ");
			String b7 = input.nextLine();
			System.out.println("input Number of doors: ");
			int b8 = input.nextInt();
			input.nextLine();
			System.out.println("input Transmission: ");
			String b9 = input.nextLine();
			System.out.println("input Mileage: ");
			int b10 = input.nextInt();
			input.nextLine();
			System.out.println("input Fule type: ");
			String b11 = input.nextLine();
			System.out.println("input Engine size: ");
			int b12 = input.nextInt();
			input.nextLine();
			System.out.println("input Body style: ");
			String b13 = input.nextLine();
			System.out.println("input Condition: ");
			String b14 = input.nextLine();
			System.out.println("input Notes: ");
			String b15 = input.nextLine();
			
			
			Vehicle in2 = new Vehicle(b1, b2, b3, b4 , b5 , b6 , b7 , b8 , b9, b10 , b11, b12 , b13, b14, b15);
			dao.insertRecordIntoVehicleTable(in2);
			break;
			
		case 5:
			System.out.println("Input ID of vehicle you want to delete: ");
			int c1 = input.nextInt();
			dao.deleteVehicle(c1);
			System.out.println("Vehicle Deleted.");
			break;
			
		case 6:
			System.exit(0);
			break;
		}
	
			
	}
}


		


