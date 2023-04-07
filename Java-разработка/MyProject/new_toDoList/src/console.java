import java.util.*;
import java.util.stream.Stream;

public class console {
    public static String[] COMMAND_LIST() {
        String[] listComm = new String[9];
        listComm[0] = "exit";
        listComm[1] = "list";
        listComm[2] = "printAll";
        listComm[3] = "edit";
        listComm[4] = "delete";
        listComm[5] = "help";
        listComm[6] = "newBranch";
        listComm[7] = "changeBranch";
        listComm[8] = "add";
        return listComm;
    }

    public static String[] DIALOG_LIST() {
        String[] listAnswerWrong = new String[7];
        listAnswerWrong[0] = "Дело с таким номером не существует";
        listAnswerWrong[1] = "Лист задач пуст";
        listAnswerWrong[2] = "Неверная команда";
        listAnswerWrong[3] = "Пустая строка";
        listAnswerWrong[4] = "Список команд главного диалогового окна: ";
        listAnswerWrong[5] = "Input name for new toDoList: ";
        listAnswerWrong[6] = "Choose work branch: ";
        return listAnswerWrong;
    }

    public static boolean repeatAdd = false;
    public static String branch;
    public static List<TodoList> deals = new ArrayList<>();

    public static void main(String[] args) {
        commandLine();
    }

    public static void commandLine() {
        System.out.println("Hello, my dear user! I'm glad to see you there!\nFor successful using this app do you " +
                "need input name for new categories your deals.\nInput 'newBranch' and move on!");
        try {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                String command = getArrayInput(input)[0];

                if (COMMAND_LIST()[0].equals(command)) {//exit
                    break;
                } else if (COMMAND_LIST()[1].equals(command)) {//list
                    repeatAdd = false;
                    System.out.println("Current list: " + branch + ".");
                    Objects.requireNonNull(getItem()).list.forEach(System.out::println);
                } else if (COMMAND_LIST()[2].equals(command)) {//printAll
                    repeatAdd = false;
                    for (TodoList deal : deals) {
                        System.out.println("Name list: " + deal.getName() + ".");
                        for (int b = 0; b < deal.list.size(); b++) {
                            System.out.println(b + " - " + deal.list.get(b));
                        }
                    }
                } else if (COMMAND_LIST()[3].equals(command)) {//edit
                    repeatAdd = false;

                    if (getIndex(input) < Objects.requireNonNull(getItem()).list.size()
                            && getArrayInput(input).length >= 3) {
                        getItem().edit(getIndex(input), input);

                    } else {

                        System.out.println(DIALOG_LIST()[0]);
                    }
                } else if (COMMAND_LIST()[4].equals(command)) {//delete
                    repeatAdd = false;
                    System.out.println("Дело \"" + Objects.requireNonNull(getItem())
                            .list.get(getIndex(input)) + "\" удалено");

                    getItem().delete(getIndex(input));

                    if (getItem().list.size() != 1) {
                        System.out.println(getItem().list.toString());
                    } else {
                        System.out.println(DIALOG_LIST()[1]);
                    }
                } else if (COMMAND_LIST()[5].equals(command)) {//help
                    repeatAdd = false;
                    System.out.println(DIALOG_LIST()[4]);
                    Stream.of(COMMAND_LIST()).forEach(System.out::println);

                } else if (COMMAND_LIST()[6].equals(command)) {//newList
                    repeatAdd = false;

                    deals.add(new TodoList(getArrayInput(input)[1]));
                    branch = getArrayInput(input)[1];
                    System.out.println("New list \"" + branch + "\" was created!");

                } else if (COMMAND_LIST()[7].equals(command)) {//setBranch
                    repeatAdd = false;

                    branch = getArrayInput(input)[1];
                    System.out.println("Current list is " + branch + ".");


                } else if (COMMAND_LIST()[8].equals(command) || repeatAdd) {//add

                    if (getIndex(input) > 0 && getIndex(input) <= Objects.requireNonNull(getItem()).list.size()) {
                        getItem().add(getIndex(input), input);
                    } else {
                        Objects.requireNonNull(getItem()).add(input);
                    }
                    repeatAdd = true;

                } else {
                    System.out.println(DIALOG_LIST()[2]);
                }
            }

        } catch (Exception ex) {
            System.err.print(ex);
        } finally {
            System.out.println("\n" + DIALOG_LIST()[4]);
            Stream.of(COMMAND_LIST()).forEach(System.out::println);
        }
    }

    public static String[] getArrayInput(String input) {
        return input.split(" ", 4);
    }

    public static String getAdd(String input) {
        int startCut = getArrayInput(input)[0].length();

        if (repeatAdd) {
            return input;
        }

        if (getArrayInput(input).length <= 2 && getIndex(input) > 0) {
            System.out.println(DIALOG_LIST()[2]);
            commandLine();
        }

        if (getArrayInput(input).length < 2) {
            return input;
        }

        if (getIndex(input) > 0) {
            startCut = startCut + getArrayInput(input)[1].length();
        }

        return input.substring(startCut + 1);
    }

    public static int getIndex(String input) {
        String find = "-1";

        if (getArrayInput(input).length >= 2 && new Scanner(getArrayInput(input)[1]).hasNextInt()) {
            find = getArrayInput(input)[1];
        }
        return Integer.parseInt(find);
    }

    public static TodoList getItem() {
        for (TodoList list : deals) {
            if (list.getName().equals(branch)) {
                return list;
            }
        }
        return null;
    }
}