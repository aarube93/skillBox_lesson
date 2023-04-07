import java.io.FileInputStream;

public class inputFileFromStream {
    private static final String listCSV = "data/Sherlock.txt";
   private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        try {
            FileInputStream is = new FileInputStream(listCSV);
            for (; ; ) {
                int code = is.read();
                if (code < 0) {
                    break;
                }
                char ch = (char) code;
                builder.append(ch);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        System.out.println(builder);
    }
}
