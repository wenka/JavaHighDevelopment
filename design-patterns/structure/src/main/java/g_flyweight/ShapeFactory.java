package g_flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/21  下午 01:35
 * Description:
 */
public class ShapeFactory {

    private static final Map<Circle.Color, Shape> shapeMap = new HashMap();

    public static Shape getShape(Circle.Color color) {
        Shape shape = shapeMap.get(color);
        if (shape == null) {
            shape = new Circle(color);
            shapeMap.put(color, shape);
        }
        return shape;
    }
}
