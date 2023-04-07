package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "https://www.pornhub.com/";
        Document doc = Jsoup.connect(url).get();
        Elements images = doc.select("img");
        HashSet<String> links = new HashSet<>();
        for (Element image : images) {
            links.add(image.attr("abs:src"));
        }

        int number = 0;

        for(String lnk : links) {
            String extension = lnk
                    .replaceAll("^.+\\.", "")
                    .replace("?.+$", "");
            String filePath = "data/" + number++ + "." + extension;
            try {
                download(lnk, filePath);
            } catch (Exception ex) {
                System.out.println("Couldn't download " +
                        lnk);
            }
        }
    }

    public static void download(String lnk, String filePath) throws IOException {
        URLConnection connection = new
                URL(lnk).openConnection();
        InputStream inStream = connection.getInputStream();

        FileOutputStream outStream = new FileOutputStream(filePath);
        int b;
        while((b = inStream.read()) != -1) {
            outStream.write(b);
        }
        outStream.flush();
        outStream.close();
        inStream.close();
    }
}