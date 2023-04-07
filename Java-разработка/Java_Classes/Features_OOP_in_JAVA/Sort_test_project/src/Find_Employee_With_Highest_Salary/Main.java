package Find_Employee_With_Highest_Salary;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
public class Main {

    private static final String STAFF_TXT = "data/staff_file.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {

        return staff.stream()
                .filter(employee -> {
                    Calendar c = Calendar.getInstance();
                    c.setTime(employee.getWorkStart());
                    return c.get(Calendar.YEAR) ==year;

                })
                .max(Comparator.comparing(Employee::getSalary))
                .get();

    }
}