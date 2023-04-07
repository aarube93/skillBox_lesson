
public class Friend implements Comparable<Friend>{
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void throwBallTo(Friend catcher) {
        System.out.format("%s: %s throw ball!%n", catcher.getName(), this.name);
        synchronized (compareTo(catcher) > 0  ? catcher : this) {
            catcher.throwBallTo(this);
        }
        //при вызове двумя(или более) потоками однго метода может возникать такая ситуация, когда два метода
        // автоматически ждут друг дргу и программа работатет но ничего не происходит. Причина в том, что
        // не установлена очередность. Установить очередность можно сравнением, например методов. Смотрии выше
    }

    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
