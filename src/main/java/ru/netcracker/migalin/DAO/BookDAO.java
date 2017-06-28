package ru.netcracker.migalin.DAO;

import ru.netcracker.migalin.entity.BooksEntity;

import java.util.List;

public interface BookDAO {
    void editBook(BooksEntity publisher);
    void deleteBook(int bookId);
    List<BooksEntity> getAllBooks();
    BooksEntity getBookById(int bookId);
}
