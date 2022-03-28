abstract public class Figure {

    final String type;
    protected final double[] sides;

    protected Figure(double[] sides) {
        this.type = getType();
        this.sides = sides;
    }

    public double getPerimeter() {
        double perimeter = 0;
        for (double side: sides) {
            perimeter += side;
        }
        return perimeter;
    }

    protected String getType() {
        return getClass().getName();
    }

    public abstract double getArea();

    public String toString() {
        return getType() + " and his area: " + getArea() + ", perimeter: " + getPerimeter();
    }
}

class Rectangle extends Figure {

    public Rectangle(double a, double b) {
        super(new double[] {a, b});
    }

    public double getPerimeter() {
        return 2 * super.getPerimeter();
    }

    public double getArea() {
        return sides[0] * sides[1];
    }

    @Override
    public String toString() {
        return getType() + " " + "площадь: " + getArea();
    }
}

class Circle extends Figure {

    public Circle(double radius) {
        super(new double[] {radius});
    }

    @Override
    protected String getType() {
        return "Круг";
    }

    public double getPerimeter() {
        return 2 * 3.14 * sides[0];
    }

    public double getArea() {
        return 3.14 * sides[0] * sides[0];
    }
}

class Triangle extends Figure {

    public Triangle(double a, double b, double c) {
        super(new double[] {a, b, c});
    }

    public double getArea() {
        double p = (sides[0] + sides[1] + sides[2]) / 2;
        return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }
}