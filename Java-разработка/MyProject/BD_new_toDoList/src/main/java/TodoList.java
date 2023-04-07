import java.util.ArrayList;

public class TodoList {
    ArrayList<String> list = new ArrayList<>();

    public void add(String todo) throws InterruptedException {
        list.add(Main.getAdd(todo));
        System.out.println("Добавлено дело " + "\"" + Main.getAdd(todo) + "\"");
    }

    public void add(int index, String todo) throws InterruptedException {
        list.add(index, Main.getAdd(todo));
        System.out.println("Добавлено дело номер " + index + " - \"" + Main.getAdd(todo) + "\"");
    }

    public void edit(int index, String todo) throws InterruptedException {
        System.out.println("Дело " + "\"" + list.get(index) + "\"" + " заменено на " + "\"" + Main.getAdd(todo) + "\"");
        list.set(index, Main.getAdd(todo));
    }

    public void delete(int index) {
        list.remove(index);
    }
}