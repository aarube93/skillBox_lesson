import java.util.*;

public class Use_HashSet_And_TreeSet {
//MAP - разновидность коллекции. В MAP может храниться соответствие ключей неким значениям,
// при этом ключи должны быть обязательно уникальны, поэтому ключи хранятся в SET.
    //Ключ - это параметр, по которому мы получаем значение. Ключ - это первый параметр. Значение - это второй параметр.
    //Ключ может быть любым, так и значение может быть любым.

    //Рассмотрим такой простой пример кода на HAshMap:
    public static void main(String[] args) {
       // hashMethod();
        //treeMapMethod();
        treeMapSortByCountObject();
    }
    public static void printHashMap(Map<String,Integer> map ) {
        for(String key : map.keySet()) {
            System.out.println(key + "=>" + map.get(key));
        }

        // или вот таким образом:
//        Set<String> keys = map.keySet();
//        for(String key : keys) {
//            System.out.println(key + "=>" + map.get(key));
//        }
    }

    public static void hashMethod() {
        HashMap<String, Integer> goods2count = new HashMap<>();
        //какие методы есть у HashMap:

//        goods2count.put(String key, Integer value)
//        goods2count.get(Object key) - на вход получает ключ и выдает значение(строку в нашем случае)
//        goods2count.remove(object key, Object value)

        Scanner valueScanner = new Scanner(System.in);
        for (;;){
            String inputString = valueScanner.nextLine();
            if (inputString.equals("LIST")) {
                printHashMap(goods2count);
                continue;
            }
            String[] wordsOfInput = inputString.split("\\s");

            for (int i = 0; i < wordsOfInput.length; i++ ){
                String goodName = wordsOfInput[i];
                int count = 1;
                if (goods2count.containsKey(goodName)) {
                    count = goods2count.get(goodName) + 1;
                }
                goods2count.put(goodName, count);
            }
        }
    }

    //в этих методах не выполнена сортировка значений, по причине того что не используется TreeMap,
    // рассмотрим вариант такого кода на TreeMap: Этот список выводит и хранит значения в алфавитном порядке
    public static void treeMapMethod () {
        TreeMap<String, Integer> good2count = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            String inputString = scanner.nextLine();
            if (inputString.equals("LIST")) {
                printHashMap(good2count);
                continue;
            }
            String[] wordsOfInput = inputString.split("\\s");
            for (int i = 0; i < wordsOfInput.length; i++ ){
                String goodName = wordsOfInput[i];
                int count = 1;
                if (good2count.containsKey(goodName)) {
                    count = good2count.get(goodName) + 1;
                }
                good2count.put(goodName, count);
            }
        }
    }

    public static void treeMapSortByCountObject () {
        TreeMap<String, Integer> good2count = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            String inputString = scanner.nextLine();
            if (inputString.equals("LIST")) {
                printSortMap(good2count);
                continue;
            }
            String[] wordsOfInput = inputString.split("\\s");
            for (int i = 0; i < wordsOfInput.length; i++ ){
                String goodName = wordsOfInput[i];
                int count = 1;
                if (good2count.containsKey(goodName)) {
                    count = good2count.get(goodName) + 1;
                }
                good2count.put(goodName, count);
            }
        }
    }

    public static void printSortMap(Map<String,Integer> map ) {
                TreeSet<String> StringForPrint = new TreeSet<String>();
        for(String key : map.keySet()) {
            String value = map.get(key) + "=> \"" + key + "\"";
            StringForPrint.add(value);
        }

        for (String prt : StringForPrint) {
            System.out.println(prt);
        }
    }
}
