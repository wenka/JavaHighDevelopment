package a_factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 02:32
 * Description:
 */
public class AnimalFactory {

    private static Map<String, Class> animalMap;

    static {
        animalMap = new HashMap<>();
        animalMap.put("cat", Cat.class);
        animalMap.put("dog", Dog.class);
    }


    public static Animal getAnimal(String type) {
        if (type == null) {
            return null;
        }
        Class aClass = animalMap.get(type);
        if (aClass == null) {
            return null;
        }
        Animal o = null;
        try {
            o = (Animal) aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }
}
