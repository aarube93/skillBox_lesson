//В джава потоки соответствуют потокам уровня операционной системы и безконтрольный запуск потоко может повлиять на
//производительность приложения и производительность всей системы в целом.
//Поэтому разработаны специальные пулы потоков - вы можете создавать задачи и отдавать их пулу потоков который будет их
// запускать по очереди, так, что бы одновременно работало оптимальное для вашего приложения колличество потоков.

import Structure.Names;
import Structure.Surnames;

import java.util.ArrayList;
import java.util.concurrent.*;

//В джава существует спец.класс - Executors у которого есть набор статических методов, который позволяет создавать
// заранее сконфигурированные пулы потоков.
public class PoolsTreads {
    public static long s = System.currentTimeMillis();

    public static void main(String[] args) throws Exception {
        onePool();
        poolCallable();
    }

    public static void onePool() {
        Executor executor = Executors.newSingleThreadExecutor();

//Один пул потоков можно получить, вызвав статический метод newSingleThreadExecutor () класса Executors.
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Где метод newSingleThreadExecutor создает исполнителя, который выполняет одну задачу за раз.
        executor.execute(() -> {
            ArrayList<Surnames> surnames;
            try {
                surnames = new JsonParser("data/surnames.json").parseSurnames();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(System.currentTimeMillis() - s);
            System.out.println(surnames.size());
        });
    }

    public static void poolCallable() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Callable callable = () -> {
            ArrayList<Surnames> surnames;
            surnames = new JsonParser("data/surnames.json").parseSurnames();
            return surnames;
        };
        Future<ArrayList<Surnames>> future = service.submit(callable);

        System.out.println(future.get().size());
        System.out.println(System.currentTimeMillis() - s);
        service.shutdown();
    }
}

//    Создание потока является затратной по времени и ресурсам операцией. Количество потоков, которое может быть
//    запущено в рамках одного процесса также ограниченно. Чтобы избежать этих проблем и в целом управлять
//    множеством потоков более эффективно в Java был реализован механизм пула потоков (thread pool),
//    который создаётся во время запуска приложения и в дальнейшем потоки для обработки запросов берутся и
//    переиспользуются уже из него. Таким образом, появляется возможность не терять потоки, сбалансировать приложение
//    по количеству потоков и частоте их создания.
//
// Начиная с Java 1.5 Java API предоставляет фреймворк Executor, который позволяет создавать различные типы пула потоков:
//
// Executor — упрощенный интерфейс пула, содержит один метод для передачи задачи на выполнение;
// ExecutorService — расширенный интерфейс пула, с возможностью завершения всех потоков;
// AbstractExecutorService — базовый класс пула, реализующий интерфейс ExecutorService;
// Executors — фабрика объектов связанных с пулом потоков, в том числе позволяет создать основные типы пулов;
// ThreadPoolExecutor — пул потоков с гибкой настройкой, может служить базовым классом для нестандартных пулов;
// ForkJoinPool — пул для выполнения задач типа ForkJoinTask;
// … и другие.
// Методы Executors для создания пулов:
//
// newCachedThreadPool() — если есть свободный поток, то задача выполняется в нем, иначе добавляется новый поток в пул.
// Потоки не используемые больше минуты завершаются и удалются и кэша. Размер пула неограничен. Предназначен для
// выполнения множество небольших асинхронных задач;
// newCachedThreadPool(ThreadFactory threadFactory) — аналогично предыдущему, но с собственной фабрикой потоков;
// newFixedThreadPool(int nThreads) — создает пул на указанное число потоков. Если новые задачи добавлены, когда все
// потоки активны, то они будут сохранены в очереди для выполнения позже. Если один из потоков завершился из-за ошибки,
// на его место будет запущен другой поток. Потоки живут до тех пор, пока пул не будет закрыт явно методом shutdown().
// newFixedThreadPool(int nThreads, ThreadFactory threadFactory) — аналогично предыдущему, но с собственной фабрикой
// потоков;
// newSingleThreadScheduledExecutor() — однопотоковый пул с возможностью выполнять задачу через указанное время или
// выполнять периодически. Если поток был завершен из-за каких-либо ошибок, то для выполнения следующей задачи будет
// создан новый поток.
// newSingleThreadScheduledExecutor(ThreadFactory threadFactory) — аналогично предыдущему, но с собственной фабрикой
// потоков;
// newScheduledThreadPool(int corePoolSize) — пул для выполнения задач через указанное время или переодически;
// newScheduledThreadPool(int corePoolSize, ThreadFactory threadFactory) — аналогично предыдущему,
// но с собственной фабрикой потоков;
// unconfigurableExecutorService(ExecutorService executor) — обертка на пул, запрещающая изменять его конфигурацию;