import java.util.ArrayList;
import java.util.List;

public class Library {
    public List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book bookToAdd) {
        for (Book book : books) {
            assert bookToAdd != null;
            if (book.getTitle().equals(bookToAdd.getTitle()) && book.getAuthor().equals(bookToAdd.getAuthor())) {
                bookToAdd = null;
                break;
            } else bookToAdd = book;
        }
        if (bookToAdd != null) {
            books.add(bookToAdd);
            System.out.println("The book \"" + bookToAdd.getTitle() + "\" by " + bookToAdd.getAuthor()
                    + " is added to the library.");
        } else System.out.println("Book already in the library.");
    }

    public void removeBook(Book bookToRemove) {
        for (Book book : books) {
            assert bookToRemove != null;
            if (book.getTitle().equals(bookToRemove.getTitle()) && book.getAuthor().equals(bookToRemove.getAuthor())) {
                bookToRemove = book;
                break;
            } else bookToRemove = null;
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("The book \"" + bookToRemove.getTitle() + "\" by " + bookToRemove.getAuthor()
                    + " is removed from the library.");
        } else System.out.println("Book not found in the library.");
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
        System.out.println("The book \"" + book.getTitle() + "\" by " + book.getAuthor()
                + " is moved to shelf " + newCodeShelf + ".");
    }

    public void searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book.getTitle() + "\" By " + book.getAuthor());
            } else System.out.println("Nothing is found.");
        }
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println(book.getTitle() + "\" By " + book.getAuthor() + " is a "
                        + book.getGenre() + " book.");
            } else System.out.println("Nothing is found.");
        }
    }

    public void searchByGenre(String genre) {
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                System.out.println(book.getTitle() + "\" By " + book.getAuthor() + " is a "
                        + book.getGenre() + " book.");
            } else System.out.println("Nothing is found.");
        }
    }

    public void searchByShelfCode(String codeShelf) {
        for (Book book : books) {
            if (book.getCodeShelf().equals(codeShelf)) {
                System.out.println(book.getTitle() + "\" By " + book.getAuthor() + " is on the shelf Number: "
                        + book.getCodeShelf());
            } else System.out.println("Nothing is found.");
        }
    }

    public void searchByTitleKeyword(String keyword) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book.getTitle() + "\" By " + book.getAuthor());
            } else System.out.println("Nothing is found.");
        }
    }

    public void printLibrary() {
        System.out.println("Library:");
        for (Book book : books) {
            System.out.println("- \"" + book.getTitle() + "\" By " + book.getAuthor());
        }
    }
}

class Book {
    private String title;
    private String author;
    private String genre;
    private String codeShelf;

    public Book(String title, String author, String genre, String codeShelf) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.codeShelf = codeShelf;
    }

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