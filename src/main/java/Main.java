import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");

//        double a = 1234567890.0987654321;
//        System.out.println(a);
//        System.out.println(BigDecimal.valueOf(a).setScale(10,BigDecimal.ROUND_HALF_UP));
//
//        Object o = a;
//        System.out.println(o instanceof Number);
//        System.out.println(BigDecimal.valueOf((double)o));
//
//        List<Integer> ints = new ArrayList<>();
//        List<String> collect = ints.stream().map(Main::toString).collect(Collectors.toList());
//        List<String> collect2 = ints.stream().map(x->x.toString()).collect(Collectors.toList());

        ConcurrentLinkedQueue<Integer> integers = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 100; i++) {
            integers.offer(i);
        }

        List<Integer> integerList = new ArrayList<>();
        while (integerList.size() < 50){
            integerList.add(integers.poll());
        }

        System.out.println(integers);
        System.out.println(integerList);

    }

    public static String toString(Integer a) {
        return String.valueOf(a);
    }
}
