package programmingConcept.Book_Management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataFactory {
    //Write and save book into book list and into book file
    public static boolean saveBookList(List<Book> books, String path){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            for ( Book book:books) {
                String dataLine = book.getTitle()+";"+book.getAuthorName()+";"+book.getISBN()+";"+book.getYear();
                bufferedWriter.write(dataLine);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    // Read Book Data
    public static List<Book> readBookList(String path) {
        List<Book> books = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String dataLine = bufferedReader.readLine();

            while (dataLine != null){
                String [] BookData = dataLine.split(";");
                String bookTitle = BookData[0];
                String bookAuthorName = BookData[1];
                int bookISBN = Integer.parseInt(BookData[2]);
                int bookYear = Integer.parseInt(BookData[3]);
                books.add(new Book(bookTitle,bookAuthorName,bookISBN,bookYear));
                dataLine = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
