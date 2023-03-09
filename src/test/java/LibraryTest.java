import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void tests() {
        Library library = new Library();
        Book book1 = new Book("Harry Potter", "J.K. Rowling", "Fantasy", "F1");
        Book book2 = new Book("Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "F2");
        Book book3 = new Book("The Hunger Games", "Suzanne Collins", "Philosophy", "F3");
        library.addBook(book1);
        library.addBook(book2);
        assertTrue(library.removeBook(book1));
        assertFalse(library.removeBook(book3));
        assertTrue(library.addBook(book3));
        assertTrue(library.addBook(book1));
        assertFalse(library.addBook(book2));
        library.changeTitle(book1, "Harry Potter and the Philosopher's Stone");
        assertEquals("Harry Potter and the Philosopher's Stone", book1.getTitle());
        library.changeAuthor(book1, "Rowling"); //
        assertEquals("Rowling", book1.getAuthor());
        library.changeGenre(book1, "Children's literature");
        assertEquals("Children's literature", book1.getGenre());
        library.moveBook(book1, "C1");
        assertEquals("C1", book1.getCodeShelf());
        assertEquals(List.of(book1), library.searchByAuthor("Rowling"));
        assertEquals(List.of(book2), library.searchByTitle("Lord of the Rings"));
        assertEquals(List.of(book3), library.searchByGenre("Philosophy"));
        library.changeGenre(book3, "Fantasy");
        assertEquals(List.of(book1), library.searchByShelfCode("C1"));
        assertEquals(List.of(book3), library.searchByTitleKeyword("Hunger"));
        assertEquals(List.of(book2, book3, book1), library.getBooks());
    }
}