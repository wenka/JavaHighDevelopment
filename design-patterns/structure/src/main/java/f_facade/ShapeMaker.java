package f_facade;

import f_facade.entity.Circle;
import f_facade.entity.Square;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/16  下午 02:55
 * Description:
 */
public class ShapeMaker {

    private Circle circle;

    private Square square;

    public ShapeMaker() {
        this.circle = new Circle();
        this.square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawSquare(){
        square.draw();
    }
}
