package d_builder.entity;

import d_builder.in.Packing;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 03:33
 * Description: 瓶装
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle!";
    }
}
