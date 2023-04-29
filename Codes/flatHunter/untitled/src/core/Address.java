package core;

public class Address {
    private final String street;
    private final String floor;

    public Address(String street, String floor) {
        this.street = street;
        this.floor = floor;
    }

    public String getStreet() {
        return street;
    }

    public String getFloor() {
        return floor;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return street + ", этаж: " + floor;
    }
}