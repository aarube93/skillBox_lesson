import java.io.File;

public class ClassFile {
    public static void main(String[] args) {
        File file = new File("/Users/rube/Desktop/sql/SQL.txt");
        File folder = new File("/Users/rube/Desktop/sql");

        System.out.println(file.length());
        System.out.println(file.lastModified());
        //file.delete(); - пока работает с файлом, не будем его удалять. МОжно ли создать файл и из каих данных?
        System.out.println("File: " + file.isDirectory());
        System.out.println("Folder: " + folder.isDirectory());

        File[] files = folder.listFiles();
        for(File item : files) {
            System.out.println(item);
            System.out.println(item.getAbsolutePath());
        }

        File createNewFolder = new File("/Users/rube/Desktop/sql/newmkdieFOLD");
        createNewFolder.mkdir();
        createNewFolder.delete();
    }
}
