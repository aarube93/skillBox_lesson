import java.time.LocalDateTime;

public class EqualsDateAndTime {
    public static void main(String[] args) {
//вычетания и сложения
        LocalDateTime time1 = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.now();
        System.out.println(time2.plusMinutes(1));

//Cравнения

        LocalDateTime time3 = LocalDateTime.now();
        LocalDateTime time4 = LocalDateTime.now().minusDays(100);
        System.out.println(time3.isAfter(time4));
        System.out.println(time3.isBefore(time4));


//В данном случае возвращается -1, 0 или +1. Если неверно, ровно и верно соответственно.
        System.out.println(time3.compareTo(time4));


    }
}
