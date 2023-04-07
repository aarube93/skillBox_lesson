public class numberToString {
    public static void main(String[] args) {
        valueToStringAuto();
        primitiveToStringExplicit();
        objectValueToString();
        HowDoStringEquals();
        StringToDouble();
        StringToInt();
    }

    public static void valueToStringAuto() {
//Не явное преобразование переменной в строку:
        int age = 37;
        String name = "Ann";
        String personInfo = name + " - " + age + " Old";
        System.out.println(personInfo);
    }

//явное преобразование переменной:
    public static void primitiveToStringExplicit() {
//Преобразование из примитива в строку:
        int age = 37;
        String HowOld = Integer.toString(age);
        String howOldValueOf = String.valueOf(age);
        System.out.println(HowOld);
        System.out.println(howOldValueOf);
    }

    public static void objectValueToString() {
//Преобразование из объекта класса в строку:
        Integer age = 37;
        String HowOld = age.toString();
        String howOldValueOf = String.valueOf(age);
        System.out.println(howOldValueOf);
        System.out.println(HowOld);
    }

    public static void HowDoStringEquals() {
//Сравнение и объединение строк. Важно - не сравнивать строки сравнением примитивов "==", так как
//при таком сравнение сравниваются адреса в памяти а не значения.
        String manager = "Василий Петров";
        String customer = "Василий".concat(" Петров");
        System.out.println(manager.equals(customer));
    }

//Преобразуем стринг в переменную, парсим строку, другими слоовами:
    public static void StringToInt() {
        String value = "7685565";
        int count = Integer.parseInt(value);
        System.out.println(count);
    }

    public static void StringToDouble() {
        String value = "986.9865755";
        double weight = Double.parseDouble(value);
        System.out.println(weight);
    }
}
