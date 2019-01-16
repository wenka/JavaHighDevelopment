package d_composite;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/16  下午 01:41
 * Description:
 */
public class CompositeDemo {

    public static void main(String[] args) {

        Employee CEO = new Employee("ceo", "CEO", 300000);

        Employee aHead = new Employee("AA", "head A-DEPT", 20000);
        Employee bHead = new Employee("BB", "head B-DEPT", 21000);

        Employee a = new Employee("a", "A-DEPT", 5000);
        Employee b = new Employee("b", "A-DEPT", 5500);
        Employee c = new Employee("c", "B-DEPT", 4500);
        Employee d = new Employee("d", "B-DEPT", 6000);

        aHead.add(a);
        aHead.add(b);
        bHead.add(c);
        bHead.add(d);

        CEO.add(aHead);
        CEO.add(bHead);

        System.out.println(CEO);
        for (Employee employee: CEO.getEmployeeList()){
            System.out.println(employee);
            for (Employee e: employee.getEmployeeList()){
                System.out.println(e);
            }
        }
    }
}
