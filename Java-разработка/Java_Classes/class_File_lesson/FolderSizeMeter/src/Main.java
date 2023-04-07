import java.io.File;
import java.util.Scanner;

public class Main {
    private static final String[] sizeNames = {"b", "kb", "Mb", "Gb"};

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите путь к папке или файлу:");
            String path = new Scanner(System.in).nextLine();
            if (path.equals("exit")) break;
            File item = new File(path);
            String size = getHumanReadableSize(getFolderSize(item));

            if (item.isDirectory()) {
                System.out.println("Размер папки : " + size);
            } else {
                System.out.println("Размер файла : " + size);
            }
        }

    }

    public static long getFolderSize(File item) {
        if (item.isFile()) {
            return item.length();
        }

        File[] files = item.listFiles();
        long length = 0;
        assert files != null;
        for (File file : files) {
            length += getFolderSize(file);
        }
        return length;
    }

    public static String getHumanReadableSize(long size) {
        int power = (int) (Math.log(size) / Math.log(1024));
        double value = size / Math.pow(1024, power);
        double roundedValue = Math.round(value * 100) / 100.;
        return roundedValue + " " + sizeNames[power];

    }
}