package c_filter.criteria;

import c_filter.People;
import c_filter.in.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 03:35
 * Description:
 */
public class AndCriteria implements Criteria {

    private List<Criteria> criteriaList;

    public AndCriteria(Criteria... criteriaList) {
        this.criteriaList = new ArrayList<>();
        for (Criteria criteria : criteriaList) {
            this.criteriaList.add(criteria);
        }
    }

    @Override
    public List<People> meetCriteria(List<People> peopleList) {
        if (!criteriaList.isEmpty()) {
            for (Criteria criteria : criteriaList) {
                peopleList = criteria.meetCriteria(peopleList);
            }
        }
        return peopleList;
    }
}
