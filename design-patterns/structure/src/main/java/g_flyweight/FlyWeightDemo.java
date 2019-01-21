package g_flyweight;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/21  下午 01:39
 * Description:
 */
public class FlyWeightDemo {

    public static void main(String[] args) {
        Circle circle = (Circle)ShapeFactory.getShape(Circle.Color.Black);
        circle.setX(50);
        circle.setY(60);
        circle.setRadius(100);
        circle.draw();

        Circle circle1 = (Circle)ShapeFactory.getShape(Circle.Color.Yellow);
        circle1.setX(40);
        circle1.setY(70);
        circle1.draw();

        Circle circle2 = (Circle)ShapeFactory.getShape(Circle.Color.Black);
        circle2.setX(30);
        circle2.setY(80);
        circle2.draw();
    }
}
