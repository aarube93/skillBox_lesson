package reduce_function;
import Generics.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> staff = Employee.createAdd(100);
        getSort(staff);
    }
    public static void getSort(List<Employee> staff) {
/**
  Reduce - концепция создана для распределенных вычислений, что бы можно было брать какие-то данные и распределять
  их по разным серверам, рабочим станциям, машинам и после обработки собирать на одну рабочую машину. Но так же
  применимы к малым объемам данных и лаконичны реализованы в стрим апи:
  */
        staff.stream()
                .map(e->e.getSalary())
                .filter(s->s > 0)
                .reduce(Long::sum)
                .ifPresent(System.out::println);
    }
}
