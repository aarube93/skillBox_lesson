import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//public class card {
//    public static void main(String[] args) {
//        System.out.println("\u0068");
//    }
//}

class NewYearGiftGard {
    private static String whereAmI = "Skillbox";
    private static String base = "tlbtktp\\/:/^\\/(/&";
    private static String mask = "@@@@@@";
    private static final int ANSWER = 42;
    private static int[] MyFavouriteNumbers = {58, 9, 11, 66, 15, 13, 64, 10};

    public static void main(String[] args) {

        List<Integer> foo = new ArrayList<>();

        String w1 = "\u0068"; //h

        for (int i = 0; i < Math.pow(2, 5); i++) {

            foo.add(i);
        }

        for (int i = 0; i < Math.pow(4, 2); i++) {

            if ((i % 3 == 0 || i % 5 == 0 && !(i % 4 == 0))) {
                w1 += base.charAt(foo.get(i));
            }
        }
        String w2 = "";

        for (int a = 0; a < MyFavouriteNumbers.length; a++) {
            w2 += (char) (MyFavouriteNumbers[a] ^ whereAmI.charAt(a));

        }

        String w3 = "";
        Random ran = new Random(187693996l);

        for (int n = 0; ; n++) {
            int k = ran.nextInt(60);
            if (k == 0) break;
            w3 += (char) (mask.charAt(n) + k);
        }
        int i = (byte) +(char) -(int) +(long) -1;
        w3 += (char) ((ANSWER - i) * 2);
        System.out.println(w1 + w2 + w3);
    }
}
