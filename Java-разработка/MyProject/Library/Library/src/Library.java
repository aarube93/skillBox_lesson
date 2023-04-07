import java.util.*;
import java.util.stream.Collectors;

public class Library {

    public static void main(String[] args) {
        Library a = new Library();
        a.books.stream().forEach(System.out::println);
        a.readers.stream().forEach(System.out::println);

        System.out.println("doWithoutLambda:____________________________________________________________________________");
        doWithoutLambda(a.books).forEach(System.out::println);

        System.out.println("DoWithLambda:_______________________________________________________________________________");
        List<Book> list = a.getBooks().stream()
                .sorted(Comparator.comparing(Book::getIssueYear)).toList();
        list.forEach(System.out::println);

//Требуется создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки. При этом
//флаг согласия на рассылку учитывать не будем:библиотека закрывается, так что хотим оповестить всех.
        System.out.println("ListOfEmailAddresses from for:______________________________________________________________");
        List<EmailAddress> addresses = new ArrayList<>();
        for (Reader item : a.getReaders()) {
            if (!item.isSubscriber() && item.getBooks().size() > 0) {
                addresses.add(new EmailAddress(item.getEmail()));
            }
        }
        addresses.forEach(System.out::println);

        System.out.println("ListOfEmailAddresses from lambda:___________________________________________________________");
        List<EmailAddress> addressesLambda = a.getReaders().stream()
                .filter(Reader::isSubscriber)
                .filter(reader -> reader.getBooks().size() > 1)
                .map(Reader::getEmail)
                .map(EmailAddress::new).toList();
        addressesLambda.forEach(System.out::println);

//Получить список всех книг, взятых читателями. Список не должен содержать дубликатов
//(книг одного автора, с одинаковым названием и годом издания).
        System.out.println("____________________________________________________________________________________________");
        Set<Book> result = new LinkedHashSet<>();
        for (Reader reader : a.getReaders()) {
            result.addAll(reader.getBooks());
        }
        result.forEach(System.out::println);

        System.out.println("____________________________________________________________________________________________");
        List<Book> bookList = a.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .distinct().toList();
        bookList.forEach(System.out::println);
    }

    public static List<Book> doWithoutLambda(List<Book> books) {
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getIssueYear().compareTo(o2.getIssueYear());
            }
        });
        return books;
    }
    private List<Book> books;
    private List<Reader> readers;
    public Library() {
        init();
    }
    private void init() {
        books = new ArrayList<>();
        books.add(new Book("Оруэлл", "1984", 2021));
        books.add(new Book("Джордж Оруэлл", "Скотный двор", 1944));
        books.add(new Book("Woman", "my body - my issues", 2017));
        //и так далее для других книг

        readers = new ArrayList<>();
        readers.add(new Reader("Иванов Иван Иванович", "ivanov.email@test.ru", true));
        readers.add(new Reader("владимиров Владимир Магомедович",
                "magomedov.email@test.ru", false));
        //и так далее для других читателей

        readers.get(0).getBooks().add(books.get(0));
        readers.get(0).getBooks().add(books.get(0));

        readers.get(1).getBooks().add(books.get(2));
        //и так далее для других читателей и взятых книг
    }
    public List<Book> getBooks() {
        return books;
    }
    public List<Reader> getReaders() {
        return readers;
    }
}