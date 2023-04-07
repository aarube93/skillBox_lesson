package Lambda_expressions;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static String staffFile = "data/staff_file.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();
//Ниже разберем сортировку списков по каким-либо параметрам, приведу примеры КАК это сделать и как это сделать удобно
//и как сократить количество кода с помощью лямбда выражений и прочих методов.

//        -Лямбда-выражение является блоком кода с параметрами.
//        -Используйте лямбда-выражение, когда хотите выполнить блок кода в более поздний момент времени.
//        -Лямбда-выражения могут быть преобразованы в функциональные интерфейсы.
//        -Лямбда-выражения имеют доступ к final переменным из охватывающей области видимости.
//         -Ссылки на метод и конструктор ссылаются на методы или конструкторы без их вызова.
//         -Теперь вы можете добавить методы по умолчанию и статические методы к интерфейсам,
//                                                                          которые обеспечивают конкретные реализации.
//           -Вы должны разрешать любые конфликты между методами по умолчанию из нескольких интерфейсов.

        //Сортировка с помощью компоратора:
        System.out.println("Сортировка с помощью компоратора:");
        Collections.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });
        for (Employee e : staff) {
            System.out.println(e);
        }

        //Сортировка с помощью лямбда-выражения для компоратора:
        System.out.println("\nСортировка с помощью лямбда-выражения для компоратора:");
        Collections.sort(staff, (o1, o2) -> o2.getSalary().compareTo(o1.getSalary()));

        for (Employee e : staff) {
            System.out.println(e);
        }

        //Указатели на методы -
        System.out.println("\nСортировка с вызовом указателя на метод в лямбда-выражении: ");
        Collections.sort(staff, Comparator.comparing(Employee::getSalary));

        for (Employee e : staff) {
            System.out.println(e);
        }

    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> Lines = Files.readAllLines(Paths.get(staffFile));
            for (String item : Lines) {
                String[] fragments = item.split("\\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line " + item);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat).parse(fragments[2]))
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}