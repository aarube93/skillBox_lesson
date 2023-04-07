import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeAndDate {

    public static void main(String[] args) {

//Если нужно создать сегодняшний день:
        LocalDate today = LocalDate.now();
        System.out.println(today);


//если нам нужно получить текущее время:

        LocalDateTime todayTime = LocalDateTime.now();
        System.out.println(todayTime);


//Если нужно создать дату из какой-то имеющейся информации:
        LocalDate birthday = LocalDate.of(1993, 01, 21);
        System.out.println(birthday);


//Если нужно выполнить какие-либо сложения или вычетания:
        System.out.println(birthday.plusYears(18));
        System.out.println(birthday.minusMonths(9));


//Если нужно получить текущее время в другом часовом поясе:
        LocalDateTime nowInNY = LocalDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(nowInNY);


//Парсинг в форматере. Строка форматируются в объект.
        String myDate = "29/02/1993";
        DateTimeFormatter xxxFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate xxxLocalDate = LocalDate.parse(myDate, xxxFormatter);
        System.out.println(xxxLocalDate);


//Форматируем объект в строку. Форматируем текущую дату, например:
        DateTimeFormatter xxFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(xxFormatter.format(now));


// Форматируем по заданному шаблону из метода
        DateTimeFormatter nowFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println("Шаблон: " + nowFormatter.format(now2));

    }

//    public void overCode() {
//        long yourMilliSeconds = 1322018752992l;
//        //1322018752992-Nov 22, 2011 9:25:52 PM
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(yourMilliSeconds);
//
//        int mYear = calendar.get(Calendar.YEAR);
//        int mMonth = calendar.get(Calendar.MONTH);
//        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
//
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS", Locale.US);
//
//        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("US/Central"));
//        calendar.setTimeInMillis(yourMilliSeconds);
//
//        System.out.println("GregorianCalendar -" + sdf.format(calendar.getTime()));
//
//        DateTime jodaTime = new DateTime(yourMilliSeconds,
//                DateTimeZone.forTimeZone(TimeZone.getTimeZone("US/Central")));
//        DateTimeFormatter parser1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss,SSS");
//
//        System.out.println("JodaTime " + parser1.print(jodaTime));
//    }
}

