package Week1_DataStructuresAndAlgorithms.Exercise6_LibraryManagementSystem.Code;

import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManager {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Basics", "John Doe"),
            new Book(2, "Data Structures", "Jane Smith"),
            new Book(3, "Operating Systems", "Andrew Tanenbaum"),
            new Book(4, "Web Development", "Mark Lee")
        };

        System.out.println("Linear Search for 'Operating Systems':");
        Book result1 = linearSearch(books, "Operating Systems");
        System.out.println(result1 != null ? result1 : "Book not found");

        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\nBinary Search for 'Java Basics':");
        Book result2 = binarySearch(books, "Java Basics");
        System.out.println(result2 != null ? result2 : "Book not found");
    }
}