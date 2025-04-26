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

@WebServlet("/displayproperties")
public class DisplayPropertiesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PropertyDAO propertyDAO = new PropertyDAO();
        List<Property> properties = propertyDAO.getAllProperties(); // Assuming this method retrieves all properties

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Properties List</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f5f5f5; color: #333; padding: 20px; }");
        out.println("table { width: 100%; border-collapse: collapse; margin: 20px 0; }");
        out.println("th, td { padding: 10px; border: 1px solid #ccc; text-align: left; }");
        out.println("th { background-color: #b0b0b0; color: white; }"); // Grey header background
        out.println("td { background-color: #ffffff; }"); // White background for table cells
        out.println("button.delete { background-color: #ff6f61; color: white; border: none; padding: 6px 10px; cursor: pointer; border-radius: 4px; transition: background-color 0.3s; }");
        out.println("button.delete:hover { background-color: #e65a50; }");
        out.println("button.update { background-color: #4caf50; color: white; border: none; padding: 6px 10px; cursor: pointer; border-radius: 4px; transition: background-color 0.3s; }");
        out.println("button.update:hover { background-color: #45a049; }"); // Darker green on hover
        out.println("a { text-decoration: none; padding: 10px; background-color: #32dbc2; color: white; border-radius: 4px; transition: background-color 0.3s; }");
        out.println("a:hover { background-color: #28b3a4; }"); // Button hover effect
        out.println("</style>");
        out.println("<script>");
        out.println("function confirmDelete() { return confirm('Are you sure you want to delete this property?'); }");
        out.println("function confirmUpdate() { return confirm('Are you sure you want to update this property?'); }");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Property List</h2>");
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Property Name</th><th>Type</th><th>Location</th><th>Price</th><th>Description</th><th>Contact</th><th>Actions</th></tr>");

        for (Property property : properties) {
            out.println("<tr>");
            out.println("<td>" + property.getId() + "</td>");
            out.println("<td>" + property.getPropertyName() + "</td>");
            out.println("<td>" + property.getPropertyType() + "</td>");
            out.println("<td>" + property.getLocation() + "</td>");
            out.println("<td>" + property.getPrice() + "</td>");
            out.println("<td>" + property.getDescription() + "</td>");
            out.println("<td>" + property.getContact() + "</td>");
            out.println("<td>");
            out.println("<form action='deleteproperty' method='POST' style='display:inline;'>");
            out.println("<input type='hidden' name='id' value='" + property.getId() + "' />");
            out.println("<button class='delete' type='submit' onclick='return confirmDelete();'>Delete</button>");
            out.println("</form>");
            out.println("<form action='updateproperty' method='GET' style='display:inline;'>");
            out.println("<input type='hidden' name='id' value='" + property.getId() + "' />");
            out.println("<button class='update' type='submit' onclick='return confirmUpdate();'>Update</button>");
            out.println("</form>");
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<a href='AddProperty.jsp'>Add New Property</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
