import java.util.Scanner;

public class Main {
    public volatile int value; //-Ключевое слово volatile означает что эту переменную не нужно

    //кешировать(например в кэш-памяти ядра процессора) и нужно следить за ее значением таким,
    // какое оно есть в текущий момент.
    //Проблема в том, что она может быть разной в каждом из кэшей(например в 2ух ядерном процессоре или более)
    public static void main(String[] args) {

        Task task = new Task();
        new Thread(task).start();//Пишется одним поток а меняется другим потоком (поток new Thread(); )

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        task.stop();//Изменяется покоток Main();
        System.out.println("Main: " + task.getCounterValue() + ";");
    }
}