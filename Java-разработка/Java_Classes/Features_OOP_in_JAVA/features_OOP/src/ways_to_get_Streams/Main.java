package ways_to_get_Streams;

import Generics.Employee;

import java.util.*;
import java.util.stream.Stream;


public class Main {
    static final String separator = "\n------------------------------------------------------------------" +
            "------------------------------------------------------\n";
    //Stream API - это объект интерфейса стрим, который можно получить разными способами и
//работать со множеством элементов коллекций, массивов(ну и так далее) в функциональном стиле, не создавая циклы.

    public static void main(String[] args) {
        List<Employee> staff = Employee.createAdd(1_000_000);
        // getSort(staff);
        //Методы с уроками:
        //workWithStreams();
        makeStreamOf(staff);
        // getMaxAndMinAlsoSortOfStream(staff);
    }

    public static void workWithStreams() {
        System.out.println(separator + "lesson of Stream. Get stream of numbers: ");

        //Как вызвать метод стрим и что это по сути такое:
        //1. Можно получить стрим из множества элементов, такого как массив, например:
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //например, что бы распечатать каждое второе число, мы можем вызвать у объекта метод фильтра и указать условия:
        numbers.filter(n -> n % 2 == 0).forEach(System.out::println); //-то есть наполнить стрим, получить его, можно
        //через статичный метод .of
        System.out.println(separator);
        //получить стрим так же можно из массива, вот представьте у нас есть массив Integer например:
        Integer[] integerMassive = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(integerMassive).filter(n -> n % 2 == 0).forEach(System.out::println);
        //В примере выше мы получаем стрим из массива - с помощью метода стрим вызванного у класса Arrays
        System.out.println(separator);
//Так же стримы могут генерировать бесконечные итерации и, например, выводить числа, символы или части символов и
//из строки по выставленному фильтру, пару таких примеров приведу ниже без дальнейших комментариев:
        Stream.iterate(1,n -> n + 1).forEach(System.out :: println);
        Stream.generate(()->"AaBbCcDd").forEach(System.out::println);
         //"kcnsdojvbaodnclkn9876".chars().filter().forEach(System.out::println); //- тут я не знаю еще какие данные
//использовать для фильтрации по символам, видимо реджексы?
    }

    public static void getMaxAndMinAlsoSortOfStream(List<Employee> staff) {
        //например можем взять и просто отсортировать, скажем по зарплате или другому параметру:
        System.out.println(separator + "Сортировка стрима по ЗП и Имени:" + separator);
        staff.stream().sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .forEach(System.out::println);

        System.out.println(separator + "Max salary of Find_employee_with_Max_Salary.Employee<staff> : " + separator);
//вот таким образом можно получить max и min значение через стримы по параметру, вызов макс и мин возвращает
//объект optional:
        //  Optional<Find_employee_with_Max_Salary.Employee> opt =  staff.stream().max(Comparator.comparing(Find_employee_with_Max_Salary.Employee :: getSalary));
        staff.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);
    }

    public static void makeStreamOf(List<Employee> staff) {
//--------------------------------------------------------------------------------------------------------------------//
        //Например, мы хотим напечатать не все элементы коллекции, а только те, которые удовлетворяют условиям - например,
//сотрудников с полем salary ниже 100_000 рублей: -Один из примеров того, как работают стримы
        System.out.println(separator + "below there is list of employee, which salary below a hundred thousand: "
                + separator);

//        Stream<Find_employee_with_Max_Salary.Employee> stream = staff.stream();
//        stream.filter(employee -> employee.getSalary() < 100_000).forEach(System.out :: println );

//Код можно (и нужно) сократить вот таким образом, как здесь: работают абсолютно одинаково.
        //  staff.stream().filter(e -> e.getSalary() <= 100_000).forEach(System.out::println);
        staff.stream().filter(e -> e.getName().equals("Ivan Ivanov")).forEach(System.out::println);
    }

    public static void getSort(List<Employee> staff) {
        Collections.sort(staff, Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getId)
        );
        System.out.println("done");
    }
}
