public class reversePrintEnumerationSet {
    public static void main(String[] args) {
        reversPrintSet();
        matchFindOneByOne();
        reversArraysReturn();
    }

    public static void reversPrintSet() {
        System.out.println("\n\nreversPrintSet:");
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colors = text.split(",?\\s");
//Для вывода массива в обратном порядке, вводим переменную равную концу длинны строки,
//поэтому colors.length - 1 в данном случае массив из семи элементов, начиная с 0, то есть
//colors.length дает семь (7), поэтому необходимо вычесть 1.
        for (int i = colors.length - 1; i >= 0; i--) {
            System.out.println(colors[i]);
        }
    }

    //Исключение из печати двух одинаковых подряд идущих элементов:
    public static void matchFindOneByOne() {
        System.out.println("\n\nmatchFindOneByOne:");
        String text = "Каждый Каждый охотник охотник желает знать, где где сидит фазан";
        String[] colors = text.split(",?\\s");
        for (int i = 0; i < colors.length; i++) {
//Мы проверяем, не меньше ли нуля I, зачем что сравнить -1 не представляется возможным, его не существует
            if (i > 0 && colors[i].equals(colors[i - 1])) {
                continue;
            }
            System.out.println(colors[i]);
        }
    }

    public static void reversArraysReturn() {
//Для разворота массива можно пользоваться во таким методом. Как он, черт возьми, работает я пока что не понял,
//поэтому просто оставлю его здесь
        int[] array_nums = {1,2,3,4,5,6,7,8,9,0};
        int x = 0;
        for (int i = 0; i < array_nums.length / 2; i++) {
            x = array_nums[i];
            array_nums[i] = array_nums[array_nums.length - 1 - i];
            array_nums[array_nums.length - 1 - i] = x;
        }
        for (int mirrorArray:array_nums) {
            System.out.println("reversArraysReturn" + mirrorArray);
        }
    }
}
