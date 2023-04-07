public class OutputTypicalPlacesInStr {
    public static void main(String[] args) {
        SearchAndOutputTypicalPlacesInStr();
    }

    public static void SearchAndOutputTypicalPlacesInStr() {
//Этим методом,который рассмотрим ниже можно вычленить какой-либо фрагмент строки (даже если фрагмент различной длинны),
//при заранее известной типизации строк. Это нужно, когда искомый фрагмент условно неизвестен, то есть не определен в
//строке на данном этапе. Например как кодировка, а нужно вывести только название кодировки из строки, например в
// консоль или в параметр. Для решения задачи пишем отдельный метод, геттер Стринг.
//Ниже приведены фрагменты строк, из которых выводится нужная информация в отдельные сообщения.

        String header1 = "Content-Type: text/html; charset =utf-8;";
        String header2 = "Content-Type: text/html; charset =windows-1251;";
        String header3 = "Content-Type: text/html; charset =ISO-8859-1;";

//Особые варианты строк, ошибочные или прочие методы и строки:
        String header4 = "Content-Type: text/html;";
//Если искомая строка в тексте не найдена, то метод indexOf(имяПеременнойСтроки) вернет значение -1.
        String header5 = "Content-Type: text/html; charset =";
        String header6 = "Content-Type: text/html; charset =;";

//Свой вариант текста для реализации неописанных в уроке методов:
        String text1 = "Content-Type: text/html; charset=utf-8;";
        String text2 = "Content-Type: text/html; charset=windows-1251;";
        String text3 = "Content-Type: text/html; charset=ISO-8859-1;";

//Теперь просто применяем метод к строке текста и выводим результат.
//Результат работы первого метода:
        System.out.println("Заголовок1: " + getEncoding(header1) + ";");
        System.out.println("Заголовок2: " + getEncoding(header2) + ";");
        System.out.println("Заголовок3: " + getEncoding(header3) + ";");

//Результаты работы второго метода:
        System.out.println("Заголовок4: " + getEncoding2(header4) + ";");
        System.out.println("Заголовок5: " + getEncoding2(header5) + ";");
        System.out.println("Заголовок6: " + getEncoding2(header6) + ";");
    }

    public static String getEncoding(String header) {
        String charsetStr = "charset =";

        int start = header.indexOf(charsetStr) + charsetStr.length();//Место, от которого вычленяем
// нужный фрагмент строки. Метод работает от начала фрагмента указанного текста в charsetStr,
// поэтому к нему нужно прибавить его длинну -  + charsetStr.length().

        int end = header.indexOf(";",start);
//В качестве первого параметра в скобках передаем искомый символ, до которого(не включительно),
//нужно передать фрагмент строки. В качестве второго символа передаем номер символа от которого ищем конечный символ.

        String encoding = header.substring(start,end);
//Метод substring(начальный символ,конечный символ) возвращает часть строки от первого до второго символа в скобах

        return encoding;
    }

    public static String getEncoding2 (String header2) {
//В случае если строки не равны между собой, и возможна строка с отсутсвием нужного фрагмента текста,
//то просто добавляем проверку
        String charsetStr2 = "charset =";
        int start = header2.indexOf(charsetStr2);
        int end = header2.indexOf(";",start);
        if(start < 0 || end <0){
            return "Строка не найдена";
        }
        String encoding2 = header2.substring(start + charsetStr2.length() ,end);
        if(encoding2.isEmpty()) {
            return "Строка пуста";
        }
        return encoding2;
    }


//Методы работы со строками: Нужно все разобрать и поработать с каждым из них.
//.indexOf(".txt") -   позволяет найти подстроку в строке и ее позицию, но если она не найдена, то он возвращает -1;
//.indexOf(".txt" , from); - позволяет искать подстроку после определенного символа;

//.lastIndexOf(".txt") - Метод lastIndexOf() возвращает индекс последнего вхождения указанного значения в строковый
// объект String, на котором он был вызван, или -1, если ничего не было найдено.
// Поиск по строке ведётся от конца к началу, начиная с индекса fromIndex.

//.lastIndexOf(".txt" , from); - с конца строки, после определенного символа

//.substring(from); - позволяет получить подстроку начиная с определенного символа до конца строки.

//.substring(from, to); - позволяет получить строку от и до какого-то символа

//https://developer.mozilla.org/ru/docs/Web/JavaScript/Reference/Global_Objects/String/lastIndexOf


}
