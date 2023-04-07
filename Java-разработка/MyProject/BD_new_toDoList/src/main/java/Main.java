import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static String[] COMMAND_LIST() {
        String[] listComm = new String[11];
        listComm[0] = "exit";
        listComm[1] = "list";
        listComm[2] = "add";
        listComm[3] = "edit";
        listComm[4] = "delete";
        listComm[5] = "calc";
        listComm[6] = "time";
        listComm[7] = "add.time";
        listComm[8] = "time.c";
        listComm[9] = "help";
        listComm[10] = "count.words";
        return listComm;
    }

    public static String[] DIALOG_LIST() {
        String[] listAnswerWrong = new String[6];
        listAnswerWrong[0] = "Дело с таким номером не существует";
        listAnswerWrong[1] = "Лист задач пуст";
        listAnswerWrong[2] = "Неверная команда";
        listAnswerWrong[3] = "Пустая строка";
        listAnswerWrong[4] = "Список команд главного диалогового окна: ";
        return listAnswerWrong;
    }

    public static String lastCommand = "";
    public static TodoList todoList = new TodoList();

    public static void main(String[] args) throws InterruptedException {
        todoList.list.add(0, "");
        commandLine();
    }

    public static void commandLine() throws InterruptedException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String command = getArrayInput(input)[0];

            getTruthOfCommand(input);

            if (COMMAND_LIST()[9].equals(command)) {
                lastCommand = "";

                System.out.println(DIALOG_LIST()[4]);

                Stream.of(COMMAND_LIST()).forEach(System.out::println);
            }

            if (COMMAND_LIST()[0].equals(command)) {
                break;
            }

            if (COMMAND_LIST()[1].equals(command)) {
                lastCommand = "";

                if (todoList.list.size() == 1) {
                    System.out.println(DIALOG_LIST()[1]);
                } else {
                    getPrintList(todoList.list);
                }
            }

            if (COMMAND_LIST()[3].equals(command)) {
                lastCommand = "";

                if (getArrayInput(input).length < 3
                        || getIndex(input) < 1) {
                    System.out.println(DIALOG_LIST()[2]);
                    continue;
                }

                if (getIndex(input) < todoList.list.size()
                        && getArrayInput(input).length >= 3) {

                    todoList.edit(getIndex(input), input);

                } else {

                    System.out.println(DIALOG_LIST()[0]);
                }
            }

            if (COMMAND_LIST()[4].equals(command)) {
                lastCommand = "";

                if (getArrayInput(input).length > 2 || getIndex(input) < 1) {
                    System.out.println(DIALOG_LIST()[2]);
                    continue;
                }

                if (getIndex(input) > todoList.list.size()) {
                    System.out.println(DIALOG_LIST()[0]);
                    continue;
                }

                if (getArrayInput(input).length == 2
                        && getIndex(input) < todoList.list.size()) {

                    System.out.println("Дело \"" + todoList.list.get(getIndex(input)) + "\" удалено");
                    todoList.delete(getIndex(input));

                    if (todoList.list.size() != 1) {

                        getPrintList(todoList.list);

                    } else {

                        System.out.println(DIALOG_LIST()[1]);
                    }

                } else {
                    System.out.println(DIALOG_LIST()[0]);
                }
            }


//            if (COMMAND_LIST()[2].equals(command) ||
//                    lastCommand.equals(COMMAND_LIST()[2])) {
//
//
//                if (getIndex(input) > 0 && getIndex(input) <= todoList.list.size()) {
//                    todoList.add(getIndex(input), input);
//                } else {
//                    todoList.add(input);
//                }
//
//                lastCommand = COMMAND_LIST()[2];
//            }
            if (COMMAND_LIST()[2].equals(command) || lastCommand.equals(COMMAND_LIST()[2])) {
                lastCommand = COMMAND_LIST()[2];


            }
        }
    }
    public static void getTruthOfCommand(String input) throws InterruptedException {
        String command = getArrayInput(input)[0];
        boolean i = false;
        boolean f = true;

        for (String item : COMMAND_LIST()) {
            if (item.equals(command)) {
                i = false;
                f = false;
            }

            if (item.equals(lastCommand)) {
                i = false;
            }
        }
        if (command.equals(COMMAND_LIST()[2])
                && !lastCommand.equals(COMMAND_LIST()[2])
                && getArrayInput(input).length < 2) {

            i = true;
        }

        if (command.equals(COMMAND_LIST()[2])
                && lastCommand.equals(COMMAND_LIST()[2])
                && getArrayInput(input).length < 2) {

            i = true;
        }
        if (f && !lastCommand.equals(COMMAND_LIST()[2])
                && getArrayInput(input).length < 2) {

            i = true;
        }

        if (i) {
            System.out.println(DIALOG_LIST()[2]);
            commandLine();
        }

    }

    public static String[] getArrayInput(String input) {
        return input.split(" ", 5);
    }

    public static int getIndex(String input) {
        String[] words = getArrayInput(input);
        String find = "-1";

        if (words.length >= 2 && new Scanner(words[1]).hasNextInt()) {
            find = "";
            find = find.concat(words[1]);
        }
        return Integer.parseInt(find);
    }

    public static void getPrintList(ArrayList<String> listTodos) {
        for (int i = 1; i < listTodos.size(); i++) {
            String ret = Integer.toString(i);

            ret = ret.concat(" - ");
            System.out.println(ret.concat(listTodos.get(i)));
        }
    }

    public static String getAdd(String input) throws InterruptedException {
        String[] words = getArrayInput(input);
        int startCut = words[0].length();

        if (words.length <= 2 && getIndex(input) > 0) {
            System.out.println(DIALOG_LIST()[2]);
            commandLine();
        }
        if (words.length <= 1) {
            return input;
        }

        if (getIndex(input) > 0) {
            startCut = startCut + words[1].length();
        }
        return input.substring(startCut + 1);
    }
}