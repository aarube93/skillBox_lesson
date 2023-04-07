public class multiplication_table {
    public static void main(String[] args) {
        for (var i = 1; i <= 9; i++) {
            for (var j = 1; j <= 9; j++) {
                System.out.printf("%d\t", i * j);
            }
            System.out.println();
        }
    }
}
