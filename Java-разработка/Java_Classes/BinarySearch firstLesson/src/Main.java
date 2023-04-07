import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        firstBinarySearch();
        fillingFirstList();
        fillingSecondList();
        fillingThirdList();
        fillingFourthList();
        fillingFifthList();
        fillingSixthList();
    }

    public static void firstBinarySearch() {
//Бинарный поиск очень удобно и достаточно быстро работает с отсортированными данными списков и листов.
//Принцип его действия таков: он разделяет список по полам, в соответствие с принципом сортировки
// элементов по алфавиту, дальше делить ту часть в которой должен быть искомый объект пополам.
        //То есть список в 1млн объектов пройдет за несколько операций. Но в случае, если список не будет сортирован,
// то поиск будет произведен за 1млн операций обращения к каждому элементу.
        String string = "Loop";
        ArrayList<String> items = new ArrayList<>();
        items.add("Loop");

        Collections.sort(items);
        Collections.binarySearch(items, string);
// - возвращает номер элемента из ArrayList, в случае если нашел его, в противном случае возвращает -1.
        if (Collections.binarySearch(items, string) >= 0) {
            System.out.println(items.get(Collections.binarySearch(items, string)));
        } else {
            System.out.println("Element not found");
        }
    }

    public static void fillingFirstList() {
        HashSet<String> firstList = new HashSet<>();

        String[] letter = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

        for (int i = 001; i <= 30; i += 1) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            if (reg < 10) {
                                firstList.add(String.format("%s%03d%s%s%d%d", a1, i, a2, a3, 0, reg));
                            } else {
                                firstList.add(String.format("%s%03d%s%s%d", a1, i, a2, a3, reg));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(firstList.size());
    }

    public static void fillingSecondList() {
        HashSet<String> secondList = new HashSet<>();
        String[] letter = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

        for (int i = 101; i <= 200; i += 1) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            if (reg < 10) {
                                secondList.add(String.format("%s%03d%s%s%d%d", a1, i, a2, a3, 0, reg));
                            } else {
                                secondList.add(String.format("%s%03d%s%s%d", a1, i, a2, a3, reg));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(secondList.size());
    }

    public static void fillingThirdList() {
        HashSet<String> thirdList = new HashSet<>();
        String[] letter = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

        for (int i = 201; i <= 300; i += 1) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            if (reg < 10) {
                                thirdList.add(String.format("%s%03d%s%s%d%d", a1, i, a2, a3, 0, reg));
                            } else {
                                thirdList.add(String.format("%s%03d%s%s%d", a1, i, a2, a3, reg));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(thirdList.size());
    }

    public static void fillingFourthList() {
        HashSet<String> fourthList = new HashSet<>();
        String[] letter = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

        for (int i = 301; i <= 400; i += 1) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            if (reg < 10) {
                                fourthList.add(String.format("%s%03d%s%s%d%d", a1, i, a2, a3, 0, reg));
                            } else {
                                fourthList.add(String.format("%s%03d%s%s%d", a1, i, a2, a3, reg));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(fourthList.size());
    }

    public static void fillingFifthList() {
        HashSet<String> fifthList = new HashSet<>();
        String[] letter = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

        for (int i = 301; i <= 400; i += 1) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            if (reg < 10) {
                                fifthList.add(String.format("%s%03d%s%s%d%d", a1, i, a2, a3, 0, reg));
                            } else {
                                fifthList.add(String.format("%s%03d%s%s%d", a1, i, a2, a3, reg));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(fifthList.size());
    }

    public static void fillingSixthList() {
        HashSet<String> sixthList = new HashSet<>();
        String[] letter = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

        for (int i = 301; i <= 400; i += 1) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            if (reg < 10) {
                                sixthList.add(String.format("%s%03d%s%s%d%d", a1, i, a2, a3, 0, reg));
                            } else {
                                sixthList.add(String.format("%s%03d%s%s%d", a1, i, a2, a3, reg));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sixthList.size());
    }
}

