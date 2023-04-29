package core;

public class Publicator {
    private final String name;
    private final String number;
    private final boolean owner;

    public Publicator(String name, String number, boolean owner) {
        this.name = name;
        this.number = number;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public boolean isOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Объявление размещено пользователем: " +
                "\nИмя: " + name  + ". Номер телефона: " + number + "; Собственник: " + owner;
    }
}