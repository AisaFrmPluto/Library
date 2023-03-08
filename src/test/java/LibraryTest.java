import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LibraryTest {
    private static Library library;
    private static Book book1;
    private static Book book2;
    private static Book book3;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Harry Potter", "J.K. Rowling", "Fantasy", "F1");
        book2 = new Book("Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "F2");
        book3 = new Book("The Hunger Games", "Suzanne Collins", "Philosophy", "F3");
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void tests() {
        Assertions.assertTrue(library.removeBook(book1));
        Assertions.assertFalse(library.removeBook(book3));
        Assertions.assertTrue(library.addBook(book3));
        Assertions.assertTrue(library.addBook(book1));
        Assertions.assertFalse(library.addBook(book2));
        library.changeTitle(book1, "Harry Potter and the Philosopher's Stone");
        Assertions.assertEquals("Harry Potter and the Philosopher's Stone", book1.getTitle());
        library.changeAuthor(book1, "Rowling"); //
        Assertions.assertEquals("Rowling", book1.getAuthor());
        library.changeGenre(book1, "Children's literature");
        Assertions.assertEquals("Children's literature", book1.getGenre());
        library.moveBook(book1, "C1");
        Assertions.assertEquals("C1", book1.getCodeShelf());
        Assertions.assertEquals(List.of(book1), library.searchByAuthor("Rowling"));
        Assertions.assertEquals(List.of(book2), library.searchByTitle("Lord of the Rings"));
        Assertions.assertEquals(List.of(book3), library.searchByGenre("Philosophy"));
        Assertions.assertEquals(List.of(book1), library.searchByShelfCode("C1"));
        Assertions.assertEquals(List.of(book3), library.searchByTitleKeyword("Hunger"));
        Assertions.assertEquals(List.of(book2, book3, book1), library.getBooks());
    }
}