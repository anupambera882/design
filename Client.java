import java.util.Scanner;

// Client how can use this service
public class Client {
  public static void main(String[] args) {
    // Factory
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter shape:");
    String shape = scanner.nextLine();
    Shape shapeType = Factory.getShape(shape.toUpperCase());
    shapeType.calculateArea();

    // AbstractFactory
    System.out.println("Enter your machine OS:");
    String osType = scanner.nextLine();
    IFactory fact = GUIAbstractFactory.createFactory(osType.toLowerCase());
    IButton button = fact.createButton();
    button.press();
    ITextBox textBox = fact.createTextBox();
    textBox.showText();
    scanner.close();

    // Creating a Person using the builder
    Person person = new Person.PersonBuilder()
        .name("anupam")
        .age(30)
        .address("123 Main St")
        .phoneNumber("555-1234")
        .build();

    // Accessing fields of the person object
    System.out.println("Name: " + person.toString());

  }
}