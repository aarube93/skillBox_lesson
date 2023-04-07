import java.io.File;

public class fileAndFolder {
    public static void main(String[] args) {
        propertiesOfFile();
        propertiesOfFolder();
    }

    public static void propertiesOfFile() {
        File file = new File("data/Sherlock.txt");
        File folder = new File("data/");
        System.out.println(file.length());
        System.out.println(file.lastModified());

        System.out.println(file.isDirectory());
        System.out.println(folder.isDirectory());
    }

    public static void propertiesOfFolder() {
        File folder = new File("/users/alex/desktop/");
        File[] files = folder.listFiles();
        for(File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public static void createNewFolderFromJAVACode() {
        File folder = new File("/users/alex/desktop/newCodeFolder");
        folder.mkdir();
        folder.delete();
    }
}