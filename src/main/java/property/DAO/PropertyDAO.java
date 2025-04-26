package property.DAO;

import Config.DatabaseConnection;
import property.Model.Property;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {

    // Method to create a new property
    public void createProperty(Property property) {
        String sql = "INSERT INTO properties (propertyName, propertyType, location, price, description, contact) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
             
            preparedStatement.setString(1, property.getPropertyName());
            preparedStatement.setString(2, property.getPropertyType());
            preparedStatement.setString(3, property.getLocation());
            preparedStatement.setDouble(4, property.getPrice());
            preparedStatement.setString(5, property.getDescription());
            preparedStatement.setString(6, property.getContact());
            preparedStatement.executeUpdate();

            // Get the generated ID
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    property.setId(generatedKeys.getInt(1)); // Set the generated ID to the property object
                }
            }

            System.out.println("Property created successfully!");

        } catch (SQLException e) {
            System.out.println("Error creating property: " + e.getMessage());
        }
    }

    // Method to get a property by ID
    public Property getPropertyById(int id) {
        String sql = "SELECT * FROM properties WHERE id = ?";
        Property property = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                property = new Property(
                        resultSet.getInt("id"),
                        resultSet.getString("propertyName"),
                        resultSet.getString("propertyType"),
                        resultSet.getString("location"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getString("contact")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving property by ID: " + e.getMessage());
        }

        return property;
    }

    // Method to update a property
    public void updateProperty(Property property) {
        String sql = "UPDATE properties SET propertyName = ?, propertyType = ?, location = ?, price = ?, description = ?, contact = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setString(1, property.getPropertyName());
            preparedStatement.setString(2, property.getPropertyType());
            preparedStatement.setString(3, property.getLocation());
            preparedStatement.setDouble(4, property.getPrice());
            preparedStatement.setString(5, property.getDescription());
            preparedStatement.setString(6, property.getContact());
            preparedStatement.setInt(7, property.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Property updated successfully!");
            } else {
                System.out.println("Property not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating property: " + e.getMessage());
        }
    }

    // Method to delete a property
    public void deleteProperty(int id) {
        String sql = "DELETE FROM properties WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Property deleted successfully!");
            } else {
                System.out.println("Property not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting property: " + e.getMessage());
        }
    }

    // Method to retrieve all properties
    public List<Property> getAllProperties() {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM properties";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Property property = new Property(
                        resultSet.getInt("id"),
                        resultSet.getString("propertyName"),
                        resultSet.getString("propertyType"),
                        resultSet.getString("location"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getString("contact")
                );
                properties.add(property);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving properties: " + e.getMessage());
        }

        return properties;
    }
}
