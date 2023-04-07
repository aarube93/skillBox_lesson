import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class writeToFile {
    public static void main(String[] args) {
        writeFileFromGeneration();
        writeFr();
    }

    public static void writeFileFromGeneration() {
        try {
            PrintWriter writer = new PrintWriter("data/file.txt");
            for(int i = 0; i < 1000; i++) {
                writer.write(i + "\n");
            }
            writer.flush();
            writer.close();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void writeFr() {
        ArrayList<String> strings = new ArrayList<>();
        for(int i = 0; i < 10000; i = i + 3) {
            strings.add(Integer.toString(i));
        }
        try {
            Files.write(Paths.get("data/file2.txt"), strings);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
 }
