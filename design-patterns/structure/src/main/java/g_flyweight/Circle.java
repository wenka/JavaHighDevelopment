package g_flyweight;


/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/21  下午 01:30
 * Description:
 */
public class Circle implements Shape {

    public enum Color {
        Black, White, Yellow, Red, Blue
    }

    private Color color;

    private int x;

    private int y;

    private int radius;

    public Circle(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Color:{x=" + x + ",y=" + y + ",radius=" + radius + ",color=" + color.toString() + "}");
    }
}
