package WorkWithJSONParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
//Ошибка где-то в считывании файла staff.json
    public static void main(String[] args) {

        try {
            JSONParser parser = new JSONParser();
            String data = getDateFromFile();
            JSONArray array = (JSONArray) parser.parse(data);

            for (Object item : array) {
                JSONObject employee = (JSONObject) item;
                System.out.println(employee.get("name"));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String getDateFromFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> Lines = Files.readAllLines(Paths.get("data/staff.json"));
            for (String item : Lines) {
               builder.append(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
