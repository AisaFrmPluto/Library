import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public boolean addBook(Book bookToAdd) {
        if (books.contains(bookToAdd)) {
            return false;
        } else {
            books.add(bookToAdd);
            return true;
        }
    }

    public boolean removeBook(Book bookToRemove) {
        return books.remove(bookToRemove);
    }

    public void changeTitle(Book book, String newTitle) {
        book.setTitle(newTitle);
    }

    public void changeAuthor(Book book, String newAuthor) {
        book.setAuthor(newAuthor);
    }

    public void changeGenre(Book book, String newGenre) {
        book.setGenre(newGenre);
    }

    public void moveBook(Book book, String newCodeShelf) {
        book.setCodeShelf(newCodeShelf);
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByShelfCode(String codeShelf) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getCodeShelf().equals(codeShelf)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByTitleKeyword(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getBooks() {
        return books;
    }
}

class Book {
    private String title;
    private String author;
    private String genre;
    private String codeShelf;

    //Constructor to initialize variables
    public Book(String title, String author, String genre, String codeShelf) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.codeShelf = codeShelf;
    }

    //Getters and setters to access and modify variables
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCodeShelf() {
        return codeShelf;
    }

    public void setCodeShelf(String codeShelf) {
        this.codeShelf = codeShelf;
    }
}