import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipAction {
    public static void main(String[] args) {
        String path = "/Users/rube/Desktop/";
        String nameFile = "java_basics";
        String in = path + "java_basics" ;
        String out = path + nameFile + "_zip.zip";

        try{
            FileOutputStream outputStream = new FileOutputStream(out);
            ZipOutputStream zipOut = new ZipOutputStream(outputStream);
            writeFileToZip(new File(in), zipOut, "");
            zipOut.flush();
            zipOut.close();
            outputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFileToZip(File f, ZipOutputStream z, String p) throws Exception {
         if (f.isDirectory()) {
             String folder = p.concat(f.getName()).concat("/");

             ZipEntry entry = new ZipEntry(folder);
             z.putNextEntry(entry);
             z.closeEntry();
             File[] files = f.listFiles();
             for (File subFile : files) {
                 writeFileToZip(subFile, z, folder);
             }
             return;
         }
         ZipEntry entry = new ZipEntry(p + f.getName());
         z.putNextEntry(entry);
         byte[] data = Files.readAllBytes(Paths.get(f.getAbsolutePath()));
         z.write(data);
    }
}