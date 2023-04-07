package Stream_API_Vebinar_Po_Java;

import java.nio.file.ProviderNotFoundException;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class terminalStreamOperators_API {
    public static void main(String[] args) {

    }

    private static void terminalsOperators() {//Метод завершает стрим и передает полученное в печать. После завершения
// печати работать с этим экземпляром стрим невозможно(тех.ограничение)
        Stream.of("Skillbox", "JetBrains", "VK", "Skillbox")
                .distinct()
                .forEach(System.out::println);

        Stream.of("Skillbox", "JetBrains", "VK", "Skillbox")
                .distinct()
                .count();//==3
    }

    private static void minMaxInStream() {
        Optional<String> MaxTestString = Stream.of("a", "bb", "ccc", "d")
                .max(Comparator.comparing(String::length));

        Optional<String> minTestString = Stream.of("a", "bb", "ccc", "d")
                .min(Comparator.comparing(String::length));
    }

    private static void OptionalInStream() throws ClassNotFoundException {
//вернуть значение по умолчанию
        int max1 = Stream.of(1, 2, 3, 4)
                .filter(i -> i > 10)
                .max(Integer::compare)
                .orElse(0) ;
//выбросить исключение
        int max2 = Stream.of(1, 2, 3, 4)
                .filter(i -> i > 10)
                .max(Integer::compare)
                .orElseThrow(() -> new ProviderNotFoundException());
    }

    private static void matchInStream() {
//        Stream API – терминальные операторы
//.anyMatch()
        //возвращает true, если найден хотя бы один элемент соответствующий условию
        boolean hasMoreThan10 = Stream.of(1, 2, 3, 4)
                .anyMatch(i -> i > 10); //false
//.noneMatch()
        //возвращает true, если все элементы НЕ соответствуют условию
        boolean allMoreThan10 = Stream.of(1, 2, 3, 4)
                .noneMatch(i -> i > 10); //true
//.allMatch()
        //возвращает true, если все элементы соответствуют условию
        boolean allLessThan10 = Stream.of(1, 2, 3, 4)
                .allMatch(i -> i > 10); //false
    }
    //.findFirst
    //.findAny
    //.
}
