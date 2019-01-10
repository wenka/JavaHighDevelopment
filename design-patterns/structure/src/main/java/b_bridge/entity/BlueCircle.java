package b_bridge.entity;

import b_bridge.in.DrawAPI;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 02:50
 * Description:
 */
public class BlueCircle implements DrawAPI {
    /**
     * 画圆
     *
     * @param x
     * @param y
     * @param radius
     */
    @Override
    public void drawCicle(int x, int y, int radius) {
        System.out.println("blue circle==> x=" + x + ",y=" + y + ",radius=" + radius);
    }
}
