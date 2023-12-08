import com.workintech.library.Library;
import com.workintech.library.books.Book;
import com.workintech.library.books.book_enums.BookGenre;
import com.workintech.library.books.book_enums.Condition;
import com.workintech.library.person.Author;
import com.workintech.library.person.Librarian;
import com.workintech.library.person.Reader;
import com.workintech.library.person.person_enum.Role;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> returnedBooks = new ArrayList<>();
        Librarian librarian = new Librarian(0, "Ege Su Acikgoz", "666666");
        Library library = new Library(new ArrayList<>(), new HashSet<>(), new HashSet<>(), new HashMap<>(), returnedBooks, librarian);

        Author author1 = new Author(1, "Isaac Asimov", Role.AUTHOR, "IsaacA");
        Author author2 = new Author(2, "Arthur C. Clarke", Role.AUTHOR, "AClarke");
        Author author3 = new Author(3, "Dan BROWN", Role.AUTHOR, "R.Langdon");
        Author author4 = new Author(4, "Tolkien", Role.AUTHOR, "Frodo123");
        Author author5 = new Author(5, "Recaizade Mahmut Ekrem", Role.AUTHOR, "ARABAM");

        Book book1 = new Book(1, "I, Robot", "Isaac Asimov", 19.99, Condition.FACTORY_NEW, BookGenre.SCI_FI);
        Book book2 = new Book(2, "A Space Odyssey", "Arthur C. Clarke", 14.99, Condition.FIELD_TESTED, BookGenre.SCI_FI);
        Book book3 = new Book(3, "Da Vinci's Code", "Dan Brown", 24.99, Condition.MINIMAL_WEAR, BookGenre.CRIME);
        Book book4 = new Book(4, "Lord Of The Rings", "Tolkien", 9.99, Condition.BATTLE_SCARRED, BookGenre.HISTORY);
        Book book5 = new Book(5, "Araba Sevdasi", "Recaizade Mahmut Ekrem", 44.99, Condition.WELL_WORN, BookGenre.ACTION_ADVENTURE);

        Reader reader1 = new Reader(1, "Deniz Toptas");
        Reader reader2 = new Reader(2, "Ufuk Acar");
        Reader reader3 = new Reader(3, "Hamdi Bey");
        Reader reader4 = new Reader(4, "Ozan Tekiner");
        Reader reader5 = new Reader(5, "Ilksen Pakalin");

        library.getAuthors().add(author1);
        library.getAuthors().add(author2);
        library.getAuthors().add(author3);
        library.getAuthors().add(author4);
        library.getAuthors().add(author5);

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        library.getReaders().add(reader1);
        library.getReaders().add(reader2);
        library.getReaders().add(reader3);
        library.getReaders().add(reader4);
        library.getReaders().add(reader5);


        librarian.newBook(library.getBooks(),book4);
        System.out.println("-----------------------------");
        librarian.searchById(library.getBooks(), 2);
        System.out.println("-----------------------------");
        librarian.searchBookByTitle(library.getBooks(),"A Space Odyssey");
        System.out.println("-----------------------------");
        librarian.findAuthor(library.getAuthors(),"Tolkien");
        System.out.println("-----------------------------");
        librarian.updateBook(library.getBooks(),book5, Condition.FACTORY_NEW);
        System.out.println("-----------------------------");
        librarian.searchByGenre(library.getBooks(), BookGenre.SCI_FI);
        System.out.println("-----------------------------");
        librarian.getBookByAuthor(library.getBooks(),"Isaac Asimov");
        System.out.println("-----------------------------");
        librarian.borrowBook(library.getBooks(),library.getBooksBorrowed(), reader1, book4);
        System.out.println("-----------------------------");
        librarian.returnBook(library.getBooks(), book3);
        System.out.println("-----------------------------");
        librarian.refundToUser(library,library.getBooksBorrowed(), book4, reader1);
        System.out.println("-----------------------------");
    }
}