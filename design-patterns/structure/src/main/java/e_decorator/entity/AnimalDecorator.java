package e_decorator.entity;

import e_decorator.in.Animal;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/16  下午 01:55
 * Description:
 */
public class AnimalDecorator implements Animal {

    private Animal animal;

    public enum Color {
        BLACK, WHITE
    }

    private Color color;

    public AnimalDecorator(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void call() {
        System.out.println("color:" + getColor());
        animal.call();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
