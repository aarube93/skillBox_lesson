import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class parsingHTML {
    public  static String htmlFile = parseFile("data/code.html");

    public static void main(String[] args) {
        Document doc = Jsoup.parse(htmlFile);
        Elements elements = doc.select("a.menu__link");
        elements.forEach(System.out::println);
    }
    public static  String parseFile(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines =  Files.readAllLines(Paths.get(path));
            lines.forEach(l-> builder.append(l+"\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }
}
