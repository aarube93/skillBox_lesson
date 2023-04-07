import java.io.File;
import java.util.Scanner;
public class ExerciseOne {
    private static final String[] sizeNames =
            {"b", "kb", "Mb", "Gb"};
    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "Введите путь к папке или файлу: "
            );
            String path = new Scanner(System.in).nextLine();
            if (path.equals("Exit")) break;
            File folder = new File(path);
            String size =
                    getHumanReadableSize(getFolderSize(folder));
            System.out.println(
                    "Размер папки / файла: " + size
            );
        }
    }
    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        File[] files = folder.listFiles();
        long length = 0;
        assert files != null;
        for (File file : files) {
            length += getFolderSize(file);
        }
        return length;
    }
    public static String getHumanReadableSize(long length) {
        int power = (int) (Math.log(length) / Math.log(1024));
        double value = length / Math.pow(1024, power);
        double roundedValue = Math.round(value * 100) / 100.;
        return roundedValue + " " + sizeNames[power];
    }
}