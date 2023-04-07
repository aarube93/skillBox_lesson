import java.util.StringJoiner;

public class JoinAnotherStr {
    public static void main(String[] args) {
        joinerString();
        stringJoinerClass();
        templateToString();

    }

    public static void joinerString() {
        String name1 = "Alex";
        String name2 = "John";
        String name3 = "Anna";

        StringJoiner joinerStr = new StringJoiner(", \n");

        joinerStr.add(name1);
        joinerStr.add(name2);
        joinerStr.add(name3);

        System.out.println(joinerStr);
    }

    public static void stringJoinerClass() {
        String name1 = "Alex";
        String name2 = "John";
        String name3 = "Anna";
        String list = String.join(", ", name1, name2, name3);

        System.out.println(list);
    }

    public static void templateToString() {
        String name = "Alexandr";
        int birthYear = 1993;
//Нужно оформить вывод по формату: {"name : "Alexandr", "birthYear": "1986"}
        String template = "{\"name : \"%s\", \"birthYear\": \"%d\"}";
        String result = String.format(template, name, birthYear);

        System.out.println(result);
//Либо еще такой вариант через System.out.printf(""); - все параметры шаблон и переменные задаются в скобках :
        System.out.printf(template, name, birthYear);
//Основные элементы форматирования строк:
//      %s - Строка(String)
//      %d - Целое число
//      %а - float/double
//      %b - boolean
//      %n - перенос строки
//      %t - Дата
//      %% - Символ процента
    }
}
