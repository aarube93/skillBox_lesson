import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class readFileFromBufferedReader {
    private static StringBuilder builder = new StringBuilder();
    private static String path = "data/Sherlock.txt";
    private static String path1 = "/Users/rube/Documents/codes/data/list_of_expired_passports.csv";

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path1));
            for (; ; ) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
               if(line.contains("4012,710044")) {
                   System.out.println(line);
                   //builder.append(line).append("\n");
               }

            }

        } catch (Exception e) {
            System.err.print(e);
        }
        System.out.println(builder);
    }
}
