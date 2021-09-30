package service;

import pojo.Book;
import pojo.Page;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void updateBook(Book book);

    void deleteBookById(Integer id);

    Book queryBookById(Integer id);

    Book queryBookByName(String name);

    List<Book> queryBookByAuthor(String author);

    List<Book> queryAllBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);

    void updateBookSalesAndStockByBookIdAndQuantity(Integer bookId, Integer quantity);
}
