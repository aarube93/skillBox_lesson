import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class readFileFromfFiles {
    private static final String txt = "data/Sherlock.txt";
    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(txt));
            lines.forEach(line -> builder.append(line).append("\n"));
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}
