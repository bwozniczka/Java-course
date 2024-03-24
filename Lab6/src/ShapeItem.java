import java.awt.Shape;

public class ShapeItem {
    private final String name;
    private final Shape shape;

    public ShapeItem(String name, Shape shape) {
        this.name = name;
        this.shape = shape;
    }

    @Override
    public String toString() {
        return name;
    }

    public Shape getShape() {
        return shape;
    }
}