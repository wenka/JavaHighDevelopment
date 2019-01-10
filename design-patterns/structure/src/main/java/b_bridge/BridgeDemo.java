package b_bridge;

import b_bridge.entity.BlueCircle;
import b_bridge.entity.RedCircle;
import b_bridge.in.Shape;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 03:06
 * Description:
 */
public class BridgeDemo {

    public static void main(String[] args) {
        Shape shape = new Circle(1,2,3,new RedCircle());
        shape.draw();
        Shape shape1 = new Circle(2,4,6,new BlueCircle());
        shape1.draw();
    }
}
