package Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Generics - это средство языка, позволяющее программировать обобщенно!
 * Ниже создадим класс, который можно будет параметризовать - то есть
 * <передать параметры с которыми работает этот класс вот в таких скокбках>
 */
public class Main {

    public static void main(String[] args) {
        //cache();
        useCalc();
    }

    public static void cache() {
        System.out.println("______________________________________");
        List<Employee> staff = Employee.createAdd(100_0000);
        staff.forEach(System.out::println);

        LRU_Cache<Employee> eLRU_cache = new LRU_Cache<>(5);

        staff.forEach(eLRU_cache::addElement);


        System.out.println(eLRU_cache.size);
        eLRU_cache.getAllElements().forEach(System.out::println);
    }

    public static void useCalc() {
        Calculator test = new Calculator();

        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);

        ArrayList <Double> doubleList = new ArrayList<>();
        doubleList.add(0.1);
        doubleList.add(0.2);
        doubleList.add(0.3);



        System.out.println(test.sum(numberList));
        System.out.println(test.sum(doubleList));

    }
}
