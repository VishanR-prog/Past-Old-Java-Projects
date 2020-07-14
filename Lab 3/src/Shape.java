public abstract class Shape {
    private String colour;

    public Shape(String color) {
        setColour(color);
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String color) {
        this.colour = color;
    }

    public float getArea() {
        return 0;
    }

    public float getPerimeter() {
        return 0;

    }

    @Override
    public String toString() {
        return "colour is " + colour +  "]";
    }
}

class Rectangle extends Shape {
    private float width;
    private float length;


    public Rectangle(String color, float width, float length) {
        super(color);
        setWidth(width);
        setLength(length);
    }

    public float getWidth() {
        return width;

    }

    public void setWidth(float userWidth) {
        if (userWidth < 0.0 || userWidth > 20.0) {
            throw new IllegalArgumentException(Float.toString(width));
        } else {
            width = userWidth;
        }
    }

    public float getLength() {
        return length;
    }

    public void setLength(float userLength) {
        if (userLength < 0.0 || userLength > 20.0) {
            throw new IllegalArgumentException(Float.toString(length));
        } else {
            length = userLength;
        }
    }

    public float getPerimeter() {
        return length + length + width + width;
    }

    public float getArea() {
        return this.width * this.length;
    }
    @Override
    public String toString() {
        return "Rectangle[length is " + length + " , width is " + width + ", " + super.toString() + "]";
    }
}




class TestShape {
    public static void main(String[] args) {
        java.util.ArrayList<Shape> shapes = new java.util.ArrayList<>();
        shapes.add(new Circle("Red", 2.0f));
        shapes.add(new Rectangle("Blue", 1.5f, 3.0f));
        for (Shape shape : shapes) {
            System.out.println("");
            System.out.println(shape.toString());
            System.out.printf("Area : %.2f\n", shape.getArea());
            System.out.printf("Perimeter: %.2f\n", shape.getPerimeter());
        }
    }
}
class Circle extends Shape {
    private float radius;

    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }

    public float getPerimeter() {
        return 2 * (float) Math.PI * this.radius;
    }

    public float getArea() {
        return (float) Math.PI * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return "Circle[radius is " + radius + " , " + super.toString() + "]";
    }
}

