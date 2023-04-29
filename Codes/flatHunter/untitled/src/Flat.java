import core.Address;
import core.Publicator;

import java.util.Objects;

public class Flat {
    private final String url;
    private final int price;
    private final double m2;
    private final Publicator publicator;
    private final Address address;

    public Flat(String url, int price, double m2, Publicator publicator, Address address) {
        this.url = url;
        this.price = price;
        this.m2 = m2;
        this.publicator = publicator;
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public int getPrice() {
        return price;
    }

    public double getM2() {
        return m2;
    }

    public Publicator getPublicator() {
        return publicator;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return price == flat.price && Double.compare(flat.m2, m2) == 0 && Objects.equals(url, flat.url) && Objects.equals(publicator, flat.publicator) && Objects.equals(address, flat.address);
    }

    @Override
    public String toString() {
        return "Параметры квартиры:\n" +
                "Ссылка: " + url +
                "\nЦена объекта: " + price + "руб., площадь: " + m2 +
                "\nАдресс объекта: " + address +
                "\nПродавец: " + publicator +
                "\n///////////////////////////////////\n";
    }
}