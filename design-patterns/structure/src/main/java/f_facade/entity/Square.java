package f_facade.entity;

import f_facade.in.Shape;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/16  下午 02:55
 * Description:
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw Square");
    }
}
