package Stream_API_Vebinar_Po_Java;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class toMap {
    public static void main(String[] args) {
        Map<String, Person> map =
                Stream.of(new Person("1"), new Person("2"), new Person("3"))
                        .collect(Collectors.toMap(Person::getPhone, Function.identity()));
//        Function.identity() - Указывает на объект, который находится в стриме
//В случае, если ключ указан одинаковый выпадет ошибка. При формировании кода нужно самому решить что сделать с совпадением,
//      код такой:
        Map<String, Person> mapR =
                Stream.of(new Person("1"), new Person("1"))
                        .collect(Collectors.toMap(Person::getPhone, Function.identity(),
                                (existing, current) -> existing));

//Предположим что нам нужно посчитать количество одинаковых элементов в списке:
        Map<String, Integer> mapExist =
                Stream.of("a", "a", "c", "ba", "c", "a","b","$")
                        .collect(Collectors
                                .toMap(Function.identity(),
                                        (s) -> 1,
                                        (existing, current) -> ++existing));
        Stream.of(mapExist).forEach(System.out::println);


        
        Map<String, Long> mapExistCountDifficultMethod =
                Stream.of("a", "a", "c", "b", "c", "a")
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Stream.of(mapExistCountDifficultMethod).forEach(System.out::println);
    }
}

class Person {
    private final String phone;

    Person(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" + "phone='" + phone + '\'' + '}';
    }
}
