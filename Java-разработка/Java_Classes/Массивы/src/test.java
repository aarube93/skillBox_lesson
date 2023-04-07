import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        pukPuk();
    }

    public static void pukPuk() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();


            boolean isNumber = true;

            if (str == null || str.isEmpty()) {
                isNumber = false;
            }

            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    isNumber = false;
                }
            }
            System.out.println(isNumber);
        }
    }
}

