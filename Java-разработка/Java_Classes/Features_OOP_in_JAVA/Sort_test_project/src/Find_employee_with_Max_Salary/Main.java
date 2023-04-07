package Find_employee_with_Max_Salary;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> staff = Employee.createAdd(100_0000);
        getSort(staff);
//        for (Find_employee_with_Max_Salary.Employee e : staff) {
//            System.out.println(e);
//        }
    }
        public static void getSort(List<Employee> staff) {
        Collections.sort(staff, Comparator.comparing(Employee::getTimeOfCreate)
               .thenComparing(Employee::getId)
        );
            System.out.println("done");
    }
}

