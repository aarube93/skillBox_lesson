import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
    }
}

// https://www.baeldung.com/java-8-comparator-comparing#1-sample-bean-class
// https://stackoverflow.com/questions/369512/how-to-compare-objects-by-multiple-fields
// https://habr.com/ru/post/224593/
