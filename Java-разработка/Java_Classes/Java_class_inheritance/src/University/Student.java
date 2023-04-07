package University;


public class Student {
    String firstName, lastName, group;
    double averageMark;

    public Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public Student() {

    }
}

class Aspirant extends Student {
    boolean hasScientistArticle;

    public Aspirant(String firstName, String lastName, String group, double averageMark, boolean hasScientistArticle) {
        super(firstName, lastName, group, averageMark);
    }
}
