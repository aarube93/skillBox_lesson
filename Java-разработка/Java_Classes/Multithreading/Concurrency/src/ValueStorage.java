import java.util.concurrent.atomic.AtomicInteger;

public class ValueStorage {
    private static int value;
    private static AtomicInteger atomicValue = new AtomicInteger();

    //Секция incrementValue() - кретическая секция кода == та секция, которая может работать не однозначно.
    public static void incrementValue() {
        value = value + 1;//-Не атомарная операция, то есть такая операция, которая выполняется
        // не в один подход. Для вы полнения нам нужно получить значение, прибавить единицу,
        // потом присвоить получившеесе значение исходному.
        //В это время предыдущий поток уже присвает новое значение и получается что у нашего потока
        //данные не актуальны(значение на единицу меньше или даже более чем на единицу).
    }
    public static void atomicIncrementValue()  {
        atomicValue.incrementAndGet();
    }
        //Наша задача построить кретическую секцию таким образом, что бы операции в них выполнялись атомарно или
        //были синхранизированны.
        //Для всевозможных счетчиков итерацией в многопоточном режиме существует атомарный класс Atomic.
        // Сейчас мы попробуем воспользовать им:



    public static int getValue() {
        return value;
    }

    public static int getAtomicValue() {
        return atomicValue.intValue();
    }
}
