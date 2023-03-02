import java.util.Scanner;

public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("Hello! Welcome to your library! If you want help knowing the commands available, " +
                "enter \"help\".");
        while (!input.equals("quit")) {
            System.out.print("Enter a command: ");
            input = scanner.nextLine();
            String[] tokens = input.split("-");
            switch (tokens[0]) {
                case "add" -> {
                    String title = tokens[1];
                    String author = tokens[2];
                    String genre = tokens[3];
                    String shelfCode = tokens[4];
                    Book book = new Book(title, author, genre, shelfCode);
                    library.addBook(book);
                }
                case "searchByAuthor" -> {
                    String authorName = tokens[1];
                    library.searchByAuthor(authorName);
                }
                case "searchByTitle" -> {
                    String titleKeyword = tokens[1];
                    library.searchByTitle(titleKeyword);
                }
                case "searchByGenre" -> {
                    String genreName = tokens[1];
                    library.searchByGenre(genreName);
                }
                case "searchByShelfCode" -> {
                    String shelfCodeName = tokens[1];
                    library.searchByShelfCode(shelfCodeName);
                }
                case "searchByTitleKeyword" -> {
                    String keyword = tokens[1];
                    library.searchByTitleKeyword(keyword);
                }
                case "remove" -> {
                    String title = tokens[1];
                    String author = tokens[2];
                    Book bookToRemove = null;
                    for (Book book : library.books) {
                        if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                            bookToRemove = book;
                            break;
                        }
                    }
                    if (bookToRemove != null) {
                        library.removeBook(bookToRemove);
                    } else System.out.println("Book not found in the library.");
                }
                case "move" -> {
                    String title = tokens[1];
                    String author = tokens[2];
                    String newCodeShelf = tokens[3];
                    Book bookToMove = new Book(title, author, "", newCodeShelf);
                    library.moveBook(bookToMove, newCodeShelf);
                }
                case "changeTitle" -> {
                    String title = tokens[1];
                    String author = tokens[2];
                    String newTitle = tokens[3];
                    Book bookToChange = new Book(title, author, "", "");
                    library.changeTitle(bookToChange, newTitle);
                }
                case "changeAuthor" -> {
                    String title = tokens[1];
                    String author = tokens[2];
                    String newAuthor = tokens[3];
                    Book bookToChange = new Book(title, author, "", "");
                    library.changeAuthor(bookToChange, newAuthor);
                }
                case "changeGenre" -> {
                    String title = tokens[1];
                    String genre = tokens[2];
                    String newGenre = tokens[3];
                    Book bookToChange = new Book(title, genre, "", "");
                    library.changeGenre(bookToChange, newGenre);
                }

                case "print" -> {
                    if (library.books.isEmpty()) {
                        System.out.println("The library is empty.");
                    } else library.printLibrary();
                }

                case "help" -> {
                    System.out.println("Available commands:");
                    System.out.println("To add a book, use this syntax: add-title-author-genre-shelfCode");
                    System.out.println("To search for a book by Author Name, use this syntax: " +
                            "searchByAuthor-authorName");
                    System.out.println("To search for a book by Title, use this syntax: searchByTitle-titleKeyword");
                    System.out.println("To search for a book by Genre, use this syntax: searchByGenre-genreName");
                    System.out.println("To search for a book by Shelf Code, use this syntax: " +
                            "searchByShelfCode-shelfCodeName");
                    System.out.println("To search for a book by Title Keyword, use this syntax: " +
                            "searchByTitleKeyword-keyword");
                    System.out.println("To remove a book, use this syntax: remove-title-author");
                    System.out.println("To move a book, use this syntax: move-title-author-shelfCode");
                    System.out.println("To change The Title, use this syntax: " +
                            "changeTitle-title-author-newTitle");
                    System.out.println("To change The Author name, use this syntax: " +
                            "changeAuthor-title-author-newAuthor");
                    System.out.println("To change The Genre, use this syntax: changeGenre-title-author-newGenre");
                    System.out.println("print");
                    System.out.println("help");
                }
                case "quit" -> System.out.println("Goodbye !");
                default -> System.out.println("Invalid command. Type \"help\" for a list of available commands.");
            }
        }
    }
}