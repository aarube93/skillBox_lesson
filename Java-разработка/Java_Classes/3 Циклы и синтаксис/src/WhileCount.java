import java.util.Scanner;

public class WhileCount {
    public static void main(String[] args) {
        counter();
    }

    public static void counter() {
        int value = -1;
        int sum = 0;
        int per = 0;
        while(per > 100) {
            System.out.println("Введите число Value:");
            value = new Scanner(System.in).nextInt();
            sum = sum + value;
            per = per+1;
        }
        System.out.println("Сумма введенных чисел " + sum);
        System.out.println("Всего иттераций "+per);
    }
}
