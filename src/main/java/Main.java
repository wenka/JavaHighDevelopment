import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.awt.*;
import java.awt.event.*;

public class Main {




    public static int print(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (; ; ) {
            String a = "i = " + i;
            arrayList.add(a);
        }
    }

}

class People {

    private String name;

    private int age;

    public People() {
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj == null) {
            return false;
        }

        if (obj instanceof People) {

            People people = (People) obj;

            if (this.getName().equals(people.getName())
                    && this.getAge() == this.getAge()
            ) {
                return true;
            }
        }
        return result;
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public People setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public People setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}