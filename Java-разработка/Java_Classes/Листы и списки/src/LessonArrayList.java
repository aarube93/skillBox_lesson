import java.util.ArrayList;

public class LessonArrayList {
    public static void main(String[] args) {
        arrayList();
        fastInitialArrayList();

    }
//Список нужен для того, что бы элементы можно было динамично добавлять и удалять. Удобнее тем, что не привязан к
//определенному количеству элементов, как например в массиве.

    //ArrayList - самый распространенный класс для хранения списков. Есть и другие классы.
    public static void arrayList() {
        ArrayList<String> todoLIst = new ArrayList<>();
        todoLIst.add("The first our business");
        todoLIst.add(0, "The second our business");//При использовании метода с индексом-при указании
// 0 - будет выведено на первое место. При указании несуществующего места в списке,
//например -1 или на (хотя бы) на 2 единицы больше, чем последняя запись - выпадет ошибка выполнения кода.
//Вывести список можно 2мя способами:
        for (int i = 0; i < todoLIst.size(); i++) {//Получение размера списка происходит свойством .size
            System.out.println("Более сложный метод: " + todoLIst.get(i));//Вывод по i с помощью вызова метода get
        }
//Более простой вызов с помощью специального синтаксиса цикла for():
        for (String item : todoLIst) {//Печатает без перебора по индексу
            System.out.println("Простая запись: " + item);
        }
    }

    public static void fastInitialArrayList() {
//Указывание объекта в угловых скобочках <> называют типизацией. Элемент, указанный в скобках, говорит о типе данных,
//хранящихся в списке.
        ArrayList<String> todoList = new ArrayList<>() {{
            add("First");
            add("Second");
            add("Third");
        }};
        todoList.add(0, "Null");
        todoList.add("Fourth");
        todoList.add("Fifth");
        todoList.remove(0);

        for (String item : todoList) {
            System.out.println(item);
        }
    }
}
