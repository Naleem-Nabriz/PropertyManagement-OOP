package property.Controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import property.DAO.PropertyDAO;

import java.io.IOException;

@WebServlet("/deleteproperty")
public class DeletePropertyServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PropertyDAO propertyDAO = new PropertyDAO();
        propertyDAO.deleteProperty(id); // Assuming this method deletes the property by id

        response.sendRedirect("CrudProperty.jsp"); // Redirect back to the properties list
    }
}
