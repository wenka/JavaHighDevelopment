package b_abstract_factory.factory;

import b_abstract_factory.entity.Black;
import b_abstract_factory.entity.Yellow;
import b_abstract_factory.in.Color;
import a_factory.Animal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 02:53
 * Description:
 */
public class ColorFactory extends AbstractFactory {

    private static Map<String, Class> colorMap;

    static {
        colorMap = new HashMap<String, Class>();
        colorMap.put("yellow", Yellow.class);
        colorMap.put("black", Black.class);
    }

    @Override
    public Animal getAnimal(String type) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }

        Class aClass = colorMap.get(color);
        if (aClass == null) {
            return null;
        }
        Object o = null;
        try {
            o = aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Color) o;
    }
}
