import java.util.ArrayList;
import java.util.Scanner;

class Property {
    String title;
    String location;
    String type;
    double price;
    double area;
    String ownerContact;

    Property(String title, String location, String type,
             double price, double area, String ownerContact) {
        this.title = title;
        this.location = location;
        this.type = type;
        this.price = price;
        this.area = area;
        this.ownerContact = ownerContact;
    }

    void displayProperty() {
        System.out.println("----------------------------------------");
        System.out.println("Property Name : " + title);
        System.out.println("Location      : " + location);
        System.out.println("Property Type : " + type);
        System.out.println("Price         : ₹" + price);
        System.out.println("Area          : " + area + " sq.ft");
        System.out.println("Owner Contact : " + ownerContact);
        System.out.println("----------------------------------------");
    }
}

public class RealEstateListingPortal {

    static ArrayList<Property> properties = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("       REAL ESTATE LISTING PORTAL");
            System.out.println("========================================");
            System.out.println("1. Add Property");
            System.out.println("2. View Properties");
            System.out.println("3. Search Property");
            System.out.println("4. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addProperty();
                    break;

                case 2:
                    viewProperties();
                    break;

                case 3:
                    searchProperty();
                    break;

                case 4:
                    System.out.println("\nThank you for using Real Estate Listing Portal!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    // Add Property
    static void addProperty() {

        System.out.println("\n---------- ADD PROPERTY ----------");

        System.out.print("Enter property name: ");
        String title = sc.nextLine();

        System.out.print("Enter location: ");
        String location = sc.nextLine();

        System.out.print("Enter property type (House/Flat/Plot): ");
        String type = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter area in sq.ft: ");
        double area = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter owner contact: ");
        String contact = sc.nextLine();

        Property property = new Property(
                title,
                location,
                type,
                price,
                area,
                contact
        );

        properties.add(property);

        System.out.println("\nProperty added successfully!");
    }

    // View all properties
    static void viewProperties() {

        if (properties.isEmpty()) {
            System.out.println("\nNo properties available.");
            return;
        }

        System.out.println("\n========== AVAILABLE PROPERTIES ==========");

        for (Property property : properties) {
            property.displayProperty();
        }
    }

    // Search property by location
    static void searchProperty() {

        if (properties.isEmpty()) {
            System.out.println("\nNo properties available.");
            return;
        }

        System.out.print("\nEnter location to search: ");
        String searchLocation = sc.nextLine();

        boolean found = false;

        for (Property property : properties) {

            if (property.location.equalsIgnoreCase(searchLocation)) {
                property.displayProperty();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo property found in " + searchLocation);
        }
    }
}
