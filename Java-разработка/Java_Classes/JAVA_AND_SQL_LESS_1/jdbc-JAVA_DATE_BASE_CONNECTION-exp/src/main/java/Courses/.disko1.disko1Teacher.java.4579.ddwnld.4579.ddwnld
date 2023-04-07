package Courses;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;
    private int age;


    public Teacher(int id, String name, int salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Teacher() {
    }
}
