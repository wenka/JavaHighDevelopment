package d_builder;

import d_builder.in.Item;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 03:42
 * Description:
 */
public class Meal {

    private List<Item> items;

    public void addItem(Item item) {
        if (items == null) {
            items = new LinkedList<>();
        }
        items.add(item);
    }

    public double getTotalCost() {
        if (items == null || items.isEmpty()) {
            return 0;
        }
        double cost = 0;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItem() {
        if (items == null || items.isEmpty()) {
            return;
        }
        for (Item item : items) {
            System.out.println(item.name() + ":[Packing=" + item.pack().pack() + ",Price=" + item.price() + "]");
        }
    }
}
