import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Вы запустили организатор подбора недвижимости. Перед запуском приложения введите " +
                    "путь, куда запишем фаил с выводом. ");
            String line = new Scanner(System.in).nextLine();
            Data.commandLine(line);
        } catch (Exception e) {
            System.err.println("Wrong with file path:\n" +
                    "Please, try input the path again!" + e);
            String line2 = new Scanner(System.in).nextLine();
            Data.commandLine(line2);
        }
    }
}