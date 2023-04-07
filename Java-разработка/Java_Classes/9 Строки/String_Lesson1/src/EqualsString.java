public class EqualsString {
    public static void main(String[] args) {
        howDoStringEquals();
    }

    public static void howDoStringEquals() {
//Сравнение и объединение строк. Важно - не сравнивать строки сравнением примитивов "==", так как
//при таком сравнение сравниваются адреса в памяти, а не значения.
        String manager = "Василий Петров";
        String customer = "Василий".concat(" Петров");
        System.out.println(manager.equals(customer));
    }
}
