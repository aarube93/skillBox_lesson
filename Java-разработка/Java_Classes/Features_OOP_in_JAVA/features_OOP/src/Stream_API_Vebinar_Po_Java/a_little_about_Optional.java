package Stream_API_Vebinar_Po_Java;

import java.util.Optional;
import java.util.stream.Stream;

public class a_little_about_Optional {
    public static void main(String[] args) {
        Optional<Integer> shortestString = Stream.of(1, 2, 3, 4)
                .filter(i -> i > 10)
                .max(Integer::compare);
        //Таким образом решать, решение «что делать» если найдено или нет значение мы можем на основе вызова
        // методов Optional:
//Для проверки есть методы isEmpty() и isPresent(), для получения значения метод get().
        if (shortestString.isPresent()) {
            System.out.println(shortestString.get());
        } else {
            System.out.println("Максимальное значение не найдено!");
        }
    }
}
