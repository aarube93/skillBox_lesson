package Find_employee_with_Max_Salary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Employee {
    private final String name;
    private final long timeOfCreate;
    private final int id;


    public static List<Employee> createAdd(int countAdd) {
        Random rand = new Random();
        List<Employee> items = new ArrayList<>();
        String[] firstName = {"Misha", "Egor", "Vlad", "Salavat", "Aleksey", "Afanasiy", "Sammat", "Yan",
                "Fedor", "Petr","Ivan"};
        String[] lastName = {"Alexandrov", "Vladimirovich", "Borisovich", "Dmitrievich", "Ivanov",
                "Solodovnikov", "Egorov", "Miroshnichenko", "Karpovich", "Gasanov","Guzeev"};
        for (int i = 0; i < countAdd; i++) {
            String fN = firstName[rand.nextInt((10 - 1) + 1) + 1];
            String lN = lastName[rand.nextInt((10 - 1) + 1) + 1];
            String name = fN +" "+ lN;

            long time = (System.currentTimeMillis());

            int id = (int) (System.currentTimeMillis()/100_00000 + i*2);

            items.add(new Employee(name, time, id));
        }

        return items;
    }

    public Employee(String name, long timeOfCreate, int id) {
        this.name = name;
        this.timeOfCreate = timeOfCreate;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getTimeOfCreate() {
        return timeOfCreate;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return timeOfCreate == employee.timeOfCreate && id == employee.id && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, timeOfCreate, id);
    }

    public String toString() {
        return name + ", time: " + timeOfCreate + ", Id: " + id + ";";
    }
}
