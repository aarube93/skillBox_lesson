package stackOverflowError_example;

public class Main {
    public static void main(String[] args) {
        a();
    }

    public static void a() {
        a();
    }
}
