import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
    private static final String writePath = "/users/alex/desktop/result.txt";
    private static final List<String> list1 = new ArrayList<>();
    private static final List<String> list2 = new ArrayList<>();
    private static String res = "";
    private static boolean match = false;

    public static void main(String[] args) {
        try {
            loadFromFile();
            sort();
            dataWriteToTxt(res);
        } catch (Exception e) {
            System.err.println("Something went wrong: " + e);
        }
    }

    private static void loadFromFile() throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("data/input.txt"));
        int n = Integer.parseInt(lines.get(0));
        int m = Integer.parseInt(lines.get(++n * 2));
        int finalN = n;

        lines.stream().filter(l -> l.length() > 2).forEach(s -> {
            if (list1.size() < finalN - 1) {
                list1.add(s);
            } else if (list1.size() == finalN - 1 && list2.size() < m) {
                list2.add(s);
            }
        });
    }

    private static void sort() {
        list1.forEach(item -> {
            String[] ia = item.split("\\s");
            list2.forEach(item2 -> {
                String[] ib = item2.split("\\s");
                if (charEqualsCount(ia, ib)) {
                    match = true;
                    res = res.concat(item + " : " + item2 + "\n");
                }

            });
            if (!match) {
                res = res.concat(item + " : ?\n");
            }
        });
    }

    private static boolean charEqualsCount(String[] a, String[] b) {
        AtomicInteger symbolMatch = new AtomicInteger();
        AtomicInteger request = new AtomicInteger();
        AtomicInteger minLengthWord = new AtomicInteger();

        Stream.of(a).map(String::toLowerCase).forEach(str1 ->
                Stream.of(b).map(String::toLowerCase).forEach(str2 -> {
                    minLengthWord.set(Math.min(str1.length(), str2.length()));

                    for (int i = 0; i < minLengthWord.get(); i++) {
                        char s = str1.charAt(i);
                        char s1 = str2.charAt(i);

                        request.getAndIncrement();

                        if (s == s1) {
                            symbolMatch.getAndIncrement();
                        }
                    }
                }));

        return (minLengthWord.get() / request.get()) < (symbolMatch.get() / minLengthWord.get());
    }
    private static void dataWriteToTxt(String string) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(writePath);
        writer.write(string);
        writer.flush();
        writer.close();
    }
}