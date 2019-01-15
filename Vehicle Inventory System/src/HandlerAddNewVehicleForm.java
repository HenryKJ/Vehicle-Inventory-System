import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HandlerAddNewVehicleForm implements HttpHandler {

	@Override
	public void handle(HttpExchange he) throws IOException {

		// output HTML form
		he.sendResponseHeaders(200, 0);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		out.write("<html><head></head><body><form method=\"POST\" action=\"/add_write\">");
		out.write("Name:<input name=\"name\"><br>");
		out.write("Password:<input name=\"email\"><br>");
		out.write("<input type=\"submit\" value=\"Submit\">");
		out.write("</form></body></html>");
		out.close();

	}

}