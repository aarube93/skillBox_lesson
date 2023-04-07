package method_forEach;
import Generics.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> staff = Employee.createAdd(10);
        getSort(staff);
        //Перепишем выражение итератора for в метод forEach() :
        System.out.println("Regular expression: \n");
        for (Employee e : staff) {
            System.out.println(e);
        }
        System.out.println("_____________________________________________________________________________"
                +"\nRegular forEach expression: \n ");
        staff.forEach(employee -> System.out.println(employee)); //---> Это выражение легко трансформируется

        //в более короткое:
        //Так же в этом блоке установим премию каждому сотруднику не посредственно после формирования списка,
        //то-есть просто прибавим нужную сумму:

//        staff.forEach(employee -> {
//            long salary =  employee.getSalary();
//            employee.setSalary(salary + 100_000);
//
//        }); - it's equals:
        int salaryIncrease = 100_000;
        int bonus = 2;
        staff.forEach(e -> e.setSalary((e.getSalary()) * bonus + salaryIncrease));

        System.out.println("_____________________________________________________________________________"
                +"\nshort forEach expression with pointer on the method: \n"
        +"so, plus present for employee: 100_000 rub.");
        staff.forEach(System.out :: println);

    }
    public static void getSort(List<Employee> staff) {
        Collections.sort(staff, Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
        );
        System.out.println("done");
    }
}