import java.util.ArrayList;

public class ArrayListFunctions {
    public static void main(String[] args) {

    }

    public static void Lesson() {
        ArrayList<String> people = new ArrayList<String>();
        // добавим в список ряд элементов
        people.add("Tom");
        people.add("Alice");
        people.add("Kate");
        people.add("Sam");
        people.add(1, "Bob"); // добавляем элемент по индексу 1

        System.out.println(people.get(1));// получаем 2-й объект
        people.set(1, "Robert"); // установка нового значения для 2-го объекта edit

        System.out.printf("ArrayList has %d elements \n", people.size());
        for (
                String person : people) {

            System.out.println(person);
        }
        // проверяем наличие элемента
        if (people.contains("Tom")) {

            System.out.println("ArrayList contains Tom");
        }

        // удалим несколько объектов
        // удаление конкретного элемента
        people.remove("Robert");
        // удаление по индексу
        people.remove(0);

        Object[] peopleArray = people.toArray();
        for (
                Object person : peopleArray) {

            System.out.println(person);
        }
    }
}
//Для создания простых списков применяется интерфейс List, который расширяет функциональность интерфейса Collection.
// Некоторые наиболее часто используемые методы интерфейса List:

//void add(int index, E obj): добавляет в список по индексу index объект obj

//boolean addAll(int index, Collection<? extends E> col): добавляет в список по индексу index все элементы
//  коллекции col. Если в результате добавления список был изменен, то возвращается true, иначе возвращается false

//E get(int index): возвращает объект из списка по индексу index

//int indexOf(Object obj): возвращает индекс первого вхождения объекта obj в список.
// Если объект не найден, то возвращается -1

//lastIndexOf(Object obj): возвращает индекс последнего вхождения объекта obj в список.
// Если объект не найден, то возвращается -1

//ListIterator<E> listIterator (): возвращает объект ListIterator для обхода элементов списка

//static <E> List<E> of(элементы): создает из набора элементов объект List

//E remove(int index): удаляет объект из списка по индексу index, возвращая при этом удаленный объект

//E set(int index, E obj): присваивает значение объекта obj элементу, который находится по индексу index
//
//void sort(Comparator<? super E> comp): сортирует список с помощью компаратора comp

//List<E> subList(int start, int end): получает набор элементов, которые находятся в списке между индексами start и end

//По умолчанию в Java есть встроенная реализация этого интерфейса - класс ArrayList.
// Класс ArrayList представляет обобщенную коллекцию, которая наследует свою функциональность от класса AbstractList
// и применяет интерфейс List. Проще говоря, ArrayList представляет простой список, аналогичный массиву,
// за тем исключением, что количество элементов в нем не фиксировано.

//        ArrayList имеет следующие конструкторы:
//
//        ArrayList(): создает пустой список
//
//        ArrayList(Collection <? extends E> col): создает список, в который добавляются все элементы коллекции col.
//
//        ArrayList (int capacity): создает список, который имеет начальную емкость capacity
//
//        Емкость в ArrayList представляет размер массива, который будет использоваться для хранения объектов.
//        При добавлении элементов фактически происходит перераспределение памяти - создание нового массива и
//        копирование в него элементов из старого массива. Изначальное задание емкости ArrayList позволяет снизить
//        подобные перераспределения памяти, тем самым повышая производительность.
