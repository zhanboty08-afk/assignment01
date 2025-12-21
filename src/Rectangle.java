public class Rectangle {

    private double width;
    private double height;
    private int id;
    private static int idGen = 1;

    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Invalid size");
        this.width = width;
        this.height = height;
        this.id = idGen++;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle{id=" + id + ", width=" + width + ", height=" + height + "}";
    }
    public static void main(String[] args) {
        Rectangle r = new Rectangle(3, 4);
        System.out.println(r);
        System.out.println("Area = " + r.area());
        System.out.println("Perimeter = " + r.perimeter());
    }
}
