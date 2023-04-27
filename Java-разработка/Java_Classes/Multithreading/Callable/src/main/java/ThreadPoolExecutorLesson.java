import Structure.Surnames;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadPoolExecutorLesson {
    public static synchronized void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        //Вот такой запрос создает пул из 5 потоков, где пять максимальне и созданное колличеств,
        //время бездействия потока 0мс
        executor.setCorePoolSize(5); //Указываем нужное колличество потоков
        executor.setMaximumPoolSize(8);//Если все 5 потоков заняты - можно добавить еще потоков до макс. значения
        executor.setKeepAliveTime(100, TimeUnit.MILLISECONDS);

        executor.execute(() -> {
            ArrayList<Surnames> surnames;
            try {
                surnames = new JsonParser("data/surnames.json").parseSurnames();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(surnames.size());
        });

        //Так же есть много поезных методов для настройки:
        //Например получения очереди потоков
        System.out.println("executor.getQueue().size() : " + executor.getQueue().size());

        //Колличество активных потоков
        System.out.println("executor.getActiveCount() : " + executor.getActiveCount());

        //Колличество завершенных задач:
        System.out.println("executor.getCompletedTaskCount() : " + executor.getCompletedTaskCount());

        executor.close();
    }
}
