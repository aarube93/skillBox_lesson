import java.util.Scanner;

public class CycleFor {

    public static void main(String[] args) {
//        cycleFor();
        continueCycle();
    }

    public static void cycleFor() {
        for (; ; ) {
            System.out.println("Введите первое число: ");
            int value1 = new Scanner(System.in).nextInt();
            System.out.println("Введите вторе число: ");
            int value2 = new Scanner(System.in).nextInt();
            int results = value1 * value2;
            System.out.println("Произведение чисел равно " + results);
        }
    }

    public static void continueCycle() {
//В случае, когда нужно продолжать итерации цикла - continue;
        int soughtYear = 2023;
        int firstYear = 0;
        int lastYear = 2022;

        boolean yearExist = false;

        for (int year = firstYear; year < +lastYear; year = year + 1) {
            if (year % 4 != 0) {
                continue; //Продолжает выполнять действие, процесс зацыкливается до тех пор,
                //пока условие if выполняется.
            }
            for (int month = 1; month <= 12; month = month + 1) {
                String zero = month < 10 ? "0" : "";
                System.out.println("29." + zero + month + "." + year);

                String found = "Год найден";
                String notFound = "Год не найден";
//Пример использования тернарного оператора:

                System.out.println(yearExist ? found : notFound);

                for (int month2 = 1; month2 <= 12; month2 = month2 + 1) {
                    String zero2 = month < 10 ? "0" : "";
                    System.out.println("29." + month2 + "." + year);
                }
            }
        }
    }
}

