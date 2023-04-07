import java.util.ArrayList;

public class TodoList {
    ArrayList<String> list = new ArrayList<>();
    String name;

    public TodoList(String name) {
        this.name = name;
    }

    public void add(String input) {
        list.add(console.getAdd(input));
        System.out.println("Добавлено дело " + "\"" + console.getAdd(input) + "\"");
    }

    public void add(int index, String todo) {
        list.add(index, console.getAdd(todo));
        System.out.println("Добавлено дело номер " + index + " - \"" + console.getAdd(todo) + "\"");
    }

    public void edit(int index, String todo) {
        System.out.println("Дело " + "\"" + list.get(index) + "\"" + " заменено на "
                + "\"" + console.getAdd(todo) + "\"");
        list.set(index, console.getAdd(todo));
    }

    public void delete(int index) {
        list.remove(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        int i = 0;
        for (String item : list) {
            i++;
            return i + "-" + item;
        }
        return "list's empty";
    }
}