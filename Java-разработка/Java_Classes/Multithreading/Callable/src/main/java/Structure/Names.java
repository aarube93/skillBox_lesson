package Structure;

public class Names {
    private final long id;
    private final String name;
    private final boolean women;

    public Names(long id, String name, boolean women) {
        this.id = id;
        this.name = name;
        this.women = women;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isWomen() {
        return women;
    }
}
