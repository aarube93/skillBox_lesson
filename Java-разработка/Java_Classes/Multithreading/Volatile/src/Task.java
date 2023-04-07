public class Task implements Runnable{
     private long counter;
     //private boolean isRunning;
    private volatile boolean isRunning;
//Если добавить ключевое слово volatile - программа работатет верно, система следит за измененнием этого значения
// не добавляя его в кэш.

    public Task() {
        isRunning = true ;
    }

    @Override
    public void run() {
        while (isRunning) {
            counter++;
        }
        System.out.println("Task: " + counter + ";" );
    }

    public void stop() {
        isRunning = false;
    }

    public long getCounterValue() {
        return counter;
    }
}
