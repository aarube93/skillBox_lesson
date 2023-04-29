import core.Address;
import core.Publicator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
    private static final List<Flat> flats = new ArrayList<>();

    public static void commandLine(String path) {
        try {
            while (true) {
                System.out.println("Для начала создания объекта введите \"new\", \"print\" для печати " +
                        "и \"write\" для записи");
                String line = new Scanner(System.in).nextLine();
                if (line.equals("new")) {
                    addFlat();
                } else if (line.equals("print")) {
                    flats.forEach(System.out::println);
                } else if (line.equals("write")) {
                    StringBuilder data = new StringBuilder();
                    for(Flat items : flats) {
                        data.append(items.toString());
                    }
                    dataWriteToTxt(path, data.toString());
                } else if (Integer.parseInt(line) == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e);
            commandLine(path);
        }
    }

    public static void addFlat() {
        try {
            System.out.println("Приступим к созданию нового объекта. " +
                    "\nУкажите ссылку, где размещено объявление объекта: ");
            String url = new Scanner(System.in).nextLine();

            System.out.println("Укажите стоимость объекта в рублях: ");
            String cost = new Scanner(System.in).nextLine();

            System.out.println("Укажите площать объекта: ");
            String m2 = new Scanner(System.in).nextLine();

            System.out.println("Теперь введем имя собственника или риелтора, который разметсил объявление: ");
            String name = new Scanner(System.in).nextLine();

            System.out.println("Номер телефона в свободном формате: ");
            String number = new Scanner(System.in).nextLine();

            System.out.println("Объявление размещено собственником жилого помещения? (у/n)");
            String yOrN = new Scanner(System.in).nextLine();

            boolean owner;
            owner = yOrN.equals("y");

            System.out.println("Введите адресс в одну строку: Город, улица, дом, квартира: ");
            String address = new Scanner(System.in).nextLine();

            System.out.println("И последний параметр - этаж, на котором расположена квартира и колличество " +
                    "этажей в доме через дробь 8/9");

            String floor = new Scanner(System.in).nextLine();
            flats.add(new Flat(url, Integer.parseInt(cost), Double.parseDouble(m2),
                    new Publicator(name, number, owner), new Address(address, floor)));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e
                    + "\n Попробуйте ввести данные заново.");

            addFlat();
        }
    }

    private static void dataWriteToTxt(String path,String data) {
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Wrong with file path:\n" +
                    "Please, try input the path again!" + e);
            String line2 = new Scanner(System.in).nextLine();
            Data.commandLine(line2);
        }
    }
}
