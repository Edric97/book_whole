package test;

import org.junit.Test;
import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        Book book = new Book(1, "java core technology", new BigDecimal(58.5), "Henry", 68, 32, null);
        bookService.addBook(book);
    }

    @Test
    public void updateBook() {
        Book book = new Book(1, "java core technology", new BigDecimal(68.5), "Henry", 88, 12, null);
        bookService.updateBook(book);
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(1);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(1));
    }

    @Test
    public void queryBookByName() {
        System.out.println(bookService.queryBookByName("java core technology"));
    }

    @Test
    public void queryBookByAuthor() {
        System.out.println(bookService.queryBookByAuthor("Henry"));
    }

    @Test
    public void queryAllBooks() {
        System.out.println(bookService.queryAllBooks());
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page.getPageNo());
        System.out.println(page.getPageTotal());
        System.out.println(page.getPageTotalQuantity());
    }
}