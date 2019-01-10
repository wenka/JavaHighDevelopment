package e_prototype;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  上午 09:45
 * Description:
 */
public class Cat extends Animal {

    public Cat() {
        this.setName("Cat");
    }

    @Override
    void call() {
        System.out.println(this.getId() + "=" + this.getName() + ">Meow! Meow! Meow!");
    }
}
