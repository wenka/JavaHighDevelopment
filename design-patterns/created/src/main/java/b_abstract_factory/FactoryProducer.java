package b_abstract_factory;

import b_abstract_factory.factory.AbstractFactory;
import b_abstract_factory.factory.AnimalFactory;
import b_abstract_factory.factory.ColorFactory;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 02:55
 * Description:
 */
public class FactoryProducer {

    public static AbstractFactory buildFactory(String factoryType) {
        if (factoryType == null) {
            return null;
        }
        if (factoryType.equals("animal")) {
            return new AnimalFactory();
        } else if (factoryType.equals("color")) {
            return new ColorFactory();
        } else {
            return null;
        }
    }
}
