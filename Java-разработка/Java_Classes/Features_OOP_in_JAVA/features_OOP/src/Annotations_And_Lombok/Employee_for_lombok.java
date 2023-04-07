package Annotations_And_Lombok;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Employee_for_lombok {
    private String name;
    private long salary;
    private int id;

    public static List<Employee_for_lombok> createAdd(int countAdd) {
        Random rand = new Random();
        List<Employee_for_lombok> items = new ArrayList<>();
        String[] firstName = {"Misha", "Egor", "Vlad", "Salavat", "Aleksey", "Afanasiy",
                "Sammat", "Yan", "Fedor", "Petr", "Ivan"};

        String[] lastName = {"Alexandrov", "Vladimirovich", "Borisovich", "Dmitrievich", "Ivanov",
                "Solodovnikov", "Egorov", "Miroshnichenko", "Karpovich", "Gasanov", "Guzeev", "Petrovich", "Baranov"};

        for (int i = 0; i < countAdd; i++) {
            String fN = firstName[rand.nextInt((10 - 1) + 1) + 1];
            String lN = lastName[rand.nextInt((12 - 1) + 1) + 1];
            String name = fN + " " + lN;

            long salary = (int) ((Math.random() * (45_000)) + 85_000);
            ;

            int id = (int) (System.currentTimeMillis() / 10_000_000 + i * 2);

            items.add(new Employee_for_lombok(name, salary, id));
        }

        return items;
    }

    public Employee_for_lombok(String name, long salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee_for_lombok employee = (Employee_for_lombok) o;
        return salary == employee.salary && id == employee.id && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, id);
    }

    public String toString() {
        return name + ", salary: " + salary + ", Id: " + id + ";";
    }
}