public class Main {
    //Механизмы, позваляющие взаимодействовать потокам между собой:
    //-wait(); ожидание notify();Освобождает монитор,переводит вызывающий(этот метод) поток в режим ожидания до того
    //момента, пока другой поток не вызовет метод notify(); у того же объекта.

    //-notify(); запускает ранее остановленный поток у ётого объекта.

    //-notifyAll(); Запускает все остановленные ранее потоки.
    public static void main(String[] args) {
        Parking parking = new Parking();
        Thread thread1 = new Thread(new Producer(parking));
        Thread thread2 = new Thread(new Consumer(parking));

        thread1.start();
        thread2.start();

    }
}