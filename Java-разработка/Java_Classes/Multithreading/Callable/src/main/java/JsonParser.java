import Structure.Names;
import Structure.Surnames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.Long.parseLong;

public class JsonParser {
    private final String path;
    public JsonParser(String path) {
        this.path = path;
    }

    public ArrayList<Names> parseNames() throws Exception {
        ArrayList<Names> names = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String[] jsonString = new String[0];
        for (int i = 0; i < 1; i++) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            jsonString = line.substring(3).split(",\\{");
        }

        for (String s : jsonString) {
            String[] jO = (s.substring(0, (s.length()) - 1)).split(",");
            names.add(new Names(
                    parseLong(jO[0].substring(5)),
                    jO[1].substring(8, jO[1].length() - 1),
                    jO[2].charAt(7) == 'Ж'
                    ));

        }
        br.close();
        return names;
    }

    public ArrayList<Surnames> parseSurnames() throws Exception {
        ArrayList<Surnames> surnames = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));

        String[] jsonString = new String[0];
        for (int i = 0; i < 1; i++) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            jsonString = line.substring(3).split(",\\{");
        }
        for (String s : jsonString) {
            String[] jO = s.split(",");
            long longId = parseLong(jO[0].substring(5));
            surnames.add(new Surnames(longId,
                    jO[1].substring(11, jO[1].length() - 1),
                    longId % 2 == 0
                    ));
        }
        br.close();
        return surnames;
    }
}