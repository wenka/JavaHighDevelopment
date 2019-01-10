package d_builder.ab;

import d_builder.entity.Wrapper;
import d_builder.in.Item;
import d_builder.in.Packing;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 03:36
 * Description: 汉堡
 */
public abstract class Burger implements Item {

    @Override
    public Packing pack() {
        return new Wrapper();
    }

    @Override
    public abstract double price();
}
