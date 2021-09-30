package dao;

import pojo.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);

    int updateBook(Book book);

    int deleteBookById(Integer id);

    Book queryBookById(Integer id);

    Book queryBookByName(String name);

    List<Book> queryBookByAuthor(String author);

    List<Book> queryAllBooks();

    int getPageTotalQuantity();

    List<Book> queryConditionalBooks(int begin, int end);

    int getPageTotalQuantityByPrice(int min, int max);

    List<Book> queryConditionalBooksByPrice(int begin, int end, int min, int max);

    int updateBookSalesAndStockByBookIdAndQuantity(Integer bookId, Integer quantity);
}
