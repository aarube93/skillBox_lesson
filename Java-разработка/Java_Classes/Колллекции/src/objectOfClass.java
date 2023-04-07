import java.util.HashSet;
import java.util.Objects;

public class objectOfClass {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        HashSet<Client> hashSet = new HashSet<>();

        Client alex = new Client("ALex",1);
        Client sandra = new Client("Csandra",2);
        Client sandraClone = new Client("Csandra",2);

        for (int i = 0; i < 100; i++) {
            hashSet.add(new Client("John Doe",i));
//            hashSet.add(alex);
//            hashSet.add(sandra);
//            hashSet.add(sandraClone);
        }
        
        
//        hashSet.add(alex);
//        hashSet.add(sandra);
//        hashSet.add(sandraClone);

//        for (Client c:hashSet) {
//            System.out.println(c.getName() +" -> "+ c.hashCode() );
//        }

        System.out.printf("hash  %04d -> equals %04d%n",Client.hashcodeCount,Client.equalsCount);
        System.out.println(System.currentTimeMillis() - start);
    }
}

class Client {
    static int hashcodeCount;
    static int equalsCount;

    private final String name;
    private final int  id;

    @Override
    public int hashCode() {
        hashcodeCount++;
        return id;//super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        equalsCount++;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(name, client.name);
    }

    public Client(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
