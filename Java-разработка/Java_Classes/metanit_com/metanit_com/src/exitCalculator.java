import java.util.Scanner;

public class exitCalculator {
    public static void main(String[] args) {
        Calc();
    }

    public static void Calc() {
        while (true) {
            System.out.print("Введите первое число: ");
            Scanner i = new Scanner(System.in);
            int f = i.nextInt();

            System.out.print("Введите второе число: ");
            Scanner in = new Scanner(System.in);
            int s = in.nextInt();

            System.out.println(f * s);

            System.out.print("Продолжить? Д/Н : ");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if(str.equals("Н")) {
                break;
            }
        }
    }
}
