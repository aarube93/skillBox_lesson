import java.util.ArrayList;

public class Main {
    //ПРо синхронизацию методов и блоков прогграммного кода:
    //Синхронизация нужна для того, что бы гарантировать выполнение того или инного метода программного кода
    // одновременно только в одном потоке. Если к этому фрагменту програмного кода есть доступ у нескольких
    // потоков или он выполняется в нескольких потоках то миханизм синхронизации позволяет
    // выстраить их в очередь выполнения относительно этого фрагмента кода и и сделать таким образом что бы этот
    // фрагмент выполнялся только в одном потоке.

    private static final ArrayList<Double> numbers = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(Main::someHeavyMethodPointSynchronized));
        }
        threads.forEach(Thread::start);
    }

    //Всегда правильно использовать более низкокровневую синхорнизацию - не по всему методу а
    // синхронизировать выполнение какой-то одной операции, например:
    public static void someHeavyMethodPointSynchronized() {

        for (int i = 0; i < 1_000_000; i++) {
            double value = Math.random() / Math.random();

            synchronized (numbers) {
                numbers.add(value);
            }
        }
        System.out.println(numbers.size());
        numbers.clear();
    }

    public static synchronized void someHeavyMethodSynchronized() {//Если делаем мето "synchronized", то потоки
        // "выстраиваются" в очередь и посути мы выполняем опреацию в один поток столько раз, сколько потоков
        for (int i = 0; i < 1_000_000; i++) {
            numbers.add(Math.random() / Math.random());
        }
        System.out.println(numbers.size());
        numbers.clear();
    }

    public static void someHeavyMethod() {
        for (int i = 0; i < 1_000_000; i++) {
            numbers.add(Math.random() / Math.random());
        }
        System.out.println(numbers.size());
        numbers.clear();
    }
}