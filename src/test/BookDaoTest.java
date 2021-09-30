package test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;
import pojo.Book;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        Book book = new Book(null, "java核心技术", new BigDecimal(88), "何塞", 68, 32, null);
        bookDao.addBook(book);
    }

    @Test
    public void updateBook() {
        Book book = new Book(1, "java core technology", new BigDecimal(88), "Henry", 68, 32, null);
        bookDao.updateBook(book);
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(1));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(1));
    }

    @Test
    public void queryBookByName() {
        System.out.println(bookDao.queryBookByName("java core technology"));
    }

    @Test
    public void queryBookByAuthor() {
        System.out.println(bookDao.queryBookByAuthor("Henry"));
    }

    @Test
    public void getPageTotalQuantity() {
        System.out.println(bookDao.getPageTotalQuantity());
    }

    @Test
    public void queryConditionalBooks() {
        for (Book book : bookDao.queryConditionalBooks(4, 4)) {
            System.out.println(book);
        }
    }
}