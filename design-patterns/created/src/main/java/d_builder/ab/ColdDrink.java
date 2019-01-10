package d_builder.ab;

import d_builder.entity.Bottle;
import d_builder.in.Item;
import d_builder.in.Packing;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 03:37
 * Description: 饮料
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing pack() {
        return new Bottle();
    }

    @Override
    public abstract double price();
}
