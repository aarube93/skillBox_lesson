public class ArrayWithArrayFilling {
    public static void main(String[] args) {

        int size = 55;
        char[][] ggg = getTwo(size);
        for (char[] strings : ggg) {
            for (char string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public static char[][] getTwo(int size) {

        char[][] ggg = new char[size][size];
        char symbol = 's';
        char    gup = ' ';

        for (int i = 0; i < ggg.length; i++) {
            for (int j = 0; j < ggg.length; j++) {

                if (i == j || i + j == (size - 1)) {
                    ggg[i][j] = symbol;
                } else {
                    ggg[i][j] = gup;
                }
            }
        }
        return ggg;
    }
}