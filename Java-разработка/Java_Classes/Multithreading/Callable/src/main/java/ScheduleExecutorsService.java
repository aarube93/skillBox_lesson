import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorsService {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.schedule(()-> System.out.println("Yes"),1000, TimeUnit.MILLISECONDS);
        service.scheduleAtFixedRate(()-> System.out.println("from starting this action"),
                1000,2000,TimeUnit.MILLISECONDS);

        service.scheduleWithFixedDelay(()-> System.out.println("from finishing this action"),
                1000, 2000,TimeUnit.MILLISECONDS);
    }
}
