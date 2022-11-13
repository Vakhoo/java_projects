public class Circle implements IFigure {
    private  double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public double getPerimeter() {
        return Math.PI * 2*radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

}
