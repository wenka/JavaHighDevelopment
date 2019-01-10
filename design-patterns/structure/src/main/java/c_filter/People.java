package c_filter;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 03:25
 * Description:
 */
public class People {

    public enum Gender {
        male, female
    }

    private String name;

    private int age;

    private Gender gender;

    public People(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nPeople{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                "}\n";
    }
}
