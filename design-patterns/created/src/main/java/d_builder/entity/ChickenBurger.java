package d_builder.entity;

import d_builder.ab.Burger;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 03:41
 * Description:
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public double price() {
        return 30;
    }
}
