public class Book {

    private int id;
    private static int idGen = 1;

    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book(String title, String author, int year) {
        this.id = idGen++;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        available = false;
    }

    public void returns() {
        available = true;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title +
                "', author='" + author + "', year=" + year +
                ", available=" + available + "}";
    }

    public static void main(String[] args) {
        Book b = new Book("Clean Code", "Robert Martin", 2008);
        System.out.println(b);
        b.borrow();
        System.out.println("After borrow: " + b);
        b.returns();
        System.out.println("After return: " + b);
    }

    public String getTitle() {
        return "";
    }
}
