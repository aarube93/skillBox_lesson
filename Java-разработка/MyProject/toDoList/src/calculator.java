import java.util.Scanner;

public class calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        Main.lastCommandAdd = "";
        double num1 = getInt();
        double num2 = getInt();
        char operation = getOperation();
        double result = calc(num1,num2,operation);
        System.out.println("Результат операции: "+result + ". Работа калькулятора завершена");
    }

    public static double getInt(){
        System.out.println("Введите число:");
        double num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(double num1, double num2, double operation){
        double result;
        switch ((int) operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            case '^' -> result = Math.pow(num1, num2);
            default -> {
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
            }
        }
        return result;
    }
}