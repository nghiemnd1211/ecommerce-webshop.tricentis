package programmingConcept.Book_Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestBookManagement {
    static List<Book> books = new ArrayList<>();
    static String path = "D:\\BookList.txt";

    public static void bookMenu() {
//        System.out.println("\tBOOK LIST\t");
//        List <Book> books = DataFactory.readBookList(path);
//        for(Book b:books)
//            System.out.println(b);

        System.out.println("Please select an Option: ");
        System.out.println("\t1. Add a new book");
        System.out.println("\t2. Find book by title");
        System.out.println("\t3. Find book by author name");
        System.out.println("\t4. Find book by ISBN");
        System.out.println("\t5. Exit the program");
        System.out.print("\nInput here: ");
        Scanner scanner = new Scanner(System.in);
        int inputOption = scanner.nextInt();
        switch (inputOption) {
            case 1:
                addBook();
                break;
            case 2:
                findByTitle();
                break;
            case 3:
                findByAuthorName();
                break;
            case 4:
                findByISBN();
                break;
            case 5:
                System.exit(5);
                break;
            default:
                System.out.println("This is an invalid option. Please try again!");
        }
    }

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a book name: ");
        String bookTitle = scanner.nextLine();

        System.out.println("Please enter author name: ");
        String bookAuthor = scanner.nextLine();

        System.out.println("Please enter ISBN: ");
        int ISBN = scanner.nextInt();

        System.out.println("Please enter year: ");
        int year = scanner.nextInt();

        Book book = new Book(bookTitle,bookAuthor,ISBN,year);
        books.add(book);
        DataFactory.saveBookList(books,path);
    }

    public static void findByTitle()
    {
        Book book = new Book();
        List<Book> books = DataFactory.readBookList(path);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a book title: ");
        String inputTitle = scanner.nextLine();
        for(Book book_:books){
            if(book_.getTitle().equals(inputTitle)){
                book = book_;
            }
        }
        if(book.getTitle()==null){
            System.out.println("There is no existing book");
        }
        else
            System.out.println(book+"\n");
    }
    public static void findByISBN() {
        Book book = new Book();
        List<Book> books = DataFactory.readBookList(path);

        System.out.println("Please enter ISBN: ");
        Scanner scanner = new Scanner(System.in);
        int inputISBN = scanner.nextInt();
        for (Book book_:books) {
            if(book_.getISBN()==inputISBN)
                book = book_;
        }
        if(book.getTitle() == null)
            System.out.println("There is no existing book");
        else
            System.out.println(book);
    }

    public static void findByAuthorName() {
        List<Book> booklistFromAuthor = new ArrayList<>();
        List<Book> books = DataFactory.readBookList(path);

        System.out.println("Please enter an author name: ");
        Scanner scanner = new Scanner(System.in);
        String inputAuthorName = scanner.nextLine();
        for (Book book_:books) {
            if(book_.getAuthorName().equals(inputAuthorName)) {
                booklistFromAuthor.add(book_);
            }
        }
        if(booklistFromAuthor.isEmpty())
            System.out.println("There is no books for the author: "+inputAuthorName);

        for(Book authorBook: booklistFromAuthor){
            System.out.println(authorBook);
        }
    }

    public static void main(String[] args) {
        while (true) {
            bookMenu();
        }
    }
}
