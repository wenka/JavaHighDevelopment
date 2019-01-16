package f_facade;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/16  下午 02:58
 * Description:
 */
public class FacadeDemo {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawSquare();
    }
}
