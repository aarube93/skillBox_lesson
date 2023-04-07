import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args) {
        regM();
//        regularExpressionsMatches();
//        searchTextInString();
//        massiveWords();
//        changeOneFragmentOnOther();
    }

    public static void regM() {
        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\" +
                "x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9]" +
                "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9]" +
                "[0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:" +
                "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

        String email = "aamardas@gmail.com";

        Pattern checkEmail = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher matcher = checkEmail.matcher(email);
        System.out.println(matcher.find());
    }

    public static void regularExpressionsMatches() { //ПРОВЕРКА СООТВЕТСТВИЯ СТРОКИ
//Рассмотрим метод, которым можно проверять строку на соответствие заданному шаблону, например ввод автомобильного номера
//корректность которого проверяется:
        String number = "А677МР197";
//Повторные наборы символов, если они встречаются дважды или более, можно заменить переменной
        //String regex = "[АВЕКМНОРСТУХ][0-9]{3}[АВЕКМНОРСТУХ]{2}[0-9]{2,3}";
        String ll = "[АВЕКМНОРСТУХ]";
        String nl = "[0-9]";
        String regex = ll + nl + "{3}" + ll + "{2}" + nl + "{2,3}"; //-Эта регулярка,
// в полной мере не удовлетворяет условиям ввода автомобильного номера, так как список регионов ограничен и не
// соответствует всему множеству вариантов при переборе чисел из трех цифр от 0-9. Нужно пользоваться списком.
//Эти два регулярных выражения равны, но второе более поддерживаемое, и не имеет задвоения кода.

//Проверка нужного нам выражения заданному шаблону, возвращает либо true, либо false:
        System.out.println(number.matches(regex));
    }

    public static void searchTextInString() { //ПОИСК СООТВЕТСВИЯ В СТРОКЕ
        String text = "Уважаемый Клиент! На данный момент сайт alpari.net недоступен по техническим причинам." +
                "Просим Вас использовать домен alpari.org. Приносим извинения за причиненные неудобства." +
                "Также напоминаем, Вы всегда можете пользоваться нашими мобильными приложениями" +
                "без каких-либо ограничений." +
                "Скачать Alpari Mobile https://alpari-forex.com/action/link_clicked/mobileApp\n" +
                "Скачать Alpari Invest https://alpari-forex.com/action/link_clicked/investApp\n" +
                "Специалисты нашей службы поддержки будут рады ответить на все ваши вопросы" +
                " в WhatsApp https://alpari.com/action/link_clicked/wp," +
                "Telegram https://alpari.com/action/link_clicked/tg," +
                "Facebook Messenger https://alpari.com/action/link_clicked/fb";
        String regex = "https:\\/\\/[^,\\s]+"; //Знак " + " говорит о том, что знак может быть не один, а множество,
// и метод нужно примерять до конца совпадений
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            System.out.println(text.substring(start, end));
        }
    }

    public static void massiveWords() { //РАЗБИЕНИЕ СТРОКИ НА ФРАГМЕНТЫ. МАССИВЫ.
//Можно описать те разделители, по которым эту строку можно разбить. Ну, например по пробельным символам.
        String text = "I know something about it";
        String[] words = text.split("\\s"); //words - это массив, а массив это множество элементов
//Фиксированной длинны. Мы можем обратиться к любому из этих элементов(в данном случае элемент - слово)
// по индексу(используя квадратные скобки), нумерация в строках начинается с 0.
        System.out.println("Нулевой символ строки text: " + words[0]);
//Выведем каждый элемент в отдельную строку с помощью цикла:
        for (int a = 0; a < words.length; a++) {
            System.out.println("Вывод метода строки из text: " + words[a]);
        }

//Если символ по которому нужно разделить строку может встречаться несколь раз подряд от одной грани до другой грани,
//то после символа по которому мы разделяем строку ставим знак +: String [] words = text.split("\\s+");
        String text2 = "I  know   something    about     it";
        String[] words2 = text2.split("\\s+");
        for (int b = 0; b < words2.length; b++) {
            System.out.println("Вывод метода строки из text2: " + words[b]);
        }
    }

    public static void changeOneFragmentOnOther() {//ЗАМЕНА ОТДНОГО ФРАГМЕНТА КОДА НА ДРУГОЙ
//Например, отформатировать в единый формат список телефонов, хранящийся в различных строках.
        String phone1 = "+7 903 710-37-54";
        String phone2 = "7 (903) 968-6945";
        String phone3 = "7999-666-66-66";
        String phone4 = "7(903)9686945";

        System.out.println(formatPhoneNumber(phone1));
        System.out.println(formatPhoneNumber(phone2));
        System.out.println(formatPhoneNumber(phone3));
        System.out.println(formatPhoneNumber(phone4));
    }

    public static String formatPhoneNumber(String phone) {
        String regex = "[^0-9]";
        return phone.replaceAll(regex, "");// -специальный метод для замены части строки на другую
    }
    //https://developer.mozilla.org/ru/docs/Web/JavaScript/Guide/Regular_Expressions
//РЕГУЛЯРНЫЕ ВЫРАЖЕНИЯ. СИМВОЛЫ В РЕГУЛЯРКАХ И ИХ ОПИСАНИЕ:
//[abc] - Набор символов
//[^abc] - Отрицание указанного набора символов
//[0-9] - Диапазон значений
//  \s - Пробельный символ
//  n+ -более одного символа
//  n* -ноль, один или более символов
//  n?  -ноль или один символ
//  n{5} -пять раз
//  n{5,} -пять и более раз
//  n{5,8} -от пяти до 8 раз
}

