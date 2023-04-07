import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class inPutStream {
    private static final String listCSV = "/Users/rube/Documents/codes/warInRussia/data/list_of_expired_passports.csv";
    private static long count = 0;

    public static void main(String[] args) {
        try {
            FileInputStream is = new FileInputStream(listCSV);
            for(;;) {
               StringBuilder builder = new StringBuilder();
                int code = is.read();
                if(code < 0) {
                    break;
                }
                char ch = (char) code;
                builder.append(ch);

                if (ch == 10||ch == 13){
                    count++;
                   if (builder.toString().contains("4014,165125")){
                       System.err.print(count + "НАЙДЕН: " + builder.toString());
                   }
                }
            }
        }catch (Exception e) {
            System.err.print(e);
        }
    }
}