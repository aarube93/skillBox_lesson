package Stream_API_Vebinar_Po_Java;

import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class intermediateStreamOperators_API {
    public static void main(String[] args) {
        makeStream();
        StreamFilter();
        randomCafe();
    }

    //Получаем стрим -Это поток определенных значений который присущ возвращаемым значениям этого стрима.
// Вот например: intermediate operators
    private static void makeStream() {
        Stream.of("111", "33", "java")
                .map(String::length)
                .map((i) -> i * 4)
                .peek(x -> System.out.println("method peek: " + x))
                .map(String::valueOf)
                .map(String::length)
                .forEach(System.out::println);
    }

    private static void StreamFilter() {
        Stream.of(11, 33, 3, 9, 4, 2, 1, 333)
                .filter(n -> n % 3 == 0)
                .forEach(System.out::println);

        Stream.of("111", "33", "java", "", "  ")
                .filter(String::isBlank)//.filter(s -> s.isBlank())
                .forEach(System.out::println);

        Stream.of("111", "33", "java", "", "  ")
                .filter(s -> s.contains("a"))
                .filter(Predicate.not(s -> s.contains("b")))
                .filter(Predicate.not(String::isBlank))//== .filter(s -> !s.isBlank())
                .filter(Predicate.not(String::isEmpty))
                .filter(String::isEmpty)
                .filter(Predicate.isEqual("33"))
                .forEach(System.out::println);
    }

    private static void distinct() {
        Stream.of("Skillbox", "JetBrains", "VK", "Skillbox")
                .distinct()
                .forEach(System.out::println);
    }

    private static void randomCafe() {
        Random random = new Random(0xCAFE); //рандом с указанием seed
        Stream.generate(() -> random.nextInt(6)) //случайный int от 0 до 5 включительно
                .limit(10)
                .distinct()
                .map(x -> ++x) //добавляем +1 к каждому значению
                .forEach(System.out::println);
    }
}