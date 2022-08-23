package JavaLearning.Book_Management;

public class Book {
    private String title;
    private String authorName;
    private int ISBN;
    private int year;

    public Book(){
    }
    public Book(String title, String authorName, int ISBN, int year) {
        this.title = title;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.year = year;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", ISBN=" + ISBN +
                ", year=" + year +
                '}';
    }
}
