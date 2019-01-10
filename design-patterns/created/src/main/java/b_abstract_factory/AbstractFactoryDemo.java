package b_abstract_factory;

import b_abstract_factory.factory.AbstractFactory;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 02:57
 * Description:
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        AbstractFactory color = FactoryProducer.buildFactory("color");
        color.getColor("yellow").coat();

        AbstractFactory animal = FactoryProducer.buildFactory("animal");
        animal.getAnimal("dog").call();
    }
}
