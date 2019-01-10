package a_factory;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 02:36
 * Description:
 */
public class FactoryDemo {

    public static void main(String[] args) {

        AnimalFactory.getAnimal("cat").call();
        AnimalFactory.getAnimal("dog").call();
//        AnimalFactory.getAnimal("pig").call();
    }
}
