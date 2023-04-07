package Stream_API_Vebinar_Po_Java;

public class toCollect {
    public static void main(String[] args) {

    }

                            //toCollect - Собирает СТРИМ в нужную коллекцию данных или объект
    //Класс COLLECTOR с обработками
//    <R ,A> R collect(Collector<? super T,A,R> collector);

    //Так же можно расписать все в ручную - какой метод что принимает
//    <R> R collect(Supplier<R> supplier,
//                  BiConsumer<R, ? super T> accumulator,
//                  BiConsumer<R, R> combiner);

//    Существующие методы получения классов Collector в JDK находятся в
//    java.util.stream.Collectors.toCollection() с выбором конструктора коллекции:

//    Collection<Integer> collection = Stream.of(10, 20, 30, 100)
//            .collect(Collectors.toCollection(LinkedList::new));

//    Set<Integer> collection = Stream.of(10, 100, 5, 100)
//            .collect(Collectors.toCollection(TreeSet::new));

//    Queue<Integer> collection = Stream.of(10, 100, 5, 100)
//            .collect(Collectors.toCollection(ConcurrentLinkedDeque::new));

    //Возвращает коллекция именно того типа что и передали:
//    ArrayList<Integer> collection = Stream.of(10, 100, 5, 100)
//            .collect(Collectors.toCollection(ArrayList::new));


                    // .toList() короткая запись получения List (реализация ArrayList):
//    List<Integer> collection = Stream.of(10, 100, 5, 100)
//                            .collect(Collectors.toList());

                    //.toSet() короткая запись получения Set (реализация HashSet)
//    Set<Integer> collection = Stream.of(10, 100, 5, 100)
//                            .collect(Collectors.toSet());


                   //.toUnmodifiableList() неизменяемый List (реализация ArrayList)
//    List<Integer> collection = Stream.of(10, 100, 5, 100)
//                            .collect(Collectors.toUnmodifiableList());


//        TO USE JDK 10:
            //.toUnmodifiableSet() неизменяемый List (реализация HashSet)
//    Set<Integer> collection = Stream.of(10, 100, 5, 100)
//                    .collect(Collectors.toUnmodifiableList());


}
