import java.util.*;

public class lesson_1 {
    public static void main(String[] args) {
        hashSetLesson();
    }

//HashSet - коллекция уникальных элементов. При выводе будут выведены только не повторяющиеся элементы.
    public static void hashSetLesson() {
        HashSet<String> words = new HashSet<>();
        words.add("Первое");
        words.add("Второе");
        words.add("Третье");
        words.add("Второе");
        words.add("1");
        words.add("12");
        words.add("123");
        words.add("!@#$%^&*()(*&^%$#@!@#$%^&*()");
        words.add("мама мыла раму");//Объекты в такую коллекцию преобразовываются и хранятся в неком хеше,
        // по которому объект легко найти
        for (String word : words) {
            System.out.println(word);
        }
        words.contains("Второе");//Вернет тру или фолс.
        words.equals("Второе");//Аналогично??
    }

}
