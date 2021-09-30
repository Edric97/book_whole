package dao.impl;

import dao.BookDao;
import org.junit.Test;
import pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(id, name, price, author, sales, stock, imgPath) values(?,?,?,?,?,?,?)";
        return update(sql, book.getId(), book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name = ?, price = ?, author = ?, sales = ?, stock = ?, imgPath = ? where id = ?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id, name, price, author, sales, stock, imgPath from t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public Book queryBookByName(String name) {
        String sql = "select id, name, price, author, sales, stock, imgPath from t_book where name = ?";
        return queryForOne(Book.class, sql, name);
    }

    @Override
    public List<Book> queryBookByAuthor(String author) {
        String sql = "select id, name, price, author, sales, stock, imgPath from t_book where author = ?";
        return queryForList(Book.class, sql, author);
    }

    @Override
    public List<Book> queryAllBooks() {
        String sql = "select id, name, price, author, sales, stock, imgPath from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public List<Book> queryConditionalBooks(int begin, int end) {
        String sql = "select id, name, price, author, sales, stock, imgPath from t_book limit ?, ?";
        return queryForList(Book.class, sql, begin, end);
    }

    @Override
    public int getPageTotalQuantity() {
        String sql = "select count(*) from t_book";
        Number number = (Number) querySingleValue(sql);
        return number.intValue();
    }

    @Override
    public int getPageTotalQuantityByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number number = (Number) querySingleValue(sql, min, max);
        return number.intValue();
    }


    @Override
    public List<Book> queryConditionalBooksByPrice(int begin, int end, int min, int max) {
        String sql = "select id, name, price, author, sales, stock, imgPath from t_book where price between ? and ? order by price limit ?, ?";
        return queryForList(Book.class, sql, min, max, begin, end);
    }

    @Override
    public int updateBookSalesAndStockByBookIdAndQuantity(Integer bookId, Integer quantity) {
        String sql = "update t_book set stock = stock - ? , sales = sales + ? where id = ?";
        return update(sql, quantity, quantity, bookId);
    }
}
