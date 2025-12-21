import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n1.Print all books");
            System.out.println("2.Add new book");
            System.out.println("3.Search by title");
            System.out.println("4.Borrow book");
            System.out.println("5.Return book");
            System.out.println("6.Delete book");
            System.out.println("7.Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> printAll();
                case 2 -> add();
                case 3 -> search();
                case 4 -> borrow();
                case 5 -> returns();
                case 6 -> delete();
                case 7 -> {
                    System.out.println("Bye!");
                    return;
                }
            }
        }
    }

    private void printAll() {
        if (books.isEmpty())
            System.out.println("No books");
        else
            books.forEach(System.out::println);
    }

    private void add() {
        System.out.print("Title: ");
        String t = scanner.nextLine();
        System.out.print("Author: ");
        String a = scanner.nextLine();
        System.out.print("Year: ");
        int y = scanner.nextInt();
        scanner.nextLine();

        books.add(new Book(t, a, y));
    }

    private void search() {
        System.out.print("Search: ");
        String s = scanner.nextLine().toLowerCase();
        for (Book b : books)
            if (b.getTitle().toLowerCase().contains(s))
                System.out.println(b);
    }

    private void borrow() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book b : books) {
            if (b.getId() == id) {
                if (b.isAvailable())
                    b.borrow();
                else
                    System.out.println("Already borrowed");
                return;
            }
        }
        System.out.println("Not found");
    }

    private void returns() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book b : books) {
            if (b.getId() == id) {
                b.returns();
                return;
            }
        }
        System.out.println("Not found");
    }

    private void delete() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        books.removeIf(b -> b.getId() == id);
    }

    public static void main(String[] args) {
        new LibraryApp().run();
    }
}

