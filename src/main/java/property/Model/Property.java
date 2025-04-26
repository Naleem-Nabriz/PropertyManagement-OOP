package property.Model;

public class Property {
    private int id;
    private String propertyName;
    private String propertyType;
    private String location;
    private double price;
    private String description;
    private String contact;

    // Constructor
    public Property(int id, String propertyName, String propertyType, String location, double price, String description, String contact) {
        this.id = id;
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.location = location;
        this.price = price;
        this.description = description;
        this.contact = contact;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", propertyName='" + propertyName + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
