package property.Controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import property.DAO.PropertyDAO;
import property.Model.Property;

import java.io.IOException;

@WebServlet("/addproperty")
public class AddPropertyServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve property details from the request
        String propertyName = request.getParameter("propertyName");
        String propertyType = request.getParameter("propertyType");
        String location = request.getParameter("location");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String contact = request.getParameter("contact");

        // Create a Property object
        Property property = new Property(0, propertyName, propertyType, location, price, description, contact);

        // Use PropertyDAO to save the property
        PropertyDAO propertyDAO = new PropertyDAO();
        propertyDAO.createProperty(property);

        // Redirect or forward to a success page or back to the form
        response.sendRedirect("CrudProperty.jsp"); // Redirect to a success page
        // Alternatively, you can forward to a JSP page using:
        // request.getRequestDispatcher("success.jsp").forward(request, response);
    }
}
