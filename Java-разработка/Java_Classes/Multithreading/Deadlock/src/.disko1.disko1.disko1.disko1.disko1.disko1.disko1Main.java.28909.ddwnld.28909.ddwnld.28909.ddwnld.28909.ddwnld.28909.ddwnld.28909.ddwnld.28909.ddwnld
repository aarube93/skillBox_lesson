public class Main {
    public static void main(String[] args) {
        final Friend vasya = new Friend("Вася");
        final Friend kostya = new Friend("Костя");

        new Thread(() -> vasya.throwBallTo(kostya)).start();
        new Thread(() -> kostya.throwBallTo(vasya)).start();
    }
}