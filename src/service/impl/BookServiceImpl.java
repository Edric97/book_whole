package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;
import pojo.Book;
import pojo.Page;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public Book queryBookByName(String name) {
        return bookDao.queryBookByName(name);
    }

    @Override
    public List<Book> queryBookByAuthor(String author) {
        return bookDao.queryBookByAuthor(author);
    }

    @Override
    public List<Book> queryAllBooks() {
        return bookDao.queryAllBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {

        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);

        int pageTotalQuantity = bookDao.getPageTotalQuantity();
        page.setPageTotalQuantity(pageTotalQuantity);

        int pageTotal = pageTotalQuantity / pageSize;
        if (pageTotalQuantity % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;
        int end = pageSize;
        List<Book> items = bookDao.queryConditionalBooks(begin, end);
        page.setItems(items);

        return page;

    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {

        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);

        int pageTotalQuantity = bookDao.getPageTotalQuantityByPrice(min, max);
        page.setPageTotalQuantity(pageTotalQuantity);

        int pageTotal = pageTotalQuantity / pageSize;
        if (pageTotalQuantity % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;
        int end = pageSize;
        List<Book> items = bookDao.queryConditionalBooksByPrice(begin, end, min, max);
        page.setItems(items);

        return page;

    }

//    @Test
//    public void test() {
//        BookServiceImpl bookService = new BookServiceImpl();
//        for (Book book : bookService.pageByPrice(1, 15, 0, 50).getItems()) {
//            System.out.println(book);
//        }
//    }


    @Override
    public void updateBookSalesAndStockByBookIdAndQuantity(Integer bookId, Integer quantity) {
        bookDao.updateBookSalesAndStockByBookIdAndQuantity(bookId, quantity);
    }
}
