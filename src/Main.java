import com.workintech.library.Library;
import com.workintech.library.books.Book;
import com.workintech.library.books.book_enums.BookGenre;
import com.workintech.library.books.book_enums.Condition;
import com.workintech.library.person.Author;
import com.workintech.library.person.Librarian;
import com.workintech.library.person.Reader;
import com.workintech.library.person.person_enums.Role;

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


        /*librarian.newBook(library.getBooks(),book4);
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
        System.out.println("-----------------------------");*/
    Scanner scanner = new Scanner(System.in);
    int choice;
    int userChoice;
    int librarianChoice;
    int readerChoice;
    int authorChoice;
        do {
        System.out.println("Welcome !");
        System.out.println("************************");
        System.out.println("0 for stop the application.");
        System.out.println("1 for choose the user.");
        System.out.println("2 for show all the books in library.");
        choice = scanner.nextInt();
        switch (choice){
            case 0:
                System.out.println("The application is being stopped.");
                scanner.close();
                break;
            case 1:

                do {
                    System.out.println("********************************");
                    System.out.println("0 for the return the parent menu");
                    System.out.println("1 for the Librarian");
                    System.out.println("2 for the Reader");
                    System.out.println("3 for the Author");
                    userChoice = scanner.nextInt();
                    switch (userChoice){

                        case 1:
                            scanner.nextLine();
                            System.out.println("Enter your password :");
                            String password = scanner.nextLine();
                            if (library.checkPassword(librarian,password)) {
                                do {
                                    System.out.println("------------------------");
                                    System.out.println("0 for return the parent menu!");
                                    System.out.println("1 for add a book!");
                                    System.out.println("2 for delete a book!");
                                    System.out.println("3 for update a book!");
                                    System.out.println("4 for find a book!");
                                    librarianChoice = scanner.nextInt();
                                    switch (librarianChoice) {
                                        case 1:
                                            System.out.println("Book id :");
                                            long bookId = scanner.nextLong();
                                            System.out.println("Book title :");
                                            String bookTitle = scanner.nextLine();
                                            scanner.nextLine();
                                            System.out.println("Book author :");
                                            String bookAuthor = scanner.nextLine();
                                            scanner.nextLine();
                                            System.out.println("Book genre (Genre must be one of these : HORROR,ROMANCE,SCI_FI,CRIME,BIOGRAPHY,HISTORY,COOKBOOKS," +
                                                    "THRILLER, ACTION_ADVENTURE, ACADEMICAL:");
                                            String genre = scanner.nextLine().toUpperCase(Locale.ENGLISH);
                                            BookGenre genre1 = BookGenre.valueOf(genre);
                                            System.out.println("Book price: ");
                                            double price = scanner.nextDouble();
                                            Book newBook = new Book(bookId, bookTitle, bookAuthor,
                                                    price, Condition.FACTORY_NEW, genre1);
                                            librarian.newBook(library.getBooks(), newBook);
                                            break;
                                        case 2:
                                            scanner.nextLine();
                                            System.out.println(library.getBooks());
                                            System.out.println("Book Title: ");
                                            String bookName = scanner.nextLine();
                                            Book foundBook = librarian.searchBookByTitle(library.getBooks(), bookName);
                                            librarian.deleteBook(library.getBooks(), foundBook);
                                            System.out.println(library.getBooks());
                                            break;
                                        case 3:
                                            scanner.nextLine();
                                            System.out.println(library.getBooks());
                                            System.out.println("Book Title: ");
                                            String bookNameUpdate = scanner.nextLine();
                                            Book updateTheBook = librarian.searchBookByTitle(library.getBooks(), bookNameUpdate);
                                            System.out.println("New book price :");
                                            double updatedBookPrice = scanner.nextDouble();
                                            librarian.updateBook(library.getBooks(), updateTheBook, Condition.randomCondition());
                                            scanner.nextLine();
                                            System.out.println("New book status: ");
                                            System.out.println("Book status (Status must be one of these : FACTORY_NEW, MINIMAL_WEAR, FIELD_TESTED," +
                                                    " WELL_WORN, BATTLE_SCARRED) :");
                                            String bookCondition = scanner.nextLine().toUpperCase(Locale.ENGLISH);
                                            Condition condition = Condition.valueOf(bookCondition);
                                            librarian.updateBook(library.getBooks(), updateTheBook, condition);
                                            System.out.println(library.getBooks());
                                            break;
                                        case 4:
                                            scanner.nextLine();
                                            System.out.println("Find Book by Title: ");
                                            String bookByTitle = scanner.nextLine();
                                            librarian.searchBookByTitle(library.getBooks(), bookByTitle);
                                            System.out.println("Find Book by ID:");
                                            long bookById = scanner.nextLong();
                                            librarian.searchById(library.getBooks(), bookById);
                                            break;
                                        default:
                                            System.out.println("Please enter a valid book ID!");
                                            break;
                                    }
                                } while (librarianChoice != 0);
                            }else {
                                System.out.println("Invalid password. Try again!");
                            }
                            break;

                        case 2:
                            scanner.nextLine();
                            System.out.println(library.getReaders());
                            System.out.println("Select reader: ");
                            String readerName = scanner.nextLine();
                            Reader getReader = librarian.findReader(library.getReaders(), readerName);
                            if(library.getReaders().contains(getReader)){
                                do {
                                    System.out.println("********************");
                                    System.out.println("0 for return the parent menu");
                                    System.out.println("1 for borrow a book.");
                                    System.out.println("2 for return a book.");
                                    System.out.println("3 for get your balance info.");
                                    System.out.println("4 for to see your remaining limit.");
                                    readerChoice = scanner.nextInt();
                                    switch (readerChoice){
                                        case 1:
                                            scanner.nextLine();
                                            System.out.println(library.getBooks());
                                            System.out.println("Found it! \nBook's Name: ");
                                            String getBookName = scanner.nextLine();
                                            System.out.println("*******************");
                                            System.out.println("Your Bill: ");
                                            Book getBook = librarian.searchBookByTitle(library.getBooks(), getBookName);
                                            librarian.borrowBook(library.getBooks(), library.getBooksBorrowed(),getReader,getBook);
                                            assert getBook != null;
                                            assert getReader != null;
                                            librarian.paymentReceiving(getBook,getReader);
                                            System.out.println("*******************");

                                            break;
                                        case 2:
                                            scanner.nextLine();
                                            assert getReader != null;
                                            System.out.println(getReader.getBorrowed());
                                            if(getReader.getBorrowed() != null){
                                                System.out.println("Which book you want to return ?: ");
                                                String returnedBook = scanner.nextLine();
                                                Book getreturnedBook = librarian.searchBookByTitle(library.getBooks(), returnedBook);
                                                librarian.refundToUser(library, library.getBooksBorrowed(), getreturnedBook, getReader);
                                                System.out.println("Returned Books" + library.getReturnedBooks());
                                            }else {
                                                System.out.println("You haven't borrowed anything.");
                                            }
                                            break;
                                        case 3:
                                            assert getReader != null;
                                            System.out.println(getReader.getBalance());
                                            break;
                                        case 4:
                                            assert getReader != null;
                                            System.out.println(getReader.getBookLimit());
                                            break;
                                        default:
                                            System.out.println("Please enter a valid value!");
                                    }
                                } while (readerChoice != 0);
                            }else {
                                System.out.println("You are not a member!");
                            }
                            break;

                        case 3:
                            scanner.nextLine();
                            System.out.println(library.getAuthors());
                            System.out.println("Select author: ");
                            String authorName = scanner.nextLine();
                            Author getAuthor = librarian.findAuthor(library.getAuthors(), authorName);

                            if(library.getAuthors().contains(getAuthor)){
                                System.out.println("Enter password:");
                                String passwordAuthor = scanner.nextLine();
                                if (library.checkPassword(getAuthor, passwordAuthor)) {
                                    do {
                                        System.out.println("*******************");
                                        System.out.println("0 for return the parent menu");
                                        System.out.println("1 for add a book.");
                                        System.out.println("2 for delete a book.");
                                        System.out.println("3 for update a book.");
                                        System.out.println("4 for get the selected Author's books.");
                                        authorChoice = scanner.nextInt();
                                        switch (authorChoice) {
                                            case 1:
                                                List<Book> authorsBook = librarian.getBookByAuthor(library.getBooks(), authorName);
                                                System.out.println(authorsBook);
                                                System.out.println("Book id: ");
                                                long bookId = scanner.nextLong();
                                                scanner.nextLine();
                                                System.out.println("Book title: ");
                                                String bookTitle = scanner.nextLine();
                                                System.out.println("Book stock: ");
                                                int bookStock = scanner.nextInt();
                                                scanner.nextLine();
                                                System.out.println("Book type (Type must be one of these : FACTORY_NEW, MINIMAL_WEAR, FIELD_TESTED," +
                                                        " WELL_WORN, BATTLE_SCARRED) :");
                                                String bookGenre = scanner.nextLine().toUpperCase();
                                                BookGenre genre = BookGenre.valueOf(bookGenre);
                                                System.out.println("Book price: ");
                                                double bookPrice = scanner.nextDouble();

                                                assert getAuthor != null;
                                                Book newBook = new Book(bookId, bookTitle, getAuthor.getFullName(),20, Condition.FACTORY_NEW, genre);
                                                getAuthor.newBook(library.getBooks(), newBook);
                                                break;
                                            case 2:
                                                scanner.nextLine();
                                                List<Book> authorsBook2 = librarian.getBookByAuthor(library.getBooks(), authorName);
                                                System.out.println(authorsBook2);
                                                System.out.println("Book Title: ");
                                                String bookName = scanner.nextLine();
                                                Book foundBook = librarian.searchBookByTitle(library.getBooks(), bookName);
                                                assert getAuthor != null;
                                                assert foundBook != null;
                                                if (foundBook.getAuthor().contains(getAuthor.getFullName())) {
                                                    getAuthor.deleteBook(library.getBooks(), foundBook);
                                                    System.out.println(library.getBooks());
                                                } else {
                                                    System.out.println("You only can delete _your_ book.");
                                                }
                                                break;
                                            case 3:
                                                scanner.nextLine();
                                                System.out.println("MESSI");
                                                break;
                                            case 4:
                                                scanner.nextLine();
                                                System.out.println("Get author's book:");
                                                String author = scanner.nextLine();
                                                List<Book> authorsBook4 = librarian.getBookByAuthor(library.getBooks(), author);
                                                System.out.println(authorsBook4);
                                                break;
                                        }
                                    } while (authorChoice != 0);
                                } else {
                                    System.out.println("Invalid password!");
                                }
                            }else {
                                System.out.println("You are not a member.");
                            }
                            break;
                        default:
                            System.out.println("Please enter a valid value!");
                    }
                }while(userChoice != 0);
                break;
            case 2:
                System.out.println(library.getBooks());
                break;
            default:
                System.out.println("Please enter a valid value!");
        }
    }while (choice != 0);
}}