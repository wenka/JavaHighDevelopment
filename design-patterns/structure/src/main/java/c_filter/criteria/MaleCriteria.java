package c_filter.criteria;

import c_filter.People;
import c_filter.in.Criteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 03:28
 * Description:
 */
public class MaleCriteria implements Criteria {
    @Override
    public List<People> meetCriteria(List<People> peopleList) {
        List<People> peopleArrayList = peopleList.stream().filter(people -> {
            return people.getGender() == People.Gender.male;
        }).collect(Collectors.toList());
        return peopleArrayList;
    }
}
