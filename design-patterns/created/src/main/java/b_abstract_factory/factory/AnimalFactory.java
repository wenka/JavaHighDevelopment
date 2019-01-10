package b_abstract_factory.factory;

import b_abstract_factory.in.Color;
import a_factory.Animal;
import a_factory.Cat;
import a_factory.Dog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 02:50
 * Description:
 */
public class AnimalFactory extends AbstractFactory {

    private static Map<String, Class> animalMap;

    static {
        animalMap = new HashMap<String, Class>();
        animalMap.put("cat", Cat.class);
        animalMap.put("dog", Dog.class);
    }

    @Override
    public Animal getAnimal(String type){
        if (type == null) {
            return null;
        }

        Class aClass = animalMap.get(type);
        if (aClass == null) {
            return null;
        }
        Object o = null;
        try {
            o = aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Animal) o;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
