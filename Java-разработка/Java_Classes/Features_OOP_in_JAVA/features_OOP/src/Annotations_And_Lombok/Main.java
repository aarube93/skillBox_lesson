package Annotations_And_Lombok;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Employee_for_lombok> staff = Employee_for_lombok.createAdd(1000_000);
        staff.forEach(System.out::println);

    }
}
