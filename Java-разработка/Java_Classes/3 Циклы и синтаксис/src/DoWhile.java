public class DoWhile {
    public static void main(String[] args) {
        doWhile();
    }

    public static void doWhile() {
        int i = 0;
        do {
            System.out.println("Жопка Маша");
            i = i + 1;
        }
        while (i != 5);
        System.out.println(i);
    }
}
