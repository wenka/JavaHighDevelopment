package b_abstract_factory.factory;

import b_abstract_factory.in.Color;
import a_factory.Animal;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 02:48
 * Description:
 */
public abstract class AbstractFactory {

    public abstract Animal getAnimal(String type);

    public abstract Color getColor(String color);
}
