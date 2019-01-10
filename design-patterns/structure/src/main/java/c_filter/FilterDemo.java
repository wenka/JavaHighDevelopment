package c_filter;

import c_filter.criteria.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 03:45
 * Description:
 */
public class FilterDemo {

    public static void main(String[] args) {
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People("A", 10, People.Gender.male));
        peopleList.add(new People("B", 11, People.Gender.female));
        peopleList.add(new People("C", 17, People.Gender.male));
        peopleList.add(new People("D", 18, People.Gender.female));
        peopleList.add(new People("E", 20, People.Gender.male));
        peopleList.add(new People("F", 25, People.Gender.female));

        MaleCriteria maleCriteria = new MaleCriteria();
        FemaleCriteria femaleCriteria = new FemaleCriteria();
        AdultCriteria adultCriteria = new AdultCriteria();
        MinorCriteria minorCriteria = new MinorCriteria();

//        System.out.println("male===>");
//        System.out.println(maleCriteria.meetCriteria(peopleList));
//        System.out.println("female===>");
//        System.out.println(femaleCriteria.meetCriteria(peopleList));
//        System.out.println("adult===>");
//        System.out.println(adultCriteria.meetCriteria(peopleList));
//        System.out.println("minor===>");
//        System.out.println(minorCriteria.meetCriteria(peopleList));

        System.out.println("male and adult:");
        AndCriteria andCriteria = new AndCriteria(maleCriteria, adultCriteria);
        System.out.println(andCriteria.meetCriteria(peopleList));

        System.out.println("female and minor:");
        OrCriteria orCriteria = new OrCriteria(femaleCriteria, minorCriteria);
        System.out.println(orCriteria.meetCriteria(peopleList));

    }
}
