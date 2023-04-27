import Structure.Names;
import Structure.Person;
import Structure.Surnames;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//Класс в многопоточном приложении который может возвращать значение. Не понятно, потокобезопасный он или нет и сколько
//потоков можно объеденить.
//Ниже попробуем поиграться с этим классом и получить какой нибудь список объектов со значениями из разных потоков.
public class Main {

    public static void main(String[] args) {
        Callable surnamesCallable = () -> {
            ArrayList<Surnames> surnames;
            surnames = new JsonParser("data/surnames.json").parseSurnames();
            return surnames;
        };

        Callable namesCallable = () -> {
            ArrayList<Names> names;
            names = new JsonParser("data/names.json").parseNames();
            return names;
        };
        FutureTask<ArrayList<Surnames>> surnamesFutureTask = new FutureTask<>(surnamesCallable);
        FutureTask<ArrayList<Names>> namesFutureTask = new FutureTask<>(namesCallable);

        for (int t = 0; t <= Runtime.getRuntime().availableProcessors() / 2; t++) {
            new Thread(surnamesFutureTask).start();
            new Thread(namesFutureTask).start();
        }

        try {
            Callable createPersons = () -> {
                TreeMap<String, Person> personTreeMap = new TreeMap<>();
                for (int i = 0; i < 100_000; i++) {
                    int n = new Random().nextInt(51529);
                    int s = new Random().nextInt(318474);
                    String name = namesFutureTask.get().get(n).getName();
                    String surname = surnamesFutureTask.get().get(s).getSurname();

                    if (namesFutureTask.get().get(n).isWomen() == surnamesFutureTask.get().get(s).isWomen()) {
                        System.out.println(name + " " + surname);

                        personTreeMap.put(
                                (name + " " + surname),
                                new Person(i, name, surname, namesFutureTask.get().get(n).isWomen()));
                    } else {
                        i--;
                    }
                }
                return personTreeMap;
            };
            FutureTask<TreeMap<String, Person>> personsFutureTask = new FutureTask<>(createPersons);
            for (int t = 0; t <= Runtime.getRuntime().availableProcessors(); t++) {
                new Thread(personsFutureTask).start();
            }

            System.out.println(personsFutureTask.get().size());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
