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

@WebServlet("/updateproperty")
public class UpdatePropertyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PropertyDAO propertyDAO = new PropertyDAO();
        Property property = propertyDAO.getPropertyById(id); // Method to retrieve the property by ID

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Update Property</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f5f5f5; color: #333; padding: 20px; }");
        out.println(".container { width: 400px; margin: 10px auto; background: #f0f0f0; padding: 15px; border-radius: 8px; }");
        out.println("h2 { color: #ff6f61; text-align: center; margin-bottom: 10px; }");
        out.println(".form-group { margin-bottom: 8px; }");
        out.println("label { display: block; margin-bottom: 3px; font-weight: bold; color: #555; }");
        out.println("input[type='text'], input[type='number'], textarea, select { width: calc(100% - 10px); padding: 6px; margin: 2px 0 6px; border: 1px solid #ccc; border-radius: 4px; background-color: #fff; color: #333; box-sizing: border-box; }");
        out.println("textarea { resize: vertical; max-height: 80px; }");
        out.println("button { background-color: #ff6f61; color: white; border: none; padding: 8px; cursor: pointer; border-radius: 4px; width: 100%; margin-top: 8px; }");
        out.println("button:hover { background-color: #e65a50; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h2>Update Property</h2>");
        out.println("<form action='updateproperty' method='POST'>"); // Action for processing update
        out.println("<input type='hidden' name='id' value='" + property.getId() + "' />"); // Hidden field for ID
        out.println("<div class='form-group'>");
        out.println("<label for='propertyName'>Property Name:</label>");
        out.println("<input type='text' id='propertyName' name='propertyName' value='" + property.getPropertyName() + "' required>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<label for='propertyType'>Property Type:</label>");
        out.println("<select id='propertyType' name='propertyType' required>");
        out.println("<option value='House'" + ("House".equals(property.getPropertyType()) ? " selected" : "") + ">House</option>");
        out.println("<option value='Apartment'" + ("Apartment".equals(property.getPropertyType()) ? " selected" : "") + ">Apartment</option>");
        out.println("<option value='Condo'" + ("Condo".equals(property.getPropertyType()) ? " selected" : "") + ">Condo</option>");
        out.println("<option value='Land'" + ("Land".equals(property.getPropertyType()) ? " selected" : "") + ">Land</option>");
        out.println("</select>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<label for='location'>Location:</label>");
        out.println("<input type='text' id='location' name='location' value='" + property.getLocation() + "' required>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<label for='price'>Price:</label>");
        out.println("<input type='number' id='price' name='price' value='" + property.getPrice() + "' required>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<label for='description'>Description:</label>");
        out.println("<textarea id='description' name='description' rows='2' required>" + property.getDescription() + "</textarea>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<label for='contact'>Contact Information:</label>");
        out.println("<input type='text' id='contact' name='contact' value='" + property.getContact() + "' required>");
        out.println("</div>");
        out.println("<button type='submit'>Update Property</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Getting property details from the request
        int id = Integer.parseInt(request.getParameter("id"));
        String propertyName = request.getParameter("propertyName");
        String propertyType = request.getParameter("propertyType");
        String location = request.getParameter("location");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String contact = request.getParameter("contact");

        // Creating Property object to hold updated details
        Property property = new Property(id, propertyName, propertyType, location, price, description, contact);

        // Updating property in the database
        PropertyDAO propertyDAO = new PropertyDAO();
        propertyDAO.updateProperty(property); // Call to update the property

        // Redirecting to a confirmation page or properties list
        response.sendRedirect("CrudProperty.jsp"); // Adjust the redirect path as needed
    }
}
