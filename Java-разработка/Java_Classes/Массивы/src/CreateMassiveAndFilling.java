public class CreateMassiveAndFilling {
    public static void main(String[] args) {
        createMassive();
        convenientCreateMassive();
        createMassiveObject();
        createFromMethod();
        fillingMassiveAndEnumeration();
        otherSyntaxForOutputMassive();
    }

    public static void createMassive() {
//Например, создадим массив из примитива с количеством комнат на этажах.
// Для создания массива после типа переменной ставим - пример:
// int [] name = new int[количество элементов в массиве]
        System.out.println("createMassive:");
        int[] roomCounts = new int[8];
        roomCounts[0] = 5;
        roomCounts[1] = 34;
        roomCounts[2] = 89;
        roomCounts[3] = 45;
        roomCounts[4] = 90;
//если переменная примитив, то не указанные значения заполнять автоматически (инициализируется),
// по умолчанию это 0.
        //Можем распечатать массив. Для этого напишем цикл:
//В данном случае length это свойство, а не метод, поэтому без ();
        for (int a = 0; a < roomCounts.length; a++) {
            System.out.println("printNewMassive: " + roomCounts[a]);
        }
    }

    public static void convenientCreateMassive() {
        System.out.println("\n\nconvenientCreateMassive:");
        int[] roomsCont2 = {5, 7, 89, 77, 0};
        for (int b = 0; b < roomsCont2.length; b++) {
            System.out.println("convenientCreateMassive: " + roomsCont2[b]);
        }
    }

    public static void createMassiveObject() {
        System.out.println("\n\ncreateMassiveObject:");
        String[] colors = {"Красный", "Оранжевый", "Желтый", "Зеленый"};
        for (int b = 0; b < colors.length; b++) {
            System.out.println("createMassiveObject: " + colors[b]);
        }
    }

    public static void createFromMethod() {
        System.out.println("\n\ncreateFromMethod:");
//А можно массивы получать из каких-нибудь методов - можно получать элементы из текста, например,
//разделяя по строчно с помощью пробелов:
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colors = text.split(",?\\s+");
        for (int c = 0; c < colors.length; c++) {
            System.out.println("createFromMethod: " + colors[c]);
        }
    }
//Какие бывают еще способы перебора элементов массива. В методах выше переменная из цикла позволяет
//обратиться к определенному элементу массива по его номеру.

    public static void fillingMassiveAndEnumeration() {
        System.out.println("\n\nfillingMassiveAndEnumeration:");
//Например, мы хоти сгенерировать некоторое количество лотерейных билетов и заполнить их в массив:
        int ticketNumbers[] = new int[1000];
        int[] winTickets = new int[10];

        for (int i = 0; i < ticketNumbers.length; i++) {
            int value = 1_000_000 + (int) Math.round(1_000_000 * Math.random());
            ticketNumbers[1] = value;
            System.out.println("Лотерейный билет № " + i + ": " + value);//Распечатает 1000 билетов с разными номерами.
            winTickets[i / 100] = value;
        }
//Метод, который позволяет вывести все значения массива без перебора, имеет несколько другой синтаксис:
        for (int winTicketNumbers : winTickets) {
            System.out.println("ВЫЙГРЫШНЫЙ БИЛЕТ № " + winTicketNumbers);
        }
    }

    public static void otherSyntaxForOutputMassive() {
        System.out.println("\n\notherSyntaxForOutputMassive:");
//Например, повторим вывод с радугой, но с помощью синтаксиса вывода данных массива
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colors = text.split(",?\\s+");
        for (String colorWord : colors) {
            System.out.println("Вывод другим синтаксисом: " + colorWord);
        }
    }
}

