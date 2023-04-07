package exercise_1;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff_file.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        staff.sort((o1, o2) -> {
            int comparison = o1.getSalary().compareTo(o2.getSalary());
            if (comparison == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return comparison;
        });
        for(Employee i : staff) {
            System.out.println(i);
        }
    }

//    public static void sortBySalaryAndAlphabet(List<Find_employee_with_Max_Salary.Employee> staff) {
//        Collections.sort(staff, Comparator.comparing(Find_employee_with_Max_Salary.Employee::getSalary).thenComparing(Find_employee_with_Max_Salary.Employee::getName));
//    }
}
