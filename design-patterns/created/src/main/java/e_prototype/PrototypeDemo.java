package e_prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  上午 09:46
 * Description:
 */
public class PrototypeDemo {

    private static final Map<String, Animal> animals = new HashMap<>();

    static {
        Dog dog = new Dog();
        dog.setId("A");
        animals.put(dog.getId(), dog);
        Cat cat = new Cat();
        cat.setId("B");
        animals.put(cat.getId(), cat);
    }

    public static Animal get(String id){
        Animal animal = animals.get(id);
        return (Animal) animal.clone();
    }

    public static void main(String[] args) {

        Animal a = get("A");
        a.call();
    }
}
