package d_builder;

import d_builder.entity.ChickenBurger;
import d_builder.entity.Coke;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 03:47
 * Description:
 */
public class BuilderDemo {

    public static void main(String[] args) {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Coke());

        double totalCost = meal.getTotalCost();
        System.out.println("total price:" + totalCost);

        meal.showItem();

    }
}
