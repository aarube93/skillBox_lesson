package OccurrenceOfExceptions;

import java.util.ArrayList;

public class Occurrence {
    public static void main(String[] args) {
        System.out.println(sqr(5, 0));
        int x = 42;    // первый шаг
        int y = x * x; // второй шаг
        x = x * y;
        System.out.println(x);

    }

    public static void createException() {
        ArrayList<String> examples = new ArrayList<>();
        examples.add("The first string");
        try {
            System.out.println(examples.get(0));
            System.out.println(examples.get(1));

        } catch (Throwable ex) {
            System.out.println("Catch an error:\n" + ex.getMessage());
        }
    }

    public static int sqr(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }
}

    class OccurrencePublicApp {
        public static void main(String[] args) {
            // sqr - "сломается" (из него "выскочит" исключение),
            double d = sqr(10.0);  // выполнение метода main() прервется в этой строчке и
            // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
            System.out.println(d); // и печатать нам ничего не придется!
        }
        public static double sqr(double arg) {
            throw new RuntimeException(); // "бросаем" исключение
        }

        public static int area(int width, int height) {
            if (width < 0 || height < 0) {
                throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
            }
            return width * height;
        }

    }

//>> RUNTIME ERROR: Exception in thread "main" java.lang.RuntimeException

//finally-секция может быть использована для завершающего действия, которое гарантированно будет вызвано
//(даже если было брошено исключение или автор использовал return) по окончании работы
//// open some resource
//        try {
//        // use resource
//        } finally {
//        // close resource
//        }


//        Например для освобождения захваченной блокировки
//        Lock lock = new ReentrantLock();
//        ...
//        lock.lock();
//        try {
//        // some code
//        } finally {
//        lock.unlock();
//        }
//
//        Или для закрытия открытого файлового потока
//        InputStream input = new FileInputStream("...");
//        try {
//        // some code
//        } finally {
//        input.close();
//        }
//Не рекомендуемые практики
  //      — return из finally-секции (можем затереть исключение из try-блока)
    //    — действия в finally-секции, которые могут бросить исключение (можем затереть исключение из try-блока)
