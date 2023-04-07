import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CharInString {
    public static void main(String[] args) {
        //nullSymbolInStringOrOtherNumber();
        isSymbolNUmberOrNo();
//        lookingForGapSymbol();
//        deleteGubAndOtherSymbols();
//        charsetDefaultTheSystem();
//        changeCharsetTheString();
    }

    public static void nullSymbolInStringOrOtherNumber() {
//Что бы вывести первый, или любой другой по счету, символ в строке(НАЧИНАЯ С НУЛЯ) используем следующий метод:
        String line = "Y947848239";
        char symbol = line.charAt(0);
        System.out.println(symbol);
    }

    public static void isSymbolNUmberOrNo() {
//Если нужно выяснить, является ли указанный символ ЧИСЛОМ, то используем метод Character.isDigit(),
//a в скобки передаем параметр, характер которого определяем.
        String line = "Z94784823903302";
        char symbol = line.charAt(0);
        char symbol1 = line.charAt(1);
        System.out.println(line);
        System.out.println("Нулевой символ строки является числом? - " + Character.isDigit(symbol));
        System.out.println("Первый символ строки является числом? - " + Character.isDigit(symbol1));
    }

    private static void lookingForGapSymbol() {
//Задача: Найти заданный символ в строке текста. Усложнил задачу выводом искомого символа,
//для чего пришлось парсить чар символ в стринг и использовать метод a.equals(lookSymbol),
// добавил ввод символа в консоль. Метод ищет только один символ, не сочетания символов.
// Зациклил выполнения кода для подсчета времени выполнения.
// Очень быстро, наверное если упростить будет еще быстрее.
//Чувствительно к регистру

        System.out.println("Введите искомый символ:");
        String LookingForASymbol = (new Scanner(System.in)).nextLine();
        Long start = System.currentTimeMillis();
        int spaceCount = 0;

        for (int b = 0; b < 1; b++) {
            String text = "Тут текст, в котором можно посчитать количество его символов";

            for (int i = 0; i < text.length(); i++) {

                char symbol = text.charAt(i);
                String a = Character.toString(symbol);

                if (a.equals(LookingForASymbol)) {
                    spaceCount++;
                }
            }
        }
        System.out.println("Количество символов текста (" + LookingForASymbol + ") в строке: " + spaceCount);
        System.out.println("Врем выполнения кода(сек): " + (System.currentTimeMillis() - start));
    }


    public static void deleteGubAndOtherSymbols() {
//Если необходимо убрать лишние символы табуляции, пробелов, переносов строки: .trim()
        String name = "  \n \t \r\n Andriana    \t";
        System.out.println(name.trim());
    }


    //кодировка
    public static void charsetDefaultTheSystem() {
//Для вывода в консоль имени используемой в системе кодировке можно исп. команду:
        String charset = Charset.defaultCharset().displayName();
        System.out.println("Use charset: " + charset);
    }

    public static void changeCharsetTheString() {
        String text = "Something about кодировки";
        String encodedText = new String(text.getBytes(), StandardCharsets.US_ASCII);
        System.out.println(encodedText);
//Так как StandardCharsets содержит довольно немного кодировок, можно использовать следующий метод:
//Ну, то есть просто вписать название кодировки в кавычки.
//Особенность этого метода в том, что при его вводе требуется обезопасить строку от возможного исключения
// и неправильной работы. Для этого необходимо нажать на лампочку и выбрать параметр Surround with try/catch,
//после чего код:
//        String text2 = "Something about кодировки";
//        String encodedText2 = new String(text.getBytes(), "windows-1251");
//        превращается в представленный ниже:

        String text2 = "Something about кодировки";
        String encodedText2 = null;
        try {
            encodedText2 = new String(text.getBytes(), "windows-1251");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(encodedText2);
    }
}
