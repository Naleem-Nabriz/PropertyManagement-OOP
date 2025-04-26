package property.Controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import property.DAO.PropertyDAO;
import property.Model.Property;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/properties") // Updated URL pattern
public class PropertyDisplayServlet extends HttpServlet { // Renamed servlet class

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PropertyDAO propertyDAO = new PropertyDAO();
        List<Property> properties = propertyDAO.getAllProperties(); // This method retrieves all properties

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Properties List</title>");
        // Include Font Awesome CDN
        out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css'>");
        // Add custom styles
        out.println("<style>");
        out.println(".property-card { border: 1px solid #ccc; padding: 20px; margin: 10px; }");
        out.println(".property-header { font-size: 1.5em; margin-bottom: 10px; }");
        out.println(".property-detail { margin-bottom: 5px; }");
        out.println(".property-icon { font-size: 2em; color: #32dbc2; margin-right: 10px; }"); // Customize icon style here
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        for (Property property : properties) {
            out.println("<div class='property-card'>");
            out.println("<div class='property-header'>");
            out.println("<i class='fas fa-home property-icon'></i>"); // Example icon for the property
            out.println(property.getPropertyName() + "</div>");
            out.println("<div class='property-detail'>Type: " + property.getPropertyType() + "</div>");
            out.println("<div class='property-detail'>Location: " + property.getLocation() + "</div>");
            out.println("<div class='property-detail'>Price: " + property.getPrice() + "</div>");
            out.println("<div class='property-detail'>Description: " + property.getDescription() + "</div>");
            out.println("<div class='property-detail'>Contact: " + property.getContact() + "</div>");
            out.println("</div>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
