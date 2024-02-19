import java.util.Scanner;

interface Shape {
  void calculateArea();
}

class Rectangle implements Shape {
  private double width;
  private double height;

  public Rectangle() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Rectangle height and width: ");
    this.height = scanner.nextInt();
    this.width = scanner.nextInt();
    scanner.close();
  }

  public void calculateArea() {
    System.out.println("Area of Rectangle: " + width * height);
  }
}


class Square implements Shape {
  private double side;

  public Square() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Square side: ");
    this.side = scanner.nextInt();
    scanner.close();
  }

  public void calculateArea() {
    System.out.println("Area of Square: " + side * side);
  }
}


class Circle implements Shape {
  private double radius;
  private static final double PI = 3.14;

  public Circle() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Circle radius: ");
    this.radius = scanner.nextInt();
    scanner.close();
  }

  public void calculateArea() {
    System.out.println("Area of Circle: " + PI * radius * radius);
  }
}

// factory to decide which type of obj create by it type
public class Factory {
  public static Shape getShape(String shapeType) {
    if (shapeType.equalsIgnoreCase("RECTANGLE")) {
      return new Rectangle();
    } else if (shapeType.equalsIgnoreCase("SQUARE")) {
      return new Square();
    } else if (shapeType.equalsIgnoreCase("CIRCLE")) {
      return new Circle();
    } else {
      return new Rectangle();
    }
  }
}
