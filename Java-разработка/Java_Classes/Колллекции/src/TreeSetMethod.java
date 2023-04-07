//  https://www.codeflow.site/ru/article/java-tree-set

import java.util.*;

public class TreeSetMethod {
    public static void main(String[] args) {
        treeSetLesson();
        treeSetIterator();
        whenIteratingTreeSet();
        whenRemovingElementAfterUsingIterator();
        whenCheckingFirstElement();
        whenCheckingLastElement();
        whenUsingSubSet();
        whenUsingHeadSet();
        whenUsingTailSet();
    }
    public static void treeSetLesson() {
        TreeSet<String> words = new TreeSet<>();
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
            System.out.println("второй метод: " + word);
        }
        words.contains("Второе");//Вернет тру или фолс.
        words.equals("Второе");//Аналогично??
    }


    //Метод iterator () возвращает итератор, повторяющийся в возрастающем порядке по элементам Set.
//Эти итераторы работают быстро.
//Мы можем наблюдать восходящий порядок итераций здесь:
    public static void treeSetIterator() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        treeSet.add("Third");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    //Кроме того, TreeSet позволяет нам перебирать Set в порядке убывания.
//Давайте посмотрим, что в действии:
    public static void whenIteratingTreeSet() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.descendingIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
//        Iterator генерирует исключение _ConcurrentModificationException, если набор модифицируется в любое время
//после создания итератора любым способом, кроме как через метод remove () _ итератора.
    }
    //    Давайте создадим тест для этого:
    public void whenModifyingTreeSetWhileIterating__shouldThrowException() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();
        while (itr.hasNext()) {
            itr.next();
            treeSet.remove("Second");
        }
    }
//    В качестве альтернативы, если бы мы использовали метод удаления итератора,
//мы бы HE столкнулись с исключением:
    public static void whenRemovingElementAfterUsingIterator() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");

        Iterator<String> itr = treeSet.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            if (element.equals("Second"))
                itr.remove();
        }
    }
//    Нет никаких гарантий относительно отказоустойчивого поведения итератора, поскольку невозможно сделать
//    какие-либо жесткие гарантии при наличии несинхронизированной параллельной модификации.

//TreeSet first ()
//Этот метод возвращает первый элемент из TreeSet, если он не пустой.
//В противном случае он генерирует исключение NoSuchElementException.
//Давайте посмотрим на пример:
    public static void whenCheckingFirstElement() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        System.out.println("First" + treeSet.first());
    }
//Аналогично приведенному выше примеру, этот метод вернет последний элемент, если набор не пустой:
    public static void whenCheckingLastElement() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Last");
        System.out.println("Last" + treeSet.last());
    }

    //TreeSet subSet:
//Этот метод возвращает элементы в диапазоне от fromElement до toElement. Обратите внимание,
//что fromElement является включающим, а toElement - исключительным.

    public static void whenUsingSubSet() {
        SortedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> expectedSet = new TreeSet<>();
        expectedSet.add(2);
        expectedSet.add(3);
        expectedSet.add(4);
        expectedSet.add(5);

        Set<Integer> subSet = treeSet.subSet(2, 6);

        Iterator<Integer> sub = subSet.iterator();
        while (sub.hasNext()) {
            System.out.println(sub.next());
        }
        Iterator<Integer> expected = expectedSet.iterator();
        while (expected.hasNext()) {
            System.out.println(expected.next());
        }
    }
//Этот метод вернет элементы TreeSet, которые меньше указанного элемента:
    public static void whenUsingHeadSet() {
        SortedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> subSet = treeSet.headSet(6);
        System.out.println(subSet);
    }

    //TreeSet tailSet ()
//Этот метод вернет элементы TreeSet, которые больше или равны указанному элементу:
    public static void whenUsingTailSet() {
        NavigableSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> subSet = treeSet.tailSet(3,true);
        System.out.println(subSet);
    }

//    4. Importance of TreeMap Sorting
//    We now know that TreeMap stores all its entries in sorted order. Because of this attribute of tree maps,
//    we can perform queries like; find “largest”, find “smallest”, find all keys less than or greater than a
//    certain value, etc.

//    The code below only covers a small percentage of these cases:

    public void givenTreeMap_whenPerformsQueries_thenCorrect() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");

        Integer highestKey = map.lastKey();
        Integer lowestKey = map.firstKey();
        Set<Integer> keysLessThan3 = map.headMap(3).keySet();
        Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();

//        assertEquals(new Integer(5), highestKey);
//        assertEquals(new Integer(1), lowestKey);
//        assertEquals("[1, 2]", keysLessThan3.toString());
//        assertEquals("[3, 4, 5]", keysGreaterThanEqTo3.toString());
    }
}
