import java.awt.*;

public class SizeName {
    private final String name;
    private final int size;

    public SizeName(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
