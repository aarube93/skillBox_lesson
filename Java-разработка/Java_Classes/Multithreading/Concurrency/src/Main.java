public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    ValueStorage.incrementValue();
                }
                System.out.println(ValueStorage.getValue());
            }).start();
        }

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000000; j++) {
                    ValueStorage.atomicIncrementValue();
                }
                System.out.println(ValueStorage.getAtomicValue());
            }).start();
        }
    }
}