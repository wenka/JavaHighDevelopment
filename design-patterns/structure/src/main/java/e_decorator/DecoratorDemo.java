package e_decorator;

import e_decorator.entity.AnimalDecorator;
import e_decorator.entity.Dog;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/16  下午 02:43
 * Description:
 */
public class DecoratorDemo {

    public static void main(String[] args) {
        AnimalDecorator animalDecorator = new AnimalDecorator(new Dog());
        animalDecorator.setColor(AnimalDecorator.Color.BLACK);
        animalDecorator.call();
    }
}
