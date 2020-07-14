public abstract class Shape2 {
    private String name;

    public Shape2(String name) {
        this.name = name;
    }

    public abstract double getArea();

    public final int compareTo(Shape2 other) {
        double difference = getArea() - other.getArea();
        if (difference < 0)
            return -1;
        else if (difference == 0)
            return 0;
        else // difference > 0
            return 1;
    }



    public final String toString() {
        return name + "'s area: ";
    }
}

class Rectangle2 extends Shape2 {
    private double length;
    private double width;

    public Rectangle2(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return this.length * this.width;
    }
}

class Square2 extends Shape2 {
    private double length;

    public Square2(double length) {
        super("Square");
        this.length = length;
    }

    public double getArea() {
        return this.length * this.length;
    }
}

class Shape2Test {
    public static void main(String[] args) {
        java.util.ArrayList<Shape2> shapes = new java.util.ArrayList<>();
        shapes.add(new Square2(2.0f));
        shapes.add(new Rectangle2( 1.5f, 3.0f));
        for (Shape2 shape : shapes) {
            System.out.println("");
            System.out.println(shape.toString());
            System.out.printf("Area : %.2f\n", shape.getArea());
        }

    }
}
