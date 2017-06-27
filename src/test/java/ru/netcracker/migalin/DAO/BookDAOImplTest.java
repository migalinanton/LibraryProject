package ru.netcracker.migalin.DAO;
import org.junit.Test;
import ru.netcracker.migalin.entity.BooksEntity;

import java.util.List;

public class BookDAOImplTest {
        BookDAO bookDAO = new BookDAOImpl();
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        BooksEntity booksEntity = new BooksEntity();

    @Test
    public void addBook() throws Exception {
        booksEntity.setAutor("Hello");
        booksEntity.setTitle("World");
        booksEntity.setYear("1990");
        booksEntity.setPublisher_id(publisherDAO.getPublisherById(5));
     //   bookDAO.addBook(booksEntity);
    }

    @Test
    public void deleteBook() throws Exception {
        bookDAO.deleteBook(112);
    }

    @Test
    public void updateBook() throws Exception {
        booksEntity.setIdbooks(1);
        booksEntity.setAutor("Hello");
        booksEntity.setTitle("World");
        booksEntity.setYear("1990");
        booksEntity.setPublisher_id(publisherDAO.getPublisherById(5));
   //     bookDAO.updateBook(booksEntity);
    }

    @Test
    public void getAllBooks() throws Exception {
        List<BooksEntity> allBooks = bookDAO.getAllBooks();
        for (BooksEntity booksEntity:
                allBooks) {
            System.out.println(booksEntity);
        }
    }

    @Test
    public void getBookById() throws Exception {
        BooksEntity bookById = bookDAO.getBookById(5);
        System.out.println(bookById);
    }


}
