import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class timeMachine {

    public static String getCurrentTime() {
        Main.lastCommandAdd = "";
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        long unixTime = System.currentTimeMillis() / 1000;

        return Instant.ofEpochSecond(unixTime)
                .atZone(ZoneId.of("GMT+3"))
                .format(formatter);
    }
}



